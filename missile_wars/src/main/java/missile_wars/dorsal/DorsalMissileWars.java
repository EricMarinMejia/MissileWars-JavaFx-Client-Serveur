package missile_wars.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.dorsal.taches.ModifierHistorique;

public class DorsalMissileWars extends LocalBackendNtro {

	@Override
	public void createTasks(BackendTasks tasks) {
		ModifierHistorique.creerTaches(tasks);
//        ModifierListePages.creerTaches(tasks);
//		ModifierJeu.creerTaches(tasks);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
