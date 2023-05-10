package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.clock;
import static ca.ntro.app.tasks.frontend.FrontendTasks.create;
import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.event;
import static ca.ntro.app.tasks.frontend.FrontendTasks.message;
import static ca.ntro.app.tasks.frontend.FrontendTasks.modified;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.NtroApp;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import ca.ntro.core.reflection.observer.Modified;
import ca.ntro.core.task_graphs.task_graph.Task;
import missile_wars.commun.messages.MsgAjouterReferenceJoueurAPartie;
import missile_wars.commun.messages.MsgNouveauIdPartieBroadcast;
import missile_wars.commun.modeles.ModelePartie;
import missile_wars.frontal.donnees.DonneesVuePartie;
import missile_wars.frontal.evenements.EvtAfficherPartie;
import missile_wars.frontal.evenements.EvtUtilisateurACreeNouvellePartie;
import missile_wars.frontal.vues.VuePartie;

public class AfficherPartie {

	public static void creerTachesStatiques(FrontendTasks tasks) {
		tasks.taskGroup("AfficherPartie")
				.waitsFor("Initialisation")
				.andContains(subTasks -> {
					utilisateurACreeNouvellePartie(subTasks);
					creerEcouterMsgNouveauIdPartieBroadcast(subTasks);
				});
	}

	// quand l'user crée une nouvelle partie, nous écoutons le prochain broadcast de
	// partie créé et on s'y connecte automatiquement
	private static void utilisateurACreeNouvellePartie(FrontendTasks subTasks) {
		subTasks.task("utilisateurACreeNouvellePartie")
				.waitsFor(event(EvtUtilisateurACreeNouvellePartie.class))
				.thenExecutes(inputs -> {

//					creerEcouterMsgNouveauIdPartieBroadcast(subTasks);
					ecouterNextMsgNouveauIdPartieBroadcastTask = true;

				});
	}

	private static boolean ecouterNextMsgNouveauIdPartieBroadcastTask = false; // TODO: demander au prof comment en faire une tâche qui est créé et supprimé dynamiquement (sans le crash que j'avais)

	private static void creerEcouterMsgNouveauIdPartieBroadcast(FrontendTasks subTasks) {
		subTasks.task("ecouterMsgNouveauIdPartieBroadcast")
				.waitsFor(message(MsgNouveauIdPartieBroadcast.class))
				.thenExecutes(inputs -> {
					
					if (ecouterNextMsgNouveauIdPartieBroadcastTask) {
						MsgNouveauIdPartieBroadcast msgNouveauIdPartieBroadcast = inputs.get(message(MsgNouveauIdPartieBroadcast.class));

						String idPartie = msgNouveauIdPartieBroadcast.getIdPartie();

						EvtAfficherPartie evtAfficherPartie = NtroApp.newEvent(EvtAfficherPartie.class);
						evtAfficherPartie.setIdPartie(idPartie);
						evtAfficherPartie.trigger();
						
						
						MsgAjouterReferenceJoueurAPartie msgAjouterReferenceJoueurAPartie = NtroApp.newMessage(MsgAjouterReferenceJoueurAPartie.class);
						msgAjouterReferenceJoueurAPartie.setIdJoueur(Session.idJoueur);
						msgAjouterReferenceJoueurAPartie.setIdPartie(idPartie);
						msgAjouterReferenceJoueurAPartie.send();

					}
					
//					ecouterMsgNouveauIdPartieBroadcastTask.removeFromGraph();
//					ecouterMsgNouveauIdPartieBroadcastTask = null;
					
				});
	}

	private static List<Task> tachesDynamiques = new ArrayList<>();

	public static void supprimerTachesDynamiques() {
		
		for (Task tache : tachesDynamiques) {
			tache.removeFromGraph();
		}
		tachesDynamiques.clear();
	}

	public static void creerTachesDynamiques(FrontendTasks tasks, String idPartie) {

		tachesDynamiques.add(creerDonneesVuePartie(tasks, idPartie));

		tasks.taskGroup("AfficherPartieDynamique")
		.waitsFor(created(VuePartie.class))
				.waitsFor(created(DonneesVuePartie.class))
				.andContains(subTasks -> {

					observerModelPartie(subTasks, idPartie);
					prochaineImagePartie(subTasks);

				});
	}

	private static Task creerDonneesVuePartie(FrontendTasks tasks, String idPartie) {

		return tasks.task(create(DonneesVuePartie.class))

				.executesAndReturnsCreatedValue(inputs -> {

					return new DonneesVuePartie();
				}).getTask();
	}
	
	private static void observerModelPartie(FrontendTasks subTasks, String idPartie) {
		subTasks.task("observerModelePartie")
		.waitsFor(modified(ModelePartie.class, idPartie))
		.thenExecutes(inputs -> {
			VuePartie vuePartie = inputs.get(created(VuePartie.class));
			DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
			
			Modified<ModelePartie> modifiedModelePartie = inputs.get(modified(ModelePartie.class, idPartie));
			ModelePartie current = modifiedModelePartie.currentValue();
			
			donneesVuePartie.memoriserIdJoueur(Session.idJoueur); //TODO: demander au prof comment stoquer/communiquer correctement l'id du joueur.
			donneesVuePartie.memoriserIdPartie(idPartie);
			current.copierDonneesDans(donneesVuePartie);
			
			
		});
	}

	// ajouter la méthode
	private static void prochaineImagePartie(FrontendTasks subTasks) {

		subTasks.task("prochaineImagePartie")
				
		.waitsFor(created(VuePartie.class))
		.waitsFor(clock().nextTick())
		
				.thenExecutes(inputs -> {

					Tick tick = inputs.get(clock().nextTick());

					DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
					VuePartie vuePartie = inputs.get(created(VuePartie.class));

					donneesVuePartie.reagirTempsQuiPasse(tick.elapsedTime());

					donneesVuePartie.afficherSur(vuePartie);
				});
	}

}
