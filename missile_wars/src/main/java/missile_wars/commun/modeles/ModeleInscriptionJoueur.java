package missile_wars.commun.modeles;

import java.util.*;

import ca.ntro.app.models.*;
import ca.ntro.core.initialization.Ntro;
import missile_wars.commun.valeurs.*;
import missile_wars.frontal.vues.*;

import static missile_wars.commun.enums.ActionsJoueur.*;

public class ModeleInscriptionJoueur implements Model, WatchJson, WriteObjectGraph {

	private Map<String, KeyStringRepresentation> touches = null;
	
	private String nomJoueur = "noname";
	
	
	public Map<String, KeyStringRepresentation> getTouches() {
		return touches;
	}

	public void setTouches(Map<String, KeyStringRepresentation> touches) {
		this.touches = touches;
	}
	
	//méthode utilitaire
	public void touchesPut(String action, KeyStringRepresentation ksr) {
		this.touches.put(action,  ksr);
	}

	public String getNomJoueur() {
		return this.nomJoueur;
	}
	
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	
	
	
	public static Map<String, KeyStringRepresentation> instancierTouchesDefaut() {
		Map<String, KeyStringRepresentation> rep = new HashMap<>();
		rep.put(HAUT.name(), new KeyStringRepresentation("w"));
		rep.put(BAS.name(), new KeyStringRepresentation("s"));
		rep.put(TIRER.name(), new KeyStringRepresentation("l"));
		rep.put(LANCER_BOUCLIER.name(), new KeyStringRepresentation("k"));
		
		return rep;
	}
	
	public ModeleInscriptionJoueur() {
		
		this.nomJoueur = "noname";

		this.touches = instancierTouchesDefaut();
		
		
	}
	
	
}




































