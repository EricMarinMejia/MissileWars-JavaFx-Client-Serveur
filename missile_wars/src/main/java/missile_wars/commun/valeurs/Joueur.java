package missile_wars.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Joueur implements ModelValue {
	
	private String nom = "";
	private int id = -1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	private int secondesDepuisDernierSignal = 0; //quand ce nombre est trop haut, c'est que le joueur n'existe plus.
	

}
