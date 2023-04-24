package missile_wars.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.commun.messages.MsgAjouterPoint;
import missile_wars.commun.modeles.ModeleJeu;

public class ModifierJeu {
	
	public static void creerTaches(BackendTasks tasks) {
		tasks.taskGroup("ModifierJeu")
		
		.waitsFor(model(ModeleJeu.class))
		
		.contains(subTasks -> {
			ajouterPoint(subTasks);
		});
	}
	
	private static void ajouterPoint(BackendTasks tasks) {
		tasks.task("ajouterPoint")
		
		.waitsFor(message(MsgAjouterPoint.class))
		
		.thenExecutes(inputs -> {
				
			MsgAjouterPoint msgAjouterPoint = inputs.get(message(MsgAjouterPoint.class));
			ModeleJeu jeu = inputs.get(model(ModeleJeu.class));
			
			msgAjouterPoint.copierDonneesDans(jeu);
			msgAjouterPoint.ajouterPointA(jeu);
		});
	}
	
}
