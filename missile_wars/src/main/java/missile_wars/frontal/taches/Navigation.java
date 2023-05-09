package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.event;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.donnees.DonneesSession;
import missile_wars.frontal.evenements.EvtAfficherDidacticiel;
import missile_wars.frontal.evenements.EvtAfficherFileAttente;
import missile_wars.frontal.evenements.EvtAfficherHistorique;
import missile_wars.frontal.evenements.EvtAfficherInscription;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.evenements.EvtAfficherParametres;
import missile_wars.frontal.evenements.EvtAfficherPartie;
import missile_wars.frontal.vues.VueDidacticiel;
import missile_wars.frontal.vues.VueFileAttente;
import missile_wars.frontal.vues.VueHistorique;
import missile_wars.frontal.vues.VueInscription;
import missile_wars.frontal.vues.VueMenu;
import missile_wars.frontal.vues.VueParametres;
import missile_wars.frontal.vues.VuePartie;
import missile_wars.frontal.vues.VueRacine;

public class Navigation {
	
	public static void creerTaches(FrontendTasks tasks) {
		tasks.taskGroup("Navigation")
		.waitsFor("Initialisation")
		.andContains(subTasks -> {
			afficherVueHistorique(subTasks);
			afficherVueFileAttente(subTasks);
			afficherVuePartie(subTasks, tasks);
			afficherVueDidacticiel(subTasks, tasks);
			afficherVueMenu(subTasks);
			afficherVueParametres(subTasks);
			afficherVueInscription(subTasks);
		});
		
	}
	
	
	private static void supprimerTachesDynamiques() {
		AfficherDidacticiel.supprimerTachesDynamiques();
		AfficherPartie.supprimerTachesDynamiques();
	}
	
	
	private static void afficherVueHistorique(FrontendTasks subTasks) {
		subTasks.task("afficherVueHistorique")
		.waitsFor(event(EvtAfficherHistorique.class))
		.thenExecutes(inputs -> {
			supprimerTachesDynamiques();
			VueRacine vueRacine = inputs.get(created(VueRacine.class));
			VueHistorique vueHistorique = inputs.get(created(VueHistorique.class));
			
			vueRacine.afficherSousVue(vueHistorique);
		});
	}
	
	private static void afficherVueFileAttente(FrontendTasks subTasks) {
		subTasks.task("afficherVueFileAttente")
		.waitsFor(event(EvtAfficherFileAttente.class))
		.thenExecutes(inputs -> {
			supprimerTachesDynamiques();
			VueRacine vueRacine = inputs.get(created(VueRacine.class));
			VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
			
			vueRacine.afficherSousVue(vueFileAttente);
		});
	}
	
	private static void afficherVueMenu(FrontendTasks subTasks) {
		subTasks.task("afficherVueMenu")
		.waitsFor(event(EvtAfficherMenu.class))
		.thenExecutes(inputs -> {
			supprimerTachesDynamiques();
			VueRacine vueRacine = inputs.get(created(VueRacine.class));
			VueMenu vueMenu = inputs.get(created(VueMenu.class));
			
			vueRacine.afficherSousVue(vueMenu);
		});
	}

	private static void afficherVuePartie(FrontendTasks subTasks, FrontendTasks tasks) {
		subTasks.task("afficherVuePartie")
        .waitsFor(event(EvtAfficherPartie.class))
        .thenExecutes(entrees -> { 
			supprimerTachesDynamiques();
            VueRacine vueRacine = entrees.get(created(VueRacine.class));
            VuePartie vuePartie = entrees.get(created(VuePartie.class));
            vueRacine.afficherSousVue(vuePartie);
            
            AfficherPartie.creerTaches(tasks);
        });
	}

    private static void afficherVueParametres(FrontendTasks subTasks) {
    	subTasks.task("afficherVueParametres")
        .waitsFor(event(EvtAfficherParametres.class))
        .thenExecutes(entrees -> { 
			supprimerTachesDynamiques();
            VueRacine vueRacine = entrees.get(created(VueRacine.class));
            VueParametres vueParametres = entrees.get(created(VueParametres.class));
            vueRacine.afficherSousVue(vueParametres);
            
        });
    }
    
    private static void afficherVueInscription(FrontendTasks subTasks) {
    	subTasks.task("afficherVueInscription")
        .waitsFor(event(EvtAfficherInscription.class))
        .thenExecutes(entrees -> { 
			supprimerTachesDynamiques();
            VueRacine vueRacine = entrees.get(created(VueRacine.class));
            VueInscription vueInscription = entrees.get(created(VueInscription.class));
            vueRacine.afficherSousVue(vueInscription);
            
        });
    }

    private static void afficherVueDidacticiel(FrontendTasks sousTaches, FrontendTasks taches) {
        sousTaches.task("afficherVueDidacticiel")
        .waitsFor(event(EvtAfficherDidacticiel.class))
        .thenExecutes(entrees -> { 
			supprimerTachesDynamiques();
            VueRacine vueRacine = entrees.get(created(VueRacine.class));
            VueDidacticiel vueDidacticiel = entrees.get(created(VueDidacticiel.class));
            vueRacine.afficherSousVue(vueDidacticiel);
            
            AfficherDidacticiel.creerTaches(taches);
        });
    }
    
	
}