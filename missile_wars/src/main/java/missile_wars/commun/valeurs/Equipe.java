package missile_wars.commun.valeurs;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.ModelValue;

public class Equipe implements ModelValue {
	
	private List<ReferenceJoueur> lesJoueurs = new ArrayList<>();

	public List<ReferenceJoueur> getLesJoueurs() {
		return lesJoueurs;
	}

	public void setLesJoueurs(List<ReferenceJoueur> lesJoueurs) {
		this.lesJoueurs = lesJoueurs;
	}
	
	
}
