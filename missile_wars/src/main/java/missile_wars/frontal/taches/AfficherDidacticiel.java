package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.clock;
import static ca.ntro.app.tasks.frontend.FrontendTasks.create;
import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.event;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import ca.ntro.core.task_graphs.task_graph.Task;
import missile_wars.frontal.donnees.DonneesVueDidacticiel;
import missile_wars.frontal.evenements.EvtActionJoueur;
import missile_wars.frontal.vues.VueDidacticiel;

public class AfficherDidacticiel {
	
	private static List<Task> tachesDynamiques = new ArrayList<>();
	private static List<Integer> idIntervales = new ArrayList<>();
	
	public static void supprimerTachesDynamiques() {
		for (int idIntervale : idIntervales) {
			Interval.retirerMethode(idIntervale);
		}
		for (Task task : tachesDynamiques) {
			task.removeFromGraph();
		}
		idIntervales.clear();
		tachesDynamiques.clear();
	}
	
    public static void creerTaches(FrontendTasks taches) {
        tachesDynamiques.add(creerDonneesVueDidacticiel(taches));
        
        taches.taskGroup("AfficherDidacticiel")
                .waitsFor("Initialisation")
                .waitsFor(created(DonneesVueDidacticiel.class))
                .andContains(sousTaches -> {
                    prochaineImageDidacticiel(sousTaches);
                    reagirActionJoueur(sousTaches);
                });
    }

    private static Task creerDonneesVueDidacticiel(FrontendTasks taches) {
        return taches.task(create(DonneesVueDidacticiel.class))
                .executesAndReturnsCreatedValue(entrees -> {
                    return new DonneesVueDidacticiel();
                }).getTask();
    }

    private static void prochaineImageDidacticiel(FrontendTasks sousTaches) {
        sousTaches.task("prochaineImageDidacticiel")
                .waitsFor(clock().nextTick())
                .thenExecutes(entrees -> {
                    Tick tick = entrees.get(clock().nextTick());
                    DonneesVueDidacticiel donneesVueDidacticiel = entrees.get(created(DonneesVueDidacticiel.class));
                    VueDidacticiel vueDidacticiel = entrees.get(created(VueDidacticiel.class));

                    donneesVueDidacticiel.reagirTempsQuiPasse(tick.elapsedTime());
                    donneesVueDidacticiel.afficherSur(vueDidacticiel);

                });
    }

    private static void reagirActionJoueur(FrontendTasks sousTaches) {
        sousTaches.task("reagirActionJoueur")
                .waitsFor(event(EvtActionJoueur.class))
                .thenExecutes(inputs -> {
                    DonneesVueDidacticiel donneesVueDidacticiel = inputs.get(created(DonneesVueDidacticiel.class));
                    EvtActionJoueur evtActionJoueur = inputs.get(event(EvtActionJoueur.class));
                    evtActionJoueur.appliquerA(donneesVueDidacticiel);
                });

    }
}