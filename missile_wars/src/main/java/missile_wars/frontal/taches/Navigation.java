package missile_wars.frontal.taches;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import missile_wars.frontal.evenements.EvtAfficherPages;
import missile_wars.frontal.evenements.EvtAfficherDidacticiel;
import missile_wars.frontal.vue.VuePages;
import missile_wars.frontal.vues.VueDidacticiel;
import missile_wars.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

public class Navigation {
    public static void creerTaches(FrontendTasks taches) { 
        taches.taskGroup("Navigation")
            .waitsFor("Initialisation")
            .andContains(sousTaches -> 
            {     
                afficherVueDidacticiel(sousTaches);
                afficherVuePages(sousTaches);
            }
        );
    }

    private static void afficherVueDidacticiel(FrontendTasks sousTaches) { 
        sousTaches.task("afficherVueDidacticiel")
        .waitsFor(event(EvtAfficherDidacticiel.class))
        .thenExecutes(entrees -> { 
            VueRacine vueRacine = entrees.get(created(VueRacine.class));
            VueDidacticiel vueDidacticiel = entrees.get(created(VueDidacticiel.class));
            vueRacine.afficherSousVue(vueDidacticiel);
        });
    }

    private static void afficherVuePages(FrontendTasks sousTaches) { 
        sousTaches.task("afficherVuePages")
        .waitsFor(event(EvtAfficherPages.class))
        .thenExecutes(entrees -> { 
            VueRacine vueRacine = entrees.get(created(VueRacine.class));
            VuePages vueAccueil = entrees.get(created(VuePages.class));
            vueRacine.afficherSousVue(vueAccueil);
        });
    }
}