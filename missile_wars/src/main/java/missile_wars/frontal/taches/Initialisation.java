package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.create;
import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.viewLoader;
import static ca.ntro.app.tasks.frontend.FrontendTasks.window;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.vues.VueAccueil;
import missile_wars.frontal.vues.VueHistorique;
import missile_wars.frontal.vues.VueRacine;
import missile_wars.frontal.vues.fragments.FragmentPartie;

public class Initialisation {

	public static void creerTaches(FrontendTasks tasks) {
		tasks.taskGroup("Initialisation").andContains(subTasks -> {
			creerVueRacine(subTasks);
			installerVueRacine(subTasks);
			afficherFenetre(subTasks);

			creerVueHistorique(subTasks);
			installerVueHistorique(subTasks);

			creerVueAccueil(subTasks);
		});
	}

	private static void afficherFenetre(FrontendTasks subTasks) {
		subTasks.task("afficherFenetre").waitsFor(window()).thenExecutes(inputs -> {
			Window window = inputs.get(window());
			window.resize(1000, 500);
			window.show();
		});
	}

	private static void creerVueRacine(FrontendTasks tasks) {

		tasks.task(create(VueRacine.class))

				.waitsFor(viewLoader(VueRacine.class))

				.thenExecutesAndReturnsValue(inputs -> {

					ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));

					VueRacine vueRacine = viewLoader.createView();

					return vueRacine;
				});
	}

	private static void installerVueRacine(FrontendTasks tasks) {

		tasks.task("installerVueRacine")

				.waitsFor(window())

				.waitsFor(created(VueRacine.class))

				.thenExecutes(inputs -> {

					VueRacine vueRacine = inputs.get(created(VueRacine.class));
					Window window = inputs.get(window());

					window.installRootView(vueRacine);
				});
	}

	private static void creerVueHistorique(FrontendTasks tasks) {
		tasks.task(create(VueHistorique.class))
				.waitsFor(viewLoader(VueHistorique.class))
				.waitsFor(viewLoader(FragmentPartie.class))
				.thenExecutesAndReturnsValue(inputs -> {
					ViewLoader<VueHistorique> viewLoader = inputs.get(viewLoader(VueHistorique.class));
					ViewLoader<FragmentPartie> viewLoaderParties = inputs.get(viewLoader(FragmentPartie.class));
					
					VueHistorique vueHistorique = viewLoader.createView();
					
					vueHistorique.setViewLoaderParties(viewLoaderParties);
					return vueHistorique;
				});
	}

	private static void installerVueHistorique(FrontendTasks tasks) {
		tasks.task("installerVueHistorique")
				.waitsFor(created(VueRacine.class))
				.waitsFor(created(VueHistorique.class))
				.thenExecutes(inputs -> {
					VueRacine vueRacine = inputs.get(created(VueRacine.class));
					VueHistorique vueHistorique = inputs.get(created(VueHistorique.class));
					vueRacine.afficherSousVue(vueHistorique);
				});
	}

	private static void creerVueAccueil(FrontendTasks subTasks) {
		subTasks.task(create(VueAccueil.class)).waitsFor(viewLoader(VueAccueil.class))
				.thenExecutesAndReturnsValue(inputs -> {
					ViewLoader<VueAccueil> viewLoader = inputs.get(viewLoader(VueAccueil.class));
					VueAccueil vueAccueil = viewLoader.createView();

					return vueAccueil;
				});
	}

}
