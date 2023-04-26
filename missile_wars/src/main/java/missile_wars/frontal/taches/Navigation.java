package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.create;
import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.event;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.evenements.EvtAfficherDidacticiel;
import missile_wars.frontal.evenements.EvtAfficherFileAttente;
import missile_wars.frontal.evenements.EvtAfficherHistorique;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.vues.VueAccueil;
import missile_wars.frontal.vues.VueDidacticiel;
import missile_wars.frontal.vues.VueFileAttente;
import missile_wars.frontal.vues.VueHistorique;
import missile_wars.frontal.vues.VueRacine;

public class Navigation {
	
	public static void creerTaches(FrontendTasks tasks) {
		tasks.taskGroup("Navigation")
		.waitsFor("Initialisation")
		.andContains(subTasks -> {
			afficherVueHistorique(subTasks);
			afficherVueAccueil(subTasks);
			afficherVueFileAttente(subTasks);
			afficherVuePartie(subTasks);
			afficherVueDidacticiel(subTasks);
		});
		
	}
	
	private static void afficherVueAccueil(FrontendTasks subTasks) {
		subTasks.task("afficherVueAccueil")
		.waitsFor(create(VueAccueil.class))
		.waitsFor(event(EvtAfficherMenu.class))
		.thenExecutes(inputs -> {
			VueRacine vueRacine = inputs.get(created(VueRacine.class));
			VueAccueil vueAccueil = inputs.get(created(VueAccueil.class));
			
			vueRacine.afficherSousVue(vueAccueil);
		});
	}
	
	private static void afficherVueHistorique(FrontendTasks subTasks) {
		subTasks.task("afficherVueHistorique")
		.waitsFor(event(EvtAfficherHistorique.class))
		.thenExecutes(inputs -> {
			VueRacine vueRacine = inputs.get(created(VueRacine.class));
			VueHistorique vueHistorique = inputs.get(created(VueHistorique.class));
			
			vueRacine.afficherSousVue(vueHistorique);
		});
	}
	
	private static void afficherVueFileAttente(FrontendTasks subTasks) {
		subTasks.task("afficherVueFileAttente")
		.waitsFor(event(EvtAfficherFileAttente.class))
		.thenExecutes(inputs -> {
			VueRacine vueRacine = inputs.get(created(VueRacine.class));
			VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
			
			vueRacine.afficherSousVue(vueFileAttente);
		});
	}

	private static void afficherVuePartie(FrontendTasks subTasks) {
		
	}

    private static void afficherVueDidacticiel(FrontendTasks sousTaches) { 
        sousTaches.task("afficherVueDidacticiel")
        .waitsFor(event(EvtAfficherDidacticiel.class))
        .thenExecutes(entrees -> { 
            VueRacine vueRacine = entrees.get(created(VueRacine.class));
            VueDidacticiel vueDidacticiel = entrees.get(created(VueDidacticiel.class));
            vueRacine.afficherSousVue(vueDidacticiel);
        });
    }
	
}