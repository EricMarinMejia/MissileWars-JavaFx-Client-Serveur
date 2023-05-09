package missile_wars.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.message;
import static ca.ntro.app.tasks.backend.BackendTasks.model;

import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.commun.messages.MsgAjouterCouleur;
import missile_wars.commun.messages.MsgRetirerPartie;
import missile_wars.commun.modeles.ModeleParametres;

public class ModifierCouleur {

	public static void creerTaches(BackendTasks tasks) {
		tasks.taskGroup("modifierCouleur")
				.waitsFor(model(ModeleParametres.class))
				.andContains(subTasks -> {
					// XXX: ajouter l'appel!
					ajouterCouleur(subTasks);
				});
	}

	private static void ajouterCouleur(BackendTasks subTasks) {
		subTasks.task("ajouterCouleur")
				.waitsFor(message(MsgAjouterCouleur.class))
				.thenExecutes(inputs -> {
					MsgAjouterCouleur msgAjouterCouleur = inputs.get(message(MsgAjouterCouleur.class));
					ModeleParametres couleur = inputs.get(model(ModeleParametres.class));
					msgAjouterCouleur.ajouterCouleur(couleur);
					// Prêt à ajouter un rendez-vous!
					
					
					

				});
	}
}