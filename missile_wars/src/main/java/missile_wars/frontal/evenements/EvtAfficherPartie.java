package missile_wars.frontal.evenements;

import ca.ntro.app.frontend.events.EventNtro;

public class EvtAfficherPartie extends EventNtro {
	
	private String idPartie;

	public String getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}
	
	
}
