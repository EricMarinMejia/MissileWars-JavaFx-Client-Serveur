package missile_wars.frontal.donnees;

import ca.ntro.core.initialization.Ntro;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.frontal.vues.VueDidacticiel;

public class DonneesVueDidacticiel {
    private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;
    private long horodatageDernierCalculFps = Ntro.time().nowMilliseconds();
    private long imagesAfficheesDepuisDernierCalculFps = 0;

    private MondeMissileWars2d mondeMissileWars2d = new MondeMissileWars2d();
    private String fpsCourant = "0";

    public void afficherSur(VueDidacticiel vueDidacticiel) {
        calculerFpsSiNecessaire();

        vueDidacticiel.viderCanvas();
        vueDidacticiel.afficherImagesParSeconde("FPS " + fpsCourant);
        vueDidacticiel.afficherPong2d(mondeMissileWars2d);

        imagesAfficheesDepuisDernierCalculFps++;
    }

    private void calculerFpsSiNecessaire() {
        long horodatageMaintenant = Ntro.time().nowMilliseconds();
        long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFps;

        if (millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
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
}