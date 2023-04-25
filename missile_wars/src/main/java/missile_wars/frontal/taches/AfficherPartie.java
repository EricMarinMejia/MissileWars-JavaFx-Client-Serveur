package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.clock;
import static ca.ntro.app.tasks.frontend.FrontendTasks.create;
import static ca.ntro.app.tasks.frontend.FrontendTasks.created;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import missile_wars.frontal.donnees.DonneesVuePartie;
import missile_wars.frontal.vues.VuePartie;


public class AfficherPartie {
	
	public static void creerTaches(FrontendTasks tasks) {
		
		creerDonneesVuePartie(tasks);
		
		tasks.taskGroup("AfficherPartie")
		.waitsFor(created(DonneesVuePartie.class))
		.andContains(subTasks -> {
			
			prochaineImagePartie(subTasks);
			
		});
	}
	
    private static void creerDonneesVuePartie(FrontendTasks tasks) {

        tasks.task(create(DonneesVuePartie.class))

             .waitsFor("Initialisation")

             .executesAndReturnsCreatedValue(inputs -> {

                 return new DonneesVuePartie();
             });
    }


    // ajouter la méthode
    private static void prochaineImagePartie(FrontendTasks subTasks) {

        subTasks.task("prochaineImagePartie")

                 .waitsFor(clock().nextTick())

                 .thenExecutes(inputs -> {

                     Tick             tick             = inputs.get(clock().nextTick());

                     DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
                     VuePartie        vuePartie        = inputs.get(created(VuePartie.class));


                     donneesVuePartie.reagirTempsQuiPasse(tick.elapsedTime());

                     donneesVuePartie.afficherSur(vuePartie);
                });
    }
	

	
	
}











