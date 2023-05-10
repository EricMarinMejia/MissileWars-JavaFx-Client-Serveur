package missile_wars.frontal.donnees;


import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.frontend.ViewData;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.core.initialization.Ntro;
import missile_wars.commun.modeles.ModelePartie;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.frontal.vues.VuePartie;

public class DonneesVuePartie implements ViewData {

	private MondeMissileWars2d mondeMissileWars2d = new MondeMissileWars2d();
	private String fpsCourant = "0";
	

    private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;


    private long horodatageDernierCalculFps = Ntro.time().nowMilliseconds();
    private long imagesAfficheesDepuisDernierCalculFps = 0;

    public void afficherSur(VuePartie vuePartie) {
        calculerFpsSiNecessaire();

        vuePartie.viderCanvas();
//        vuePartie.afficherImagesParSecondes(fpsCourant);
//        vuePartie.afficherImagesParSeconde("FPS " + fpsCourant);
        
        List<String> testList = new ArrayList<>();
        testList.add("asdf");
        testList.add("qwer ffgf");
        vuePartie.afficherLignesDeTexte(testList);
        
        
        vuePartie.afficherMissileWars2d(mondeMissileWars2d);

        imagesAfficheesDepuisDernierCalculFps++;
    }
    

    private void calculerFpsSiNecessaire() {
        long horodatageMaintenant = Ntro.time().nowMilliseconds();
        long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFps;

        if(millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
            calculerFpsMaintenant(millisecondesEcoulees);

            imagesAfficheesDepuisDernierCalculFps = 0;
            horodatageDernierCalculFps = horodatageMaintenant;
        }
    }

    private void calculerFpsMaintenant(long millisecondesEcoulees) {
        double secondesEcoulees = millisecondesEcoulees / 1E3;
        double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;
        fpsCourant = String.valueOf(Math.round(fps));
    }
    
    public void reagirTempsQuiPasse(double elapsedTime) {
    	mondeMissileWars2d.onTimePasses(elapsedTime);
    }

    public void copierDonneesDe(ModelePartie modelePartie) {
    	mondeMissileWars2d.copyDataFrom(modelePartie.getMondeMS2d());
    	
    	
    	
    }

    
	public void reagirClicSouris(World2dMouseEventFx evt) {
		mondeMissileWars2d.dispatchMouseEvent(evt);
	}
	
}


















