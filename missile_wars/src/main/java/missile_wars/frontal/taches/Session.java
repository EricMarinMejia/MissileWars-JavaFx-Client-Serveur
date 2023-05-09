package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.clock;
import static ca.ntro.app.tasks.frontend.FrontendTasks.message;

import ca.ntro.app.NtroApp;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.task_graphs.task_graph.Task;
import missile_wars.commun.messages.MsgDemandeNouveauJoueur;
import missile_wars.commun.messages.MsgJoueurExiste;
import missile_wars.commun.messages.MsgNouveauIdJoueurBroadcast;

public class Session {
	
	public static void creerTaches(FrontendTasks tasks) {
		tasks.taskGroup("Session")
		.waitsFor("Initialisation")
		.andContains(subTasks -> {
			recevoirNouveauIdJoueur(subTasks);
			demanderNouveauIdJoueur(subTasks);
			envoyerSignalJoueurExiste(subTasks);
		});
	}

	
	private static void demanderNouveauIdJoueur(FrontendTasks subTasks) {
		subTasks.task("demanderNouveauIdJoueur")
		.waitsFor("Initialisation")
		.thenExecutes(inputs -> {
			MsgDemandeNouveauJoueur msg = NtroApp.newMessage(MsgDemandeNouveauJoueur.class);
			msg.send();
		});
	}
	
	
	// TODO : quand on va dans la page didacticiel et qu'on revient au menu, l'envois du signal arrête. demander au prof pourquoi.
	
	private static int envoyerSignalJoueurExisteTickSkip = 0; 
	private static void envoyerSignalJoueurExiste(FrontendTasks subTasks) {
		subTasks.task("envoyerSignalJoueurExiste")
        .waitsFor(clock().nextTick())
		.thenExecutes(inputs -> {
			envoyerSignalJoueurExisteTickSkip--;
			if (envoyerSignalJoueurExisteTickSkip <= 0) {
				envoyerSignalJoueurExisteTickSkip = 60;
				if (idJoueur >= 0) {
					
					MsgJoueurExiste msg = NtroApp.newMessage(MsgJoueurExiste.class);
					msg.setIdJoueur(idJoueur);
					msg.send();
					
				}
			}
		});
	}
	
	
	public static int idJoueur = -1;
	
	
	private static Task recevoirTask = null;
	
	private static void recevoirNouveauIdJoueur(FrontendTasks subTasks) {
//		subTasks.task("recevoirNouveauIdJoueur")
//		.waitsFor(message(MsgNouveauIdJoueurBroadcast.class))
//		.thenExecutes(inputs -> {
//			MsgNouveauIdJoueurBroadcast msg = inputs.get(message(MsgNouveauIdJoueurBroadcast.class));
//			
//			idJoueur = msg.getIdJoueur();
//			//recevoirTask.removeFromGraph();
//			
//		});
		recevoirTask = subTasks.task("recevoirNouveauIdJoueur")
		.waitsFor(message(MsgNouveauIdJoueurBroadcast.class))
		.thenExecutes(inputs -> {
			MsgNouveauIdJoueurBroadcast msg = inputs.get(message(MsgNouveauIdJoueurBroadcast.class));
			
			idJoueur = msg.getIdJoueur();
			recevoirTask.removeFromGraph();
			
		}).getTask();
	}
	
	
}
