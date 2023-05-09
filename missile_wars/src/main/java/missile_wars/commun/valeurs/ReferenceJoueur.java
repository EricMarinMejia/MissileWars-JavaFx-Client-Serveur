package missile_wars.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Joueur implements ModelValue {
	
	private String nom = "";
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
