package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;

public class MsgNouvellePartie extends MessageNtro {
	
	private int quantiteJoueursCible;

	public int getQuantiteJoueursCible() {
		return quantiteJoueursCible;
	}

	public void setQuantiteJoueursCible(int quantiteJoueursCible) {
		this.quantiteJoueursCible = quantiteJoueursCible;
	}
	
	public MsgNouvellePartie() {
		
	}
	public MsgNouvellePartie(int quantiteJoueursCible) {
		this.setQuantiteJoueursCible(quantiteJoueursCible);
	}
	
}
