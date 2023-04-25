package missile_wars.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import ca.ntro.core.reflection.observer.Modified;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import missile_wars.commun.modeles.ModelePartie;
import missile_wars.frontal.donnees.DonneesVueJeu;
import missile_wars.frontal.evenements.EvtActionJoueur;
import missile_wars.frontal.vues.VueAccueil;

public class AfficherJeu {

	public static void creerTaches(FrontendTasks tasks) {
		creerDonneesVueJeu(tasks);
		
		tasks.taskGroup("AfficherJeu")
		
		.waitsFor(created(DonneesVueJeu.class))
		
		.andContains(subTasks -> {
			prochaineImageJeu(subTasks);
			observerModeleJeu(subTasks);
			reagirActionJoueur(subTasks);
		});
	}
	
	private static void reagirActionJoueur(FrontendTasks tasks) {
		tasks.task("reagirActionJoueur")
		
		.waitsFor(event(EvtActionJoueur.class))
		
		.thenExecutes(inputs -> {
			DonneesVueJeu donneesVueJeu = inputs.get(created(DonneesVueJeu.class));
			EvtActionJoueur evtActionJoueur = inputs.get(event(EvtActionJoueur.class));
			
			evtActionJoueur.appliquerA(donneesVueJeu);
		});
	}
	
	private static void creerDonneesVueJeu(FrontendTasks tasks) {
		tasks.task(create(DonneesVueJeu.class))

        .waitsFor("Initialisation")

        .executesAndReturnsCreatedValue(inputs -> {

            return new DonneesVueJeu();
        });
	}
	
	private static void prochaineImageJeu(FrontendTasks subTasks) {
		subTasks.task("prochaineImagePartie")
		
		.waitsFor(clock().nextTick())
		
		.thenExecutes(inputs -> {
		
			Tick tick = inputs.get(clock().nextTick());
			DonneesVueJeu donneesVueJeu = inputs.get(created(DonneesVueJeu.class));
			VueAccueil vueJeu = inputs.get(created(VueAccueil.class));
			
			donneesVueJeu.reagirTempsQuiPasse(tick.elapsedTime());
			donneesVueJeu.afficherSur(vueJeu);
		});
	}
	
	private static void observerModeleJeu(FrontendTasks tasks) {
		tasks.task("observerModeleJeu")
		
		.waitsFor(modified(ModelePartie.class))
		
		.thenExecutes(inputs -> {
			
			VueAccueil vueJeu = inputs.get(created(VueAccueil.class));
			DonneesVueJeu donneesVueJeu = inputs.get(created(DonneesVueJeu.class));
			Modified<ModelePartie> modifiedJeu = inputs.get(modified(ModelePartie.class));
			
			ModelePartie modeleJeu = modifiedJeu.currentValue();
			
			modeleJeu.afficherInfoPartieSur(vueJeu);
			modeleJeu.copierDonneesDans(donneesVueJeu);
			
		});
	}
}
