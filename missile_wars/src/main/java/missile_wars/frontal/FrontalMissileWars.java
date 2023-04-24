package missile_wars.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.donnees.DonneesVueJeu;
import missile_wars.frontal.evenements.EvtAfficherAccueil;
import missile_wars.frontal.evenements.EvtAfficherHistorique;
import missile_wars.frontal.evenements.EvtActionJoueur;
import missile_wars.frontal.fragments.FragmentPartie;
import missile_wars.frontal.taches.AfficherHistorique;
import missile_wars.frontal.taches.AfficherJeu;
import missile_wars.frontal.taches.Initialisation;
import missile_wars.frontal.taches.Navigation;
import missile_wars.frontal.vues.VueAccueil;
import missile_wars.frontal.vues.VueHistorique;
import missile_wars.frontal.vues.VueRacine;

public class FrontalMissileWars implements FrontendFx{

	@Override
	public void createTasks(FrontendTasks tasks) {
		Initialisation.creerTaches(tasks);
		AfficherHistorique.creerTaches(tasks);
		Navigation.creerTaches(tasks);
		AfficherJeu.creerTaches(tasks);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		registrar.registerEvent(EvtAfficherHistorique.class);
		registrar.registerEvent(EvtAfficherAccueil.class);
		registrar.registerEvent(EvtActionJoueur.class);
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		registrar.registerView(VueRacine.class, "/racine.xml");
		registrar.registerView(VueHistorique.class, "/historique.xml");
		registrar.registerFragment(FragmentPartie.class, "/fragments/fragmentPartie.xml");
		
		registrar.registerStylesheet("/prod.css");
		
		registrar.registerDefaultResources("/chaines_fr.properties");
		registrar.registerResources(NtroApp.locale("en"), "/chaines_en.properties");
		registrar.registerResources(NtroApp.locale("es"), "/chaines_es.properties");
		
		registrar.registerView(VueAccueil.class, "/accueil.xml");
		
		registrar.registerViewData(DonneesVueJeu.class);
		
	}

}
