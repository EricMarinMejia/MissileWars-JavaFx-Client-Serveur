package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;

public class MsgModifierPositionJoueur extends MessageNtro {
	int idJoueur;
	String idPartie;
	double position;
	
	
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
	public double getPosition() {
		return position;
	}
	public void setPosition(double position) {
		this.position = position;
	}
	
}
