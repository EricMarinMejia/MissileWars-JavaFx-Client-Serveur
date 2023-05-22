package missile_wars.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.donnees.DonneesSession;
import missile_wars.frontal.evenements.EvtActionJoueur;
import missile_wars.frontal.evenements.EvtAfficherDidacticiel;
import missile_wars.frontal.evenements.EvtAfficherFileAttente;
import missile_wars.frontal.evenements.EvtAfficherHistorique;
import missile_wars.frontal.evenements.EvtAfficherInscription;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.evenements.EvtAfficherPages;
import missile_wars.frontal.evenements.EvtAfficherParametres;
import missile_wars.frontal.evenements.EvtAfficherPartie;
import missile_wars.frontal.evenements.EvtEnvoyerSignalJoueurExiste;
import missile_wars.frontal.evenements.EvtProchaineImageDidacticiel;
import missile_wars.frontal.evenements.EvtProchaineImagePartie;
import missile_wars.frontal.evenements.EvtRemettreInfosActuelles;
import missile_wars.frontal.evenements.EvtRemettreTouchesParDefaut;
import missile_wars.frontal.evenements.EvtUtilisateurACreeNouvellePartie;
import missile_wars.frontal.taches.AfficherFileAttente;
import missile_wars.frontal.taches.AfficherHistorique;
import missile_wars.frontal.taches.AfficherParametres;
import missile_wars.frontal.taches.AfficherPartie;
import missile_wars.frontal.taches.AfficherSInscrire;
import missile_wars.frontal.taches.Initialisation;
import missile_wars.frontal.taches.Interval;
import missile_wars.frontal.taches.Navigation;
import missile_wars.frontal.taches.Session;
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

public class FrontalMissileWars implements FrontendFx {
    @Override
    public void createTasks(FrontendTasks tasks) {
        Session.creerTaches(tasks);
        Initialisation.creerTaches(tasks);
        AfficherParametres.creerTaches(tasks);
        AfficherHistorique.creerTaches(tasks);
        AfficherPartie.creerTachesStatiques(tasks);
        AfficherSInscrire.creerTaches(tasks);
        AfficherFileAttente.creerTaches(tasks);
        Interval.creerTaches(tasks);
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
        registrar.registerEvent(EvtAfficherInscription.class);
        registrar.registerEvent(EvtAfficherMenu.class);
        registrar.registerEvent(EvtAfficherParametres.class);
        registrar.registerEvent(EvtAfficherPartie.class);
        registrar.registerEvent(EvtRemettreInfosActuelles.class);
        registrar.registerEvent(EvtRemettreTouchesParDefaut.class);
        registrar.registerEvent(EvtAfficherHistorique.class);
        registrar.registerEvent(EvtAfficherFileAttente.class);
        registrar.registerEvent(EvtUtilisateurACreeNouvellePartie.class);
        registrar.registerEvent(EvtProchaineImagePartie.class);
        registrar.registerEvent(EvtProchaineImageDidacticiel.class);
        registrar.registerEvent(EvtEnvoyerSignalJoueurExiste.class);
    }

    @Override
    public void registerViews(ViewRegistrarFx registrar) {
        registrar.registerView(VueRacine.class, "/racine.xml");
        registrar.registerView(VueMenu.class, "/menu.xml");
        registrar.registerView(VueDidacticiel.class, "/didacticiel.xml");
        registrar.registerView(VueFileAttente.class, "/file-attente.xml");
        registrar.registerView(VueParametres.class, "/parametres.xml");
        registrar.registerView(VueInscription.class, "/inscription.xml");
        registrar.registerView(VueHistorique.class, "/historique.xml");
        registrar.registerView(VuePartie.class, "/partie.xml");
        registrar.registerFragment(FragmentActionTouche.class, "/fragments/action_touche.xml");
        registrar.registerFragment(FragmentCouleur.class, "/fragments/couleur.xml");
        registrar.registerFragment(FragmentPartie.class, "/fragments/fragment_partie.xml");
        registrar.registerFragment(FragmentReferencePartieRejoindre.class, "/fragments/FragmentReferencePartieRejoindre.xml");
        registrar.registerViewData(DonneesSession.class);
        registrar.registerStylesheet("/dev.css");
        registrar.registerStylesheet("/prod.css");
        registrar.registerDefaultResources("/chaines_fr.properties");
        registrar.registerResources(NtroApp.locale("en"),"/chaines_en.properties");
        registrar.registerResources(NtroApp.locale("qc"), "/chaines_qc.properties");
        registrar.registerResources(NtroApp.locale("ch"), "/chaines_ch.properties");
    }
}
