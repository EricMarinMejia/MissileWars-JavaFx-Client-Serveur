package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;

public class MsgModifierNomJoueur extends MessageNtro {
	
	private int idJoueur = -1;
	private String nom = "";
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
