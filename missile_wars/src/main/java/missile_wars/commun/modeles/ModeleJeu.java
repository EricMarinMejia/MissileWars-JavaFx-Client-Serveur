package missile_wars.commun.modeles;

import ca.ntro.app.models.Model;
import missile_wars.commun.enums.Cadran;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.frontal.donnees.DonneesVueJeu;
import missile_wars.frontal.vues.VueAccueil;

public class ModeleJeu implements Model{
	
	private MondeMissileWars2d mondeMS2d = new MondeMissileWars2d();
	
	private String nomPremierJoueur = "Alfred Laidron";
	private String nomDeuxiemeJoueur = "Nule Hatre";
	
	private int scorePremierJoueur = 0;
	private int scoreDeuxiemeJoueur = 0;
	
	
	public void afficherInfoPartieSur(VueAccueil vueJeu) {
		vueJeu.afficherNomPremierJoueur(nomPremierJoueur);
		vueJeu.afficherNomDeuxiemeJoueur(nomDeuxiemeJoueur);
		
		vueJeu.afficherScorePremierJoueur(String.valueOf(scorePremierJoueur));
		vueJeu.afficherScoreDeuxiemeJoueur(String.valueOf(scoreDeuxiemeJoueur));
	}
	
	
	public void copierDonneesDans(DonneesVueJeu donneesVueJeu)  {
		donneesVueJeu.copierDonneesDe(mondeMS2d);
	}

	public void copierDonneesDe(MondeMissileWars2d mondeMS2d) {
		this.mondeMS2d.copyDataFrom(mondeMS2d);
	}
	
	public void ajouterPointPour(Cadran cadran) {
		
		switch(cadran) {
        case GAUCHE:
        default:
            scorePremierJoueur+=6;
            break;

        case DROITE:
            scoreDeuxiemeJoueur+=6;
            break;
        }
	}
}
