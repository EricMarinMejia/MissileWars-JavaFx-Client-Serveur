package missile_wars.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.message;
import static ca.ntro.app.tasks.backend.BackendTasks.model;

import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.commun.messages.MsgAjouterPoint;
import missile_wars.commun.messages.MsgAjouterReferenceJoueurAPartie;
import missile_wars.commun.modeles.ModelePartie;

public class ModifierPartie {
	
	public static void creerTaches(BackendTasks tasks, String idPartie) {
		tasks.taskGroup("ModifierJeu" + "/" + idPartie)
		
		.waitsFor(model(ModelePartie.class, idPartie))
		
		.contains(subTasks -> {
			msgAjouterReferenceJoueurAPartie(subTasks, idPartie);
			ajouterPoint(subTasks, idPartie);
		});
	}
	
	private static void msgAjouterReferenceJoueurAPartie(BackendTasks subTasks, String idPartie) {
		subTasks.task("msgAjouterReferenceJoueurAPartie")
		.waitsFor(message(MsgAjouterReferenceJoueurAPartie.class, idPartie))
		.thenExecutes(inputs -> {
			MsgAjouterReferenceJoueurAPartie msg = inputs.get(message(MsgAjouterReferenceJoueurAPartie.class));
			ModelePartie partie = inputs.get(model(ModelePartie.class, idPartie));
			
			partie.ajouterReferenceJoueur(msg.getIdJoueur());
			
		});
	}
	
	
	private static void ajouterPoint(BackendTasks subTasks, String idPartie) {
		subTasks.task("ajouterPoint" + "/" + idPartie)
		
		.waitsFor(message(MsgAjouterPoint.class, idPartie))
		
		.thenExecutes(inputs -> {
				
			MsgAjouterPoint msgAjouterPoint = inputs.get(message(MsgAjouterPoint.class));
			ModelePartie partie = inputs.get(model(ModelePartie.class, idPartie));
			
			msgAjouterPoint.copierDonneesDans(partie);
			msgAjouterPoint.ajouterPointA(partie);
		});
	}
	
	
}
