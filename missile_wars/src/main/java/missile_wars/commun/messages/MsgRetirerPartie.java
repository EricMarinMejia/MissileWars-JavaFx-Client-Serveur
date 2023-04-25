package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import missile_wars.commun.modeles.ModeleHistorique;

public class MsgRetirerPartie extends MessageNtro {

	private int idPartie;
	
	public MsgRetirerPartie() {
		
	}

	public int getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(int idPartie) {
		this.idPartie = idPartie;
	}
	
	public void retirerDe(ModeleHistorique historique) {
		historique.retirerPartie(idPartie);
	}
}
