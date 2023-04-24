package missile_wars.frontal.evenements;

import ca.ntro.app.frontend.events.EventNtro;
import missile_wars.commun.modeles.valeurs.ActionJoueur;
import missile_wars.frontal.donnees.DonneesVueJeu;

public class EvtActionJoueur extends EventNtro{
	private ActionJoueur action;

	public EvtActionJoueur() {
		
	}
	
	
	public void appliquerA(DonneesVueJeu donneesVueJeu) {
		action.appliquerA(donneesVueJeu);
	}
	
	
	public ActionJoueur getAction() {
		return action;
	}

	public void setAction(ActionJoueur action) {
		this.action = action;
	}
	
	
}
