package missile_wars.dorsal.messages;

import ca.ntro.app.messages.MessageNtro;

public class MsgAjusterPartie extends MessageNtro {
	
	private String idPartie = "";
	
	private int quantiteJoueursCible = 2;

	public String getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}

	public int getQuantiteJoueursCible() {
		return quantiteJoueursCible;
	}

	public void setQuantiteJoueursCible(int quantiteJoueursCible) {
		this.quantiteJoueursCible = quantiteJoueursCible;
	}
	
	
	
}
