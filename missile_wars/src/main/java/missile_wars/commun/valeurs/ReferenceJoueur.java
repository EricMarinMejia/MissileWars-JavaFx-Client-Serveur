package missile_wars.commun.valeurs;

import ca.ntro.app.models.ModelValue;
import missile_wars.commun.monde2d.ObjetMissileWars2d;

public class ReferenceJoueur extends ObjetMissileWars2d implements ModelValue{
	
	private double coordX;	// entre 0.0 ‡ 1.0
	
	private int idJoueur = -1;
	
	
	// TODO: ajouter le nom du joueur. laissez charles s'occuper de celui l√† ;)
	
	
	
	public double getCoordX() {
		return coordX;
	}
	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}
	
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
