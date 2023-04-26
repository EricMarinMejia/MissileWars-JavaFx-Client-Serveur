package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;

public class MsgActualiserInscriptionJoueurNom extends MessageNtro {
	
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	

}
