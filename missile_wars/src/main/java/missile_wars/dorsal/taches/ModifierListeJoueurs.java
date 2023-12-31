package missile_wars.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.message;
import static ca.ntro.app.tasks.backend.BackendTasks.model;

import ca.ntro.app.NtroApp;
import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.commun.messages.MsgDemandeNouveauJoueur;
import missile_wars.commun.messages.MsgJoueurExiste;
import missile_wars.commun.messages.MsgModifierNomJoueur;
import missile_wars.commun.messages.MsgNouveauIdJoueurBroadcast;
import missile_wars.commun.modeles.ModeleListeJoueurs;
import missile_wars.commun.valeurs.Joueur;

public class ModifierListeJoueurs {
	
	public static void creerTaches(BackendTasks tasks) {
		tasks.taskGroup("ModifierListeJoueurs")
		.waitsFor(model(ModeleListeJoueurs.class))
		.andContains(subTasks -> {
			demandeNouveauJoueur(subTasks);
//			recevoirJoueurExiste(subTasks);
			modifierNomJoueur(subTasks);
		});
	}
	
	private static void demandeNouveauJoueur(BackendTasks subTasks) {
		subTasks.task("demandeNouveauJoueur")
		.waitsFor(message(MsgDemandeNouveauJoueur.class))
		.thenExecutes(inputs -> {
			ModeleListeJoueurs modeleListeJoueurs = inputs.get(model(ModeleListeJoueurs.class));
			int id = modeleListeJoueurs.creerNouveauJoueur();
			
			MsgNouveauIdJoueurBroadcast msg = NtroApp.newMessage(MsgNouveauIdJoueurBroadcast.class);
			msg.setIdJoueur(id);
			msg.broadcast();
			
		});
	}
	
	
	private static void modifierNomJoueur(BackendTasks subTasks) {
		subTasks.task("modifierNomJoueur")
		.waitsFor(message(MsgModifierNomJoueur.class))
		.thenExecutes(inputs -> {
			ModeleListeJoueurs modeleListeJoueurs = inputs.get(model(ModeleListeJoueurs.class));
			MsgModifierNomJoueur msg = inputs.get(message(MsgModifierNomJoueur.class));
			
			int idJoueur = msg.getIdJoueur();
			Joueur joueur = modeleListeJoueurs.obtenirJoueurParId(idJoueur);
			joueur.setNom(msg.getNom());
			
			
		});
	}
	
	
	private static void recevoirJoueurExiste(BackendTasks subTasks) {
		subTasks.task("recevoirJoueurExiste")
		.waitsFor(message(MsgJoueurExiste.class))
		.thenExecutes(inputs -> {
			
		});
	}
	
}
