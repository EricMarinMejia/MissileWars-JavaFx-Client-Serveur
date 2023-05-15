package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.modified;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import missile_wars.commun.modeles.ModeleParametres;
import missile_wars.frontal.vues.VueParametres;

public class AfficherParametres {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("AfficherParametres")
		.waitsFor("Initialisation")
		.andContains(subTasks -> {
			// ajouter l'appel
			afficherParametres(subTasks);
		});
	}

	private static void afficherParametres(FrontendTasks subTasks) {
		subTasks.task("afficherParametres")
		.waitsFor(modified(ModeleParametres.class))

				.executes(inputs -> {
					

					VueParametres vueParametres = inputs.get(created(VueParametres.class));
					Modified<ModeleParametres> Parametres = inputs.get(modified(ModeleParametres.class));

					// ModeleParametres oldParameters = Parametres.previousValue();
					ModeleParametres currantParameters = Parametres.currentValue();

					// Prêt à afficher les parametres!

					currantParameters.afficherSur(vueParametres);

				});

	}
}