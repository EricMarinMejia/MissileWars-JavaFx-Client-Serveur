package missile_wars.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.*;
import missile_wars.commun.messages.*;
import missile_wars.commun.modeles.*;



public class ModifierInscriptionJoueur {
	
	
	public static void creerTaches(BackendTasks tasks) {
		
		tasks.taskGroup("ModifierInscriptionJoueur")
		.waitsFor(model(ModeleInscriptionJoueur.class))
		.andContains(subTasks -> {
			
			//ajouter ici chaque tâches qui modifient le modèle.
			actualiserInscriptionJoueur(subTasks);
			actualiserInscriptionJoueurTouche(subTasks);
			actualiserInscriptionJoueurNom(subTasks);
			
		});
		
	}
	


	private static void actualiserInscriptionJoueur(BackendTasks subTasks) {
		subTasks.task("actualiserInscription")
		.waitsFor(message(MsgActualiserInscriptionJoueur.class))
		.thenExecutes(inputs -> {
			
			MsgActualiserInscriptionJoueur msg = inputs.get(message(MsgActualiserInscriptionJoueur.class));
			ModeleInscriptionJoueur inscriptionJoueur = inputs.get(model(ModeleInscriptionJoueur.class));
			
			//on met dans le modèle le nouveau nom du joueur
			inscriptionJoueur.setNomJoueur(msg.getNomJoueur());
			inscriptionJoueur.setTouches(msg.getTouches());
			
		});
		
	}
	
	private static void actualiserInscriptionJoueurTouche(BackendTasks subTasks) {
		subTasks.task("actualiserInscriptionTouche")
		.waitsFor(message(MsgActualiserInscriptionJoueurTouche.class))
		.thenExecutes(inputs -> {
			
			MsgActualiserInscriptionJoueurTouche msg = inputs.get(message(MsgActualiserInscriptionJoueurTouche.class));
			ModeleInscriptionJoueur inscriptionJoueur = inputs.get(model(ModeleInscriptionJoueur.class));
			
			inscriptionJoueur.getTouches().put(msg.getAction(), msg.getKsr());
			
		});
		
	}
	
	private static void actualiserInscriptionJoueurNom(BackendTasks subTasks) {
		subTasks.task("actualiserInscriptionNom")
		.waitsFor(message(MsgActualiserInscriptionJoueurNom.class))
		.thenExecutes(inputs -> {
			
			MsgActualiserInscriptionJoueurNom msg = inputs.get(message(MsgActualiserInscriptionJoueurNom.class));
			ModeleInscriptionJoueur inscriptionJoueur = inputs.get(model(ModeleInscriptionJoueur.class));
			
			inscriptionJoueur.setNomJoueur(msg.getNom());
			
		});
	}
	
	
	
}

























