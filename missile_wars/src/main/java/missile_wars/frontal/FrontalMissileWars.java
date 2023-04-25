package missile_wars.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.evenements.EvtAfficherPages;
import missile_wars.frontal.evenements.EvtActionJoueur;
import missile_wars.frontal.evenements.EvtAfficherDidacticiel;
import missile_wars.frontal.taches.AfficherDidacticiel;
import missile_wars.frontal.taches.Initialisation;
import missile_wars.frontal.taches.Navigation;
import missile_wars.frontal.vues.VueDidacticiel;
import missile_wars.frontal.vues.VueFileAttente;
import missile_wars.frontal.vues.VueMenu;
import missile_wars.frontal.vues.VueParametres;
import missile_wars.frontal.vues.VueRacine;

public class FrontalMissileWars implements FrontendFx{

    @Override
    public void createTasks(FrontendTasks tasks) {
        Initialisation.creerTaches(tasks);
        AfficherDidacticiel.creerTaches(tasks);
        Navigation.creerTaches(tasks);
    }

    @Override
    public void execute() {
        // rien a faire ... 
    }

    @Override
    public void registerEvents(EventRegistrar registrar) {
        registrar.registerEvent(EvtAfficherDidacticiel.class);
        registrar.registerEvent(EvtAfficherPages.class);
        registrar.registerEvent(EvtActionJoueur.class);
    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {
        registrar.registerView(VueRacine.class, "/racine.xml");
        registrar.registerView(VueMenu.class, "/menu.xml");
        registrar.registerView(VueDidacticiel.class, "/didacticiel.xml");
        registrar.registerView(VueFileAttente.class, "/file-attente.xml");       
        registrar.registerView(VueParametres.class, "/parametres.xml");       

        registrar.registerStylesheet("/dev.css");
        registrar.registerStylesheet("/prod.css");

        registrar.registerDefaultResources("/chaines_fr.properties");
        registrar.registerResources(NtroApp.locale("en"),"/chaines_en.properties");
        registrar.registerResources(NtroApp.locale("qc"), "/chaines_qc.properties");
        registrar.registerResources(NtroApp.locale("ch"), "/chaines_ch.properties");
    }
}