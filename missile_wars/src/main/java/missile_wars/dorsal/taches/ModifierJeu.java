package missile_wars.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.message;
import static ca.ntro.app.tasks.backend.BackendTasks.model;

import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.commun.messages.MsgAjouterPoint;
import missile_wars.commun.modeles.ModelePartie;

public class ModifierJeu {
	
	public static void creerTaches(BackendTasks tasks, String idPartie) {
		tasks.taskGroup("ModifierJeu" + "/" + idPartie)
		
		.waitsFor(model(ModelePartie.class, idPartie))
		
		.contains(subTasks -> {
			ajouterPoint(subTasks, idPartie);
		});
	}
	
	private static void ajouterPoint(BackendTasks tasks, String idPartie) {
		tasks.task("ajouterPoint" + "/" + idPartie)
		
		.waitsFor(message(MsgAjouterPoint.class, idPartie))
		
		.thenExecutes(inputs -> {
				
			MsgAjouterPoint msgAjouterPoint = inputs.get(message(MsgAjouterPoint.class));
			ModelePartie jeu = inputs.get(model(ModelePartie.class));
			
			msgAjouterPoint.copierDonneesDans(jeu);
			msgAjouterPoint.ajouterPointA(jeu);
		});
	}
	
}
