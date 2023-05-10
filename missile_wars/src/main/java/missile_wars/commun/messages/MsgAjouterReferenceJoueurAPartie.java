package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;

public class MsgAjouterReferenceJoueurAPartie extends MessageNtro {
	private int idJoueur = -1;
	private String idPartie = "";
	
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public String getIdPartie() {
		return idPartie;
	}
	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}
	
	
}
