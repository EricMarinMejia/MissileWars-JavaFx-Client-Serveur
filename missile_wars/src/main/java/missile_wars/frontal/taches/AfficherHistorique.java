package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import missile_wars.commun.modeles.ModeleHistorique;
import missile_wars.frontal.vues.VueHistorique;

public class AfficherHistorique {
	
	public static void creerTaches(FrontendTasks tasks) {
		tasks.taskGroup("AfficherHistorique")
		.waitsFor("Initialisation")
		.andContains(subTasks -> {
			afficherHistorique(subTasks);
		});
	}
	
	private static void afficherHistorique(FrontendTasks subTasks) {
		
		subTasks.task("afficherHistorique")
		.waitsFor(modified(ModeleHistorique.class))
		.executes(inputs -> {
			VueHistorique vueHistorique = inputs.get(created(VueHistorique.class));
			Modified<ModeleHistorique> historique = inputs.get(modified(ModeleHistorique.class));
			
			ModeleHistorique ancienneListe = historique.previousValue();
			ModeleHistorique listeCourante = historique.currentValue();
			
			listeCourante.afficherSur(vueHistorique);
		});
	}
}