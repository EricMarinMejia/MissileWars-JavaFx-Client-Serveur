package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;

public class MsgNouveauIdPartieBroadcast extends MessageNtro {
	
	private String idPartie = "";

	public String getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}
	
	
}
