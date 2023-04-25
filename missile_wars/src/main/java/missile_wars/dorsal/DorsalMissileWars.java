package missile_wars.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.dorsal.taches.ModifierListePages;

public class DorsalMissileWars extends LocalBackendNtro {

    @Override
    public void createTasks(BackendTasks tasks) {
        ModifierListePages.creerTaches(tasks);
        
    }

    @Override
    public void execute() {
        // rien a faire ...    
    }
    
}