package missile_wars.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import missile_wars.commun.valeurs.ReferencePartie;
import missile_wars.frontal.vues.VueFileAttente;


public class ModeleFileAttente implements Model {
	private int idProchainePartie = 1;
	
	public int getIdProchainePartie() {
		return this.idProchainePartie;
	}
	public void setIdProchainePartie(int value) {
		this.idProchainePartie = value;
	}
	
	public String incrementeEtRetourneNouveauIdPartie() {
		this.idProchainePartie++;
		return String.valueOf(this.idProchainePartie - 1);
	}
	
	private List<ReferencePartie> lesReferencesParties = new ArrayList<>();

	public List<ReferencePartie> getLesReferencesParties() {
		return this.lesReferencesParties;
	}
	public void setLesReferencesParties(List<ReferencePartie> lesReferencesParties) {
		this.lesReferencesParties = lesReferencesParties;
	}
	
	
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
