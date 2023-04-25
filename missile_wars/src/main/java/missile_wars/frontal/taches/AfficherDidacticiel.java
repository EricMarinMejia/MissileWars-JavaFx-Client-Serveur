package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import missile_wars.frontal.donnees.DonneesVueDidacticiel;
import missile_wars.frontal.evenements.EvtActionJoueur;
import missile_wars.frontal.vues.VueDidacticiel;

public class AfficherDidacticiel {
    public static void creerTaches(FrontendTasks taches) {
        creerDonneesVueDidacticiel(taches);
        taches.taskGroup("AfficherDidacticiel")
                .waitsFor("Initialisation")
                .waitsFor(created(DonneesVueDidacticiel.class))
                .andContains(sousTaches -> {
                    prochaineImageDidacticiel(sousTaches);
                    reagirActionJoueur(sousTaches);
                });
    }

    private static void creerDonneesVueDidacticiel(FrontendTasks sousTaches) {
        sousTaches.task(create(DonneesVueDidacticiel.class))
                .executesAndReturnsCreatedValue(entrees -> {
                    return new DonneesVueDidacticiel();
                });
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