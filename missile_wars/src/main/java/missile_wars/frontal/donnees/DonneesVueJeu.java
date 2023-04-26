package missile_wars.frontal.donnees;

import ca.ntro.app.frontend.ViewData;
import ca.ntro.core.initialization.Ntro;
import missile_wars.commun.enums.Action;
//import missile_wars.commun.enums.Cadran;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.frontal.vues.VuePartie;

public class DonneesVueJeu implements ViewData {

		private MondeMissileWars2d mondeMS2d = new MondeMissileWars2d();
		private String fpsCourant = "0";
		
		private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;
		private long horodatageDernierCalculFPS = Ntro.time().nowMilliseconds();
		private long imagesAfficheesDepuisDernierCalculFps = 0;
		
		
		public void afficherSur(VuePartie vueJeu) {
			calculerFpsSiNecessaire();
			vueJeu.viderCanvas();
			vueJeu.afficherImagesParSecondes("FPS " + fpsCourant);
			vueJeu.afficherMissileWars2d(mondeMS2d);
			
			imagesAfficheesDepuisDernierCalculFps++;
		}
		
		private void calculerFpsSiNecessaire() {
			long horodatageMaintenant = Ntro.time().nowMilliseconds();
			long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFPS;
			
			if (millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
				calculerFpsMaintenant(millisecondesEcoulees);
				
				imagesAfficheesDepuisDernierCalculFps = 0;
				horodatageDernierCalculFPS = horodatageMaintenant;
			}
		}
		
		private void calculerFpsMaintenant(long millisecondesEcoulees) {
			double secondesEcoulees = millisecondesEcoulees / 1E3;
			double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;
			fpsCourant = String.valueOf(Math.round(fps));
		}
		
		public void reagirTempsQuiPasse(double elapsedTime) {
			mondeMS2d.onTimePasses(elapsedTime);
		}
		
		public void copierDonneesDe(MondeMissileWars2d mondeMS2d) {
			mondeMS2d.copyDataFrom(mondeMS2d);
		}

//		public void appliquerActionJoueur(Cadran cadran, Action action) {
//			mondeMS2d.appliquerActionJoueur(cadran, action);
//			
//		}
	
}
