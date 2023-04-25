package missile_wars.dorsal.taches;
import static ca.ntro.app.tasks.backend.BackendTasks.*;
import ca.ntro.app.tasks.backend.BackendTasks;
import missile_wars.commun.messages.MsgAjouterUnePage;
import missile_wars.commun.messages.MsgRetirerPages;
import missile_wars.commun.modele.ModelePages;

public class ModifierListePages {
    public static void creerTaches(BackendTasks taches) {
        taches.taskGroup("ModifierFileAttente")
                .waitsFor(model(ModelePages.class))
                .andContains(sousTaches -> {
                    ajouterUnePage(sousTaches);
                    retirerLesPages(sousTaches);
                });
    }

    private static void ajouterUnePage(BackendTasks sousTaches) {
        sousTaches.task("ajouterUnePage")
                .waitsFor(message(MsgAjouterUnePage.class))
                .thenExecutes(entree -> {
                    MsgAjouterUnePage msgAjouterPage = entree.get(message(MsgAjouterUnePage.class));
                    ModelePages modeleDidacticiel = entree.get(model(ModelePages.class));
                    msgAjouterPage.ajouterUnePage(modeleDidacticiel);
                });
    }

    private static void retirerLesPages(BackendTasks sousTaches) {
        sousTaches.task("retirerLesPages")
            .waitsFor(message(MsgRetirerPages.class))
            .thenExecutes(entrees -> { 
                MsgRetirerPages msgRetirerPages = entrees.get(message(MsgRetirerPages.class));
                ModelePages modeleDidacticiel = entrees.get(model(ModelePages.class));
                msgRetirerPages.retirerPages(modeleDidacticiel);
            });
    }
}