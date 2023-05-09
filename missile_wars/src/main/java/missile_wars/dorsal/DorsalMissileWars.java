package missile_wars.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.dorsal.taches.ModifierCouleur;
import missile_wars.dorsal.taches.ModifierFileAttente;
import missile_wars.dorsal.taches.ModifierHistorique;
import missile_wars.dorsal.taches.ModifierInscriptionJoueur;
import missile_wars.dorsal.taches.ModifierListeJoueurs;

public class DorsalMissileWars extends LocalBackendNtro {

	@Override
	public void createTasks(BackendTasks tasks) {
		ModifierHistorique.creerTaches(tasks);
		ModifierFileAttente.creerTaches(tasks);
		ModifierCouleur.creerTaches(tasks);
		ModifierInscriptionJoueur.creerTaches(tasks);
		ModifierListeJoueurs.creerTaches(tasks);
		
//      ModifierListePages.creerTaches(tasks);
//		ModifierJeu.creerTaches(tasks);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
