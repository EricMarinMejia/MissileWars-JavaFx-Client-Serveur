package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.create;
import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.event;
import static ca.ntro.app.tasks.frontend.FrontendTasks.message;

import ca.ntro.app.NtroApp;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.task_graphs.task_graph.Task;
import missile_wars.commun.messages.MsgDemandeNouveauJoueur;
import missile_wars.commun.messages.MsgJoueurExiste;
import missile_wars.commun.messages.MsgNouveauIdJoueurBroadcast;
import missile_wars.frontal.donnees.DonneesSession;
import missile_wars.frontal.evenements.EvtEnvoyerSignalJoueurExiste;
import missile_wars.frontal.evenements.EvtIdJoueurMemorise;

public class Session {
	
	public static void creerTaches(FrontendTasks tasks) {
		creerDonneesSession(tasks);

		tasks.taskGroup("Session")
		.waitsFor(created(DonneesSession.class))
		.andContains(subTasks -> {
			recevoirNouveauIdJoueur(subTasks);
			demanderNouveauIdJoueur(subTasks);
			envoyerSignalJoueurExiste(subTasks);
		});
	}
	
	
	private static void creerDonneesSession(FrontendTasks tasks) {
		tasks.task(create(DonneesSession.class))
//		.waitsFor("Initialisation")
		.executesAndReturnsCreatedValue(inputs -> {
			return new DonneesSession();
		});
	}
	
	
	private static void demanderNouveauIdJoueur(FrontendTasks subTasks) {
		subTasks.task("demanderNouveauIdJoueur")
//		.waitsFor("Initialisation")
		.thenExecutes(inputs -> {
			MsgDemandeNouveauJoueur msg = NtroApp.newMessage(MsgDemandeNouveauJoueur.class);
			msg.send();
		});
	}
	
	
	private static int envoyerSignalJoueurExisteTickSkip = 0; 
	private static void envoyerSignalJoueurExiste(FrontendTasks subTasks) {
		EvtEnvoyerSignalJoueurExiste evtEnvoyerSignalJoueurExiste = NtroApp.newEvent(EvtEnvoyerSignalJoueurExiste.class);
		Interval.ajouterMethode(() -> {
			envoyerSignalJoueurExisteTickSkip--;
			if (envoyerSignalJoueurExisteTickSkip <= 0) {
				envoyerSignalJoueurExisteTickSkip = 60;
				if (idJoueur >= 0) {
					
					evtEnvoyerSignalJoueurExiste.trigger();
					
				}
			}
		});
		
		subTasks.task("envoyerSignalJoueurExiste")
        .waitsFor(event(EvtEnvoyerSignalJoueurExiste.class))
		.thenExecutes(inputs -> {
			MsgJoueurExiste msg = NtroApp.newMessage(MsgJoueurExiste.class);
			msg.setIdJoueur(idJoueur);
			msg.send();
		});
	}
	
	
	public static int idJoueur = -1; //le prof a dis que c'était satisfesant
	
	
	private static Task recevoirTask = null;
	
	private static void recevoirNouveauIdJoueur(FrontendTasks subTasks) {
		recevoirTask = subTasks.task("recevoirNouveauIdJoueur")
		.waitsFor(message(MsgNouveauIdJoueurBroadcast.class))
		.thenExecutes(inputs -> {
			MsgNouveauIdJoueurBroadcast msg = inputs.get(message(MsgNouveauIdJoueurBroadcast.class));
			DonneesSession donneesSession = inputs.get(created(DonneesSession.class));
			
			donneesSession.setIdJoueur(msg.getIdJoueur());
			idJoueur = msg.getIdJoueur();
			System.out.println("NOUVEAU ID REÇU : " + String.valueOf(idJoueur));
			
			recevoirTask.removeFromGraph();
			
			
			EvtIdJoueurMemorise evtIdJoueurMemorise = NtroApp.newEvent(EvtIdJoueurMemorise.class);
			evtIdJoueurMemorise.trigger();
			
			
		}).getTask();
	}
	
	
}
