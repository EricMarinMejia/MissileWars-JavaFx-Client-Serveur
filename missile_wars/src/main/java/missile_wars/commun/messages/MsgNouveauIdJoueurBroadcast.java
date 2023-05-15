package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;

/**
 * 
 * Quand un nouveau joueur est créé (à la demande d'un client), le serveur broadcast l'id du nouveau joueur
 * 
 * @author charles
 *
 */
public class MsgNouveauIdJoueurBroadcast extends MessageNtro {
	
	private int idJoueur = -1;

	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	
	
	
	
}
