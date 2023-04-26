package missile_wars.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.commun.messages.MsgRetirerPartie;
import missile_wars.commun.modeles.ModeleHistorique;

public class ModifierHistorique {
	
	public static void creerTaches(BackendTasks tasks) {
		tasks.taskGroup("ModifierHistorique")
		
		.waitsFor(model(ModeleHistorique.class))
		
		.andContains(subTasks -> {
			retirerPartie(subTasks);
		});
	}
	
	private static void retirerPartie(BackendTasks subTasks) {
		subTasks.task("retirerPartie")
		
		.waitsFor(message(MsgRetirerPartie.class))
		
		.thenExecutes(inputs -> {
			
			MsgRetirerPartie msgRetirerPartie = inputs.get(message(MsgRetirerPartie.class));
			ModeleHistorique historique = inputs.get(model(ModeleHistorique.class));
			
			msgRetirerPartie.retirerDe(historique);
		});
	}
	
}