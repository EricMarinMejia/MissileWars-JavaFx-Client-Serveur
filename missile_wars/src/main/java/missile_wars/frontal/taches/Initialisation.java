package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.create;
import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.event;
import static ca.ntro.app.tasks.frontend.FrontendTasks.viewLoader;
import static ca.ntro.app.tasks.frontend.FrontendTasks.window;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.evenements.EvtIdJoueurMemorise;
import missile_wars.frontal.vues.VueDidacticiel;
import missile_wars.frontal.vues.VueFileAttente;
import missile_wars.frontal.vues.VueHistorique;
import missile_wars.frontal.vues.VueInscription;
import missile_wars.frontal.vues.VueMenu;
import missile_wars.frontal.vues.VueParametres;
import missile_wars.frontal.vues.VuePartie;
import missile_wars.frontal.vues.VueRacine;
import missile_wars.frontal.vues.fragments.FragmentActionTouche;
import missile_wars.frontal.vues.fragments.FragmentCouleur;
import missile_wars.frontal.vues.fragments.FragmentPartie;
import missile_wars.frontal.vues.fragments.FragmentReferencePartieRejoindre;

public class Initialisation {
    public static void creerTaches(FrontendTasks taches) {
        taches.taskGroup("Initialisation")
                .contains(sousTaches -> {
                    creerVueRacine(sousTaches);
                    creerVueMenu(sousTaches);
                    
                    creerVueDidacticiel(sousTaches);

                    installerVueRacine(sousTaches);
                    installerVueMenu(sousTaches);
                    
                    creerVuePartie(sousTaches);
                    creerVueParametres(sousTaches);
                    creerVueSInscrire(sousTaches);
                    creerVueFileAttente(sousTaches);
                    creerVueHistorique(sousTaches);

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
                .waitsFor(created(VueRacine.class))
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
    
    private static void creerVueSInscrire(FrontendTasks tasks) {

        tasks.task(create(VueInscription.class))

                .waitsFor(viewLoader(VueInscription.class))
                .waitsFor(viewLoader(FragmentActionTouche.class))

                .thenExecutesAndReturnsValue(inputs -> {

                    ViewLoader<VueInscription> viewLoader = inputs.get(viewLoader(VueInscription.class));
                    ViewLoader<FragmentActionTouche> viewLoaderActionTouche = inputs.get(viewLoader(FragmentActionTouche.class));

                    VueInscription vueInscription = viewLoader.createView();
                    
                    
                    return vueInscription;
                });
    }
    private static void creerVueParametres(FrontendTasks tasks) {

		tasks.task(create(VueParametres.class))
				.waitsFor(viewLoader(VueParametres.class))
				.waitsFor(viewLoader(FragmentCouleur.class))
				.thenExecutesAndReturnsValue(inputs -> {

					ViewLoader<VueParametres> viewLoader = inputs.get(viewLoader(VueParametres.class));
					ViewLoader<FragmentCouleur> viewLoaderCouleurs = inputs.get(viewLoader(FragmentCouleur.class));
					VueParametres VueParametres = viewLoader.createView();
					VueParametres.setViewLoaderCouleurs(viewLoaderCouleurs);
					return VueParametres;
				});
	}
    
    
    private static void creerVueDidacticiel(FrontendTasks tasks) {
    	tasks.task(create(VueDidacticiel.class))
    	.waitsFor(viewLoader(VueDidacticiel.class))
    	.thenExecutesAndReturnsValue(inputs -> {
			ViewLoader<VueDidacticiel> viewLoader = inputs.get(viewLoader(VueDidacticiel.class));
			
			VueDidacticiel vueDidacticiel = viewLoader.createView();
			return vueDidacticiel;
    	});
    }

    private static void creerVuePartie(FrontendTasks subTasks) {
    	subTasks.task(create(VuePartie.class))
    		.waitsFor(viewLoader(VuePartie.class))
    		.thenExecutesAndReturnsValue(inputs -> {
    			
    			ViewLoader<VuePartie> viewLoader = inputs.get(viewLoader(VuePartie.class));
    			VuePartie vuePartie = viewLoader.createView();
    			return vuePartie;
    			
    		});
    }

    private static void creerVueHistorique(FrontendTasks subTasks) {
    	subTasks.task(create(VueHistorique.class))
    		.waitsFor(viewLoader(VueHistorique.class))
    		.waitsFor(viewLoader(FragmentPartie.class))
    		.thenExecutesAndReturnsValue(inputs -> {
    			
    			ViewLoader<VueHistorique> viewLoader = inputs.get(viewLoader(VueHistorique.class));
    			ViewLoader<FragmentPartie> viewLoaderFragmentPartie = inputs.get(viewLoader(FragmentPartie.class));
    			VueHistorique vueHistorique = viewLoader.createView();
    			vueHistorique.setViewLoaderParties(viewLoaderFragmentPartie);
    			return vueHistorique;
    			
    		});
    }
    
    private static void creerVueFileAttente(FrontendTasks subTasks) {
    	subTasks.task(create(VueFileAttente.class))
		.waitsFor(viewLoader(VueFileAttente.class))
		.waitsFor(viewLoader(FragmentReferencePartieRejoindre.class))
        .waitsFor(event(EvtIdJoueurMemorise.class))
		.thenExecutesAndReturnsValue(inputs -> {
			
			ViewLoader<VueFileAttente> viewLoader = inputs.get(viewLoader(VueFileAttente.class));
			ViewLoader<FragmentReferencePartieRejoindre> viewLoaderFragmentReferencePartieRejoindre = inputs.get(viewLoader(FragmentReferencePartieRejoindre.class));
			VueFileAttente vueFileAttente = viewLoader.createView();
			vueFileAttente.setViewLoaderFragmentReferencePartieRejoindre(viewLoaderFragmentReferencePartieRejoindre);
			return vueFileAttente;
			
		});
    	
    }


    private static void afficherFenetre(FrontendTasks sousTaches) {
        sousTaches.task("afficherFenetre").waitsFor(window())
                .thenExecutes(entrees -> {
                    Window fenetre = entrees.get(window());
                    fenetre.show();
                });
    }
}
