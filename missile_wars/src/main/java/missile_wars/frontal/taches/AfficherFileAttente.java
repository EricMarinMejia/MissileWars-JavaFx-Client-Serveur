package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.modified;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import missile_wars.commun.modeles.ModeleFileAttente;
import missile_wars.frontal.vues.VueFileAttente;

public class AfficherFileAttente {
	
	public static void creerTaches(FrontendTasks tasks) {
		tasks.taskGroup("AfficherFileAttente")
		.waitsFor("Initialisation")
		.andContains(subTasks -> {
			afficherFileAttente(subTasks);
		});
	}
	
	private static void afficherFileAttente(FrontendTasks subTasks) {
		subTasks.task("afficherFileAttente")
		.waitsFor(created(VueFileAttente.class))
		.waitsFor(modified(ModeleFileAttente.class))
		.executes(inputs -> {
			VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
			Modified<ModeleFileAttente> fileAttente = inputs.get(modified(ModeleFileAttente.class));
			
			ModeleFileAttente valeurActuelle = fileAttente.currentValue();

//			System.out.println("afficherFileAttente : " + String.valueOf(Session.idJoueur));
			vueFileAttente.memoriserIdJoueur(Session.idJoueur);
			valeurActuelle.afficherSur(vueFileAttente);
			
		});
		
	}

}
