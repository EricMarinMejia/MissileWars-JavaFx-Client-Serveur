package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import missile_wars.commun.modeles.ModeleHistorique;

public class MsgRetirerPartie extends MessageNtro {

	private String idPartie;
	
	public MsgRetirerPartie() {
		
	}

	public String getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}
	
	public void retirerDe(ModeleHistorique historique) {
		historique.retirerPartie(idPartie);
	}
}
