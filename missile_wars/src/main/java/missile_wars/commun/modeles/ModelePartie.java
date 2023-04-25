package missile_wars.commun.modeles;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.Model;
import missile_wars.commun.enums.Cadran;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.frontal.donnees.DonneesVueJeu;
import missile_wars.frontal.vues.VueAccueil;
import missile_wars.frontal.vues.fragments.FragmentPartie;

public class ModelePartie implements Model {
	
	private MondeMissileWars2d mondeMS2d = new MondeMissileWars2d();

	private String partieGagnee;
	
	private String nomJoueur1 = "Alfred Laidron";
	private String nomJoueur2 = "Nule Hatre";

	private int nbMissileJoueur1;
	private int nbMissileJoueur2;
	
	private int scoreJoueur1 = 0;
	private int scoreJoueur2 = 0;

	private String datePartie;
	
	private int idPartie;
	
	public MondeMissileWars2d getMondeMS2d() {
		return mondeMS2d;
	}


	public void setMondeMS2d(MondeMissileWars2d mondeMS2d) {
		this.mondeMS2d = mondeMS2d;
	}


	public String getPartieGagnee() {
		return partieGagnee;
	}


	public void setPartieGagnee(String partieGagnee) {
		this.partieGagnee = partieGagnee;
	}


	public String getNomJoueur1() {
		return nomJoueur1;
	}


	public void setNomJoueur1(String nomJoueur1) {
		this.nomJoueur1 = nomJoueur1;
	}


	public String getNomJoueur2() {
		return nomJoueur2;
	}


	public void setNomJoueur2(String nomJoueur2) {
		this.nomJoueur2 = nomJoueur2;
	}


	public int getNbMissileJoueur1() {
		return nbMissileJoueur1;
	}


	public void setNbMissileJoueur1(int nbMissileJoueur1) {
		this.nbMissileJoueur1 = nbMissileJoueur1;
	}


	public int getNbMissileJoueur2() {
		return nbMissileJoueur2;
	}


	public void setNbMissileJoueur2(int nbMissileJoueur2) {
		this.nbMissileJoueur2 = nbMissileJoueur2;
	}


	public int getScoreJoueur1() {
		return scoreJoueur1;
	}


	public void setScoreJoueur1(int scoreJoueur1) {
		this.scoreJoueur1 = scoreJoueur1;
	}


	public int getScoreJoueur2() {
		return scoreJoueur2;
	}


	public void setScoreJoueur2(int scoreJoueur2) {
		this.scoreJoueur2 = scoreJoueur2;
	}


	public String getDatePartie() {
		return datePartie;
	}


	public void setDatePartie(String datePartie) {
		this.datePartie = datePartie;
	}


	public int getIdPartie() {
		return idPartie;
	}


	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}


	public void afficherInfoPartieSur(VueAccueil vueJeu) {
		vueJeu.afficherNomPremierJoueur(nomJoueur1);
		vueJeu.afficherNomDeuxiemeJoueur(nomJoueur2);
		
		vueJeu.afficherScorePremierJoueur(String.valueOf(scoreJoueur1));
		vueJeu.afficherScoreDeuxiemeJoueur(String.valueOf(scoreJoueur2));
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
        	scoreJoueur1+=6;
            break;

        case DROITE:
        	scoreJoueur2+=6;
            break;
        }
	}

	public FragmentPartie creerFragment(ViewLoader<FragmentPartie> viewLoaderParties) {
		return viewLoaderParties.createView();
	}

	public void afficherSur(FragmentPartie fragmentPartie) {
		fragmentPartie.afficherResultatPartie(partieGagnee);
		fragmentPartie.afficherNomPremierJoueur(nomJoueur1);
		fragmentPartie.afficherNomDeuxiemeJoueur(nomJoueur2);
		fragmentPartie.afficherNbMissileJ1(String.valueOf(nbMissileJoueur1));
		fragmentPartie.afficherNbMissileJ2(String.valueOf(nbMissileJoueur2));
		fragmentPartie.afficherPointageJ1(String.valueOf(scoreJoueur1));
		fragmentPartie.afficherPointageJ2(String.valueOf(scoreJoueur2));
		fragmentPartie.afficherDate(datePartie);
		
		fragmentPartie.memoriserIdPartie(idPartie);
		
	}
}
