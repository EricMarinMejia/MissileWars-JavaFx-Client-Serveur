package missile_wars.commun.modeles.valeurs;

import ca.ntro.app.models.ModelValue;
import missile_wars.commun.enums.Action;
import missile_wars.commun.enums.Cadran;
import missile_wars.frontal.donnees.DonneesVueJeu;

public class ActionJoueur implements ModelValue {
	
	private Cadran cadran;
	private Action action;
	
	
	public ActionJoueur() {
		
	}
	
	public ActionJoueur(Cadran cadran, Action action) {
		this.cadran = cadran;
		this.action = action;
	}
	
	public void appliquerA(DonneesVueJeu donneesVueJeu) {
		donneesVueJeu.appliquerActionJoueur(cadran, action);
	}
	
	public String getCadran() {
		return cadran.name();
	}
	public void setCadran(String cadran) {
		this.cadran = Cadran.valueOf(cadran);
	}
	public String getAction() {
		return action.name();
	}
	public void setAction(String action) {
		this.action = Action.valueOf(action);
	}
}
