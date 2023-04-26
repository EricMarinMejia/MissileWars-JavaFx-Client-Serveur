package missile_wars.frontal.taches;


import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.event;
import static ca.ntro.app.tasks.frontend.FrontendTasks.modified;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import missile_wars.commun.modeles.ModeleInscriptionJoueur;
import missile_wars.frontal.evenements.EvtRemettreInfosActuelles;
import missile_wars.frontal.evenements.EvtRemettreTouchesParDefaut;
import missile_wars.frontal.vues.VueInscription;


public class AfficherSInscrire {
	
	
	public static void creerTaches(FrontendTasks tasks) {
		tasks.taskGroup("AfficherSInscrire")
		
		.waitsFor("Initialisation")
		
		.andContains(subTasks -> {
			
			//prêt à observer le modèle
			afficherSInscrire(subTasks);
			
			remettreTouchesParDefaut(subTasks);
			remettreInfosActuelles(subTasks);
			
		});
		
	}
	
	
	
	public static void afficherSInscrire(FrontendTasks tasks) {
		
		tasks.task("afficherSInscrire")
		.waitsFor(created(VueInscription.class))
		.waitsFor(modified(ModeleInscriptionJoueur.class))
		
		.executes(inputs -> {
					
			VueInscription vueSInscrire = inputs.get(created(VueInscription.class));
			Modified<ModeleInscriptionJoueur> inscriptionJoueur = inputs.get(modified(ModeleInscriptionJoueur.class));
			
			ModeleInscriptionJoueur previous = inscriptionJoueur.previousValue();
			ModeleInscriptionJoueur current = inscriptionJoueur.currentValue();
			
			vueSInscrire.memoriserNomJoueur(current.getNomJoueur());
			vueSInscrire.memoriserTouches(current.getTouches());
			
			vueSInscrire.viderTouches();
			vueSInscrire.afficherNom(current.getNomJoueur());
			for (String key : current.getTouches().keySet()) {
				vueSInscrire.afficherTouche(key, current.getTouches().get(key));
			}
			
//			current.afficherSur(vueSInscrire);
			
			
		});
		
	}
	
	public static void remettreTouchesParDefaut(FrontendTasks tasks) {
		tasks.task("remettreTouchesParDefaut")
		.waitsFor(created(VueInscription.class))
		.waitsFor(event(EvtRemettreTouchesParDefaut.class))
		.executes(inputs -> {
			
			VueInscription vueSInscrire = inputs.get(created(VueInscription.class));
			vueSInscrire.remettreTouchesParDefaut();
			
		});
	}
	
	

	public static void remettreInfosActuelles(FrontendTasks tasks) {
		tasks.task("remettreInfosActuelles")
		.waitsFor(event(EvtRemettreInfosActuelles.class))
		.executes(inputs -> {
			
			VueInscription vueSInscrire = inputs.get(created(VueInscription.class));
			vueSInscrire.remettreInfosActuelles();
			
		});
	}
	
	
	
	
	
	
}


























