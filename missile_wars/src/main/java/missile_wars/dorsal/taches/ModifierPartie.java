package missile_wars.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.message;
import static ca.ntro.app.tasks.backend.BackendTasks.model;

import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.commun.messages.MsgAjouterPoint;
import missile_wars.commun.messages.MsgAjouterReferenceJoueurAPartie;
import missile_wars.commun.modeles.ModelePartie;
import missile_wars.dorsal.messages.MsgAjusterPartie;

public class ModifierPartie {
	
	public static void creerTaches(BackendTasks tasks, String idPartie) {
		tasks.taskGroup("ModifierPartie" + "/" + idPartie)
		
		.waitsFor(model(ModelePartie.class, idPartie))
		
		.contains(subTasks -> {
			msgAjusterPartie(subTasks, idPartie);
			msgAjouterReferenceJoueurAPartie(subTasks, idPartie);
			ajouterPoint(subTasks, idPartie);
		});
	}
	
	
	private static void msgAjusterPartie(BackendTasks subTasks, String idPartie) {
		subTasks.task("msgAjusterPartie/" + idPartie)
		.waitsFor(message(MsgAjusterPartie.class, idPartie))
		.thenExecutes(inputs -> {
			MsgAjusterPartie msgAjusterPartie = inputs.get(message(MsgAjusterPartie.class, idPartie));
			ModelePartie partie = inputs.get(model(ModelePartie.class, idPartie));
			
			partie.setIdPartie(idPartie);
			partie.setQuantiteJoueursCible(msgAjusterPartie.getQuantiteJoueursCible());
			
		});
	}
	
	private static void msgAjouterReferenceJoueurAPartie(BackendTasks subTasks, String idPartie) {
		subTasks.task("msgAjouterReferenceJoueurAPartie/" + idPartie)
		.waitsFor(message(MsgAjouterReferenceJoueurAPartie.class, idPartie))
		.thenExecutes(inputs -> {
			MsgAjouterReferenceJoueurAPartie msg = inputs.get(message(MsgAjouterReferenceJoueurAPartie.class, idPartie));
			ModelePartie partie = inputs.get(model(ModelePartie.class, idPartie));
			
			System.out.println("=========== " + String.valueOf(idPartie) + " " + String.valueOf(msg.getIdPartie()));
			
			partie.ajouterReferenceJoueur(msg.getIdJoueur());
			
		});
	}
	
	
	private static void ajouterPoint(BackendTasks subTasks, String idPartie) {
		subTasks.task("ajouterPoint" + "/" + idPartie)
		
		.waitsFor(message(MsgAjouterPoint.class, idPartie))
		
		.thenExecutes(inputs -> {
			
			MsgAjouterPoint msgAjouterPoint = inputs.get(message(MsgAjouterPoint.class, idPartie));
			ModelePartie partie = inputs.get(model(ModelePartie.class, idPartie));
			
			msgAjouterPoint.copierDonneesDans(partie);
			msgAjouterPoint.ajouterPointA(partie);
		});
	}
	
	
}
