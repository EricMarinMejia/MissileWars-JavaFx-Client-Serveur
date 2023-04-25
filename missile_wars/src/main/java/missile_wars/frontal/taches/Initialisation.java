package missile_wars.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.vues.VueMenu;
import missile_wars.frontal.vues.VueRacine;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;

public class Initialisation {
    public static void creerTaches(FrontendTasks taches) {
        taches.taskGroup("Initialisation")
                .contains(sousTaches -> {
                    creerVueRacine(sousTaches);
                    creerVueMenu(sousTaches);
                    // creerVueDidacticiel(sousTaches);
                    // creerVueDidacticiel(sousTaches);

                    installerVueRacine(sousTaches);
                    installerVueMenu(sousTaches);

                    afficherFenetre(sousTaches);
                });
    }

    private static void creerVueRacine(FrontendTasks sousTaches) {
        sousTaches.task(create(VueRacine.class))
                .waitsFor(viewLoader(VueRacine.class))
                .thenExecutesAndReturnsValue(entrees -> {
                    ViewLoader<VueRacine> viewLoader = entrees.get(viewLoader(VueRacine.class));
                    VueRacine vueRacine = viewLoader.createView();
                    return vueRacine;
                });
    }

    private static void installerVueRacine(FrontendTasks sousTaches) {
        sousTaches.task("installerVueRacine")
                .waitsFor(window())
                .waitsFor(create(VueRacine.class))
                .thenExecutes(entrees -> {
                    VueRacine vueRacine = entrees.get(created(VueRacine.class));
                    Window window = entrees.get(window());
                    window.installRootView(vueRacine);
                });
    }

    private static void creerVueMenu(FrontendTasks taches) {
        taches.task(create(VueMenu.class))
                .waitsFor(viewLoader(VueMenu.class))
                .thenExecutesAndReturnsValue(entrees -> {
                    ViewLoader<VueMenu> viewLoader = entrees.get(viewLoader(VueMenu.class));
                    VueMenu vueAccueil = viewLoader.createView();
                    return vueAccueil;
                });
    }

    private static void installerVueMenu(FrontendTasks taches) {
        taches.task("installerVueMenu")
                .waitsFor(created(VueRacine.class))
                .waitsFor(created(VueMenu.class))
                .thenExecutes(entrees -> {
                    VueRacine vueRacine = entrees.get(created(VueRacine.class));
                    VueMenu vueMenu = entrees.get(created(VueMenu.class));
                    vueRacine.afficherSousVue(vueMenu);
                });
    }

    // private static void creerVuePages(FrontendTasks taches) {
    // taches.task(create(VuePages.class))
    // .waitsFor(viewLoader(VuePages.class))
    // .waitsFor(viewLoader(FragmentPage.class))
    // .thenExecutesAndReturnsValue(entrees -> {
    // ViewLoader<VuePages> viewLoaderPages =
    // entrees.get(viewLoader(VuePages.class));
    // VuePages vuePages = viewLoaderPages.createView();

    // ViewLoader<FragmentPage> viewLoaderPage =
    // entrees.get(viewLoader(FragmentPage.class));

    // vuePages.setFragmentPage(viewLoaderPage);

    // return vuePages;
    // });
    // }


    private static void afficherFenetre(FrontendTasks sousTaches) {
        sousTaches.task("afficherFenetre").waitsFor(window())
                .thenExecutes(entrees -> {
                    Window fenetre = entrees.get(window());
                    fenetre.show();
                });
    }
}