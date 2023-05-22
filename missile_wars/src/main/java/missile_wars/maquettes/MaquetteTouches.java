package missile_wars.maquettes;


import java.util.HashMap;
import java.util.Map;

import ca.ntro.core.initialization.Ntro;
import missile_wars.commun.valeurs.KeyStringRepresentation;

import static missile_wars.commun.enums.ActionsJoueurEnum.*;

public class MaquetteTouches {

	public static Map<String, KeyStringRepresentation> touchesAleatoires() {
		Map<String, KeyStringRepresentation> touches = new HashMap<>();

		touches.put(HAUT.name(), new KeyStringRepresentation(toucheAleatoire()));
		touches.put(BAS.name(), new KeyStringRepresentation(toucheAleatoire()));
		touches.put(TIRER.name(), new KeyStringRepresentation(toucheAleatoire()));
		touches.put(LANCER_BOUCLIER.name(), new KeyStringRepresentation(toucheAleatoire()));

		return touches;
	}

	public static String toucheAleatoire() {
		return Ntro.random().nextId(1).toLowerCase();
	}

}
