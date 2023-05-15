package missile_wars.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.message;
import static ca.ntro.app.tasks.backend.BackendTasks.model;

import ca.ntro.app.NtroApp;
import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.commun.messages.MsgNouveauIdPartieBroadcast;
import missile_wars.commun.messages.MsgNouvellePartie;
import missile_wars.commun.modeles.ModeleFileAttente;
import missile_wars.dorsal.messages.MsgAjusterPartie;

public class ModifierFileAttente {
	public static void creerTaches(BackendTasks tasks) {
		tasks.taskGroup("ModifierFileAttente")
		.waitsFor(model(ModeleFileAttente.class))
		.andContains(subTasks -> {
			ajouterPartie(tasks, subTasks);
		});
	}
	
	
	private static void ajouterPartie(BackendTasks tasks, BackendTasks subTasks) {
		subTasks.task("ajouterPartie")
		.waitsFor(model(ModeleFileAttente.class))
		.waitsFor(message(MsgNouvellePartie.class))
		.thenExecutes(inputs -> {
			MsgNouvellePartie msgNouvellePartie = inputs.get(message(MsgNouvellePartie.class));
			ModeleFileAttente modeleFileAttente = inputs.get(model(ModeleFileAttente.class));
			
			String prochainId = modeleFileAttente.incrementeEtRetourneNouveauIdPartie();
			
			modeleFileAttente.ajouterReferencePartie(prochainId);
			
			ModifierPartie.creerTaches(subTasks, prochainId);
			
			//envoyer un 2e message qui modifie le nombre de joueur de la partie nouvellement créée
			MsgAjusterPartie msgAjusterPartie= NtroApp.newMessage(MsgAjusterPartie.class);
			msgAjusterPartie.setIdPartie(prochainId);
			msgAjusterPartie.setQuantiteJoueursCible(msgNouvellePartie.getQuantiteJoueursCible());
			msgAjusterPartie.setChannelId(prochainId);
			msgAjusterPartie.send();
			
			MsgNouveauIdPartieBroadcast msgNouveauIdPartieBroadcast = NtroApp.newMessage(MsgNouveauIdPartieBroadcast.class);
			msgNouveauIdPartieBroadcast.setIdPartie(prochainId);
			msgNouveauIdPartieBroadcast.broadcast();
			
		});
	}
}
