package missile_wars.frontal.evenements;

import ca.ntro.app.frontend.events.EventNtro;

public class EvtTouchePressed extends EventNtro {
	String touche;

	public String getTouche() {
		return touche;
	}

	public void setTouche(String touche) {
		this.touche = touche;
	}
}
