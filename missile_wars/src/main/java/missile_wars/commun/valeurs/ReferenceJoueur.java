package missile_wars.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class ReferenceJoueur implements ModelValue {
	
	
	
	// TODO : ajouter ICI les informations sur la position du joueur, son inventaire s'il en a un, etc...
	
	
	
	
	private int idJoueur = -1;
	
	// TODO: ajouter le nom du joueur. laissez charles s'occuper de celui là ;)
	
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
