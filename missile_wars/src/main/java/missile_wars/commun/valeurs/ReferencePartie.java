package missile_wars.commun.valeurs;

import ca.ntro.app.models.ModelValue;
import missile_wars.frontal.vues.fragments.FragmentReferencePartieRejoindre;

public class ReferencePartie implements ModelValue {

	private String idPartie;

	public String getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}
	
	
	
	
	public void afficherSur(FragmentReferencePartieRejoindre fragment) {
		fragment.memoriserIdPartie(this.idPartie);
	}
}
