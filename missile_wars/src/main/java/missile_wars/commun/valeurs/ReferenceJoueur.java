package missile_wars.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class ReferenceJoueur implements ModelValue {
	
	
	
	private int idJoueur = -1;
	
	
	
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public int getNombreMissiles() {
		return nombreMissiles;
	}
	public void setNombreMissiles(int nombreMissiles) {
		this.nombreMissiles = nombreMissiles;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	private int nombreMissiles = 0;
	private int score = 0;
	
}
