package missile_wars.commun.modeles.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.ModelValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import missile_wars.frontal.fragments.FragmentPartie;

public class Partie implements ModelValue {
	
	private int idPartie;
	
	private String partieGagnee;
	private String partieFavorite;

	private String nomJoueur1;
	private String nomJoueur2;
	private int nbMissileJoueur1;
	private int nbMissileJoueur2;
	private int nbPointsJoueur1;
	private int nbPointsJoueur2;
	
	private String datePartie;
	
	public Partie() {
		
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

	public int getNbPointsJoueur1() {
		return nbPointsJoueur1;
	}

	public void setNbPointsJoueur1(int nbPointsJoueur1) {
		this.nbPointsJoueur1 = nbPointsJoueur1;
	}

	public int getNbPointsJoueur2() {
		return nbPointsJoueur2;
	}

	public void setNbPointsJoueur2(int nbPointsJoueur2) {
		this.nbPointsJoueur2 = nbPointsJoueur2;
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



	public String getPartieGagnee() {
		return partieGagnee;
	}



	public void setPartieGagnee(String partieGagnee) {
		this.partieGagnee = partieGagnee;
	}



	public String getPartieFavorite() {
		return partieFavorite;
	}


	public void setPartieFavorite(String partieFavorite) {
		this.partieFavorite = partieFavorite;
	}
	
	@Override
	public String toString() {
	return this.getPartieGagnee() + " | " + this.getDatePartie() + " | Favorite: " + this.getPartieFavorite() + "\n" + this.getNomJoueur1() + " - " + this.getNbPointsJoueur1() + "pts - nombre de missiles: " + this.getNbMissileJoueur1() + "\n"
			+ this.getNomJoueur2() + " - " + this.getNbPointsJoueur2() + "pts - nombre de missiles: " + this.getNbMissileJoueur2();
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
		fragmentPartie.afficherPointageJ1(String.valueOf(nbPointsJoueur1));
		fragmentPartie.afficherPointageJ2(String.valueOf(nbPointsJoueur2));
		fragmentPartie.afficherDate(datePartie);
		
		fragmentPartie.memoriserIdPartie(idPartie);
		
	}
}
