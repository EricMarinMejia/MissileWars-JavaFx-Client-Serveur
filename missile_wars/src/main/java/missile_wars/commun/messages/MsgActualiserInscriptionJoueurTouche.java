package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import missile_wars.commun.valeurs.KeyStringRepresentation;

public class MsgActualiserInscriptionJoueurTouche extends MessageNtro {
	private String action = "";
	private KeyStringRepresentation ksr = null;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public KeyStringRepresentation getKsr() {
		return ksr;
	}
	public void setKsr(KeyStringRepresentation ksr) {
		this.ksr = ksr;
	}
	
	
	
}
