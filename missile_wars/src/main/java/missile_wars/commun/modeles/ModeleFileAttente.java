package missile_wars.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import missile_wars.commun.valeurs.ReferencePartie;
import missile_wars.frontal.vues.VueFileAttente;

public class ModeleFileAttente implements Model {
	private int idProchainePartie = 1;
	
	public String incrementeEtRetourneNouveauIdPartie() {
		this.idProchainePartie++;
		return String.valueOf(this.idProchainePartie - 1);
	}
	
	private List<ReferencePartie> lesReferencesParties = new ArrayList<>();
	
	
	public void ajouterReferencePartie(String partieId) {
		ReferencePartie nouvelleReferencePartie = new ReferencePartie();
		nouvelleReferencePartie.setIdPartie(partieId);
		this.lesReferencesParties.add(nouvelleReferencePartie);
	}
	
	
	
	
	public void afficherSur(VueFileAttente vueFileAttente) {
		vueFileAttente.viderListeFragmentReferencePartieRejoindre();
		for (ReferencePartie referencePartie : this.lesReferencesParties) {
			vueFileAttente.ajouterReferencePartie(referencePartie);
			
		}
	}
}
