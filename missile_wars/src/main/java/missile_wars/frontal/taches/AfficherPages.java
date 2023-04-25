package missile_wars.frontal.taches;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import missile_wars.commun.modele.ModelePages;
import missile_wars.frontal.vue.VuePages;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

public class AfficherPages {
    public static void creerTaches(FrontendTasks taches) {
        taches.taskGroup("AfficherPages")
                .waitsFor("Initialisation")
                .andContains(sousTaches -> {
                    afficherPages(sousTaches);
                });
    }
    
    private static void afficherPages(FrontendTasks sousTaches){
        sousTaches.task("afficherPages")
        .waitsFor(created(VuePages.class))
        .waitsFor(modified(ModelePages.class))
        .executes(entrees -> {
            VuePages vuePages = entrees.get(created(VuePages.class));
            Modified<ModelePages> pagesModifie = entrees.get(modified(ModelePages.class));
            ModelePages valeursCourante = pagesModifie.currentValue();
            valeursCourante.afficherSur(vuePages);
        });
    }
}