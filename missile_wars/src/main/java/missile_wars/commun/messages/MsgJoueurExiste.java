package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;

public class MsgJoueurExiste extends MessageNtro {

	private int idJoueur = -1;

	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	
	
}
