package missile_wars.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WriteObjectGraph;
import missile_wars.frontal.vues.VueHistorique;

public class ModeleHistorique implements Model, WriteObjectGraph{
	
	private int nbPartiesTotales = 0;
	private int nbPartiesGagnees = 0;
	private int nbPartiesPerdues = 0;
	
	private int pageActuelle = 1;
	private int nbPagesTotales = 1;
	private int prochainIdPartie = 1;
	
	private List<ModelePartie> lesPartiesJouees = new ArrayList<>();
	
	public ModeleHistorique() {
		
	}

	public int getNbPartiesTotales() {
		return nbPartiesTotales;
	}

	public void setNbPartiesTotales(int nbPartiesTotales) {
		this.nbPartiesTotales = nbPartiesTotales;
	}

	public int getNbPartiesGagnees() {
		return nbPartiesGagnees;
	}

	public void setNbPartiesGagnees(int nbPartiesGagnees) {
		this.nbPartiesGagnees = nbPartiesGagnees;
	}

	public int getNbPartiesPerdues() {
		return nbPartiesPerdues;
	}

	public void setNbPartiesPerdues(int nbPartiesPerdues) {
		this.nbPartiesPerdues = nbPartiesPerdues;
	}

	public int getPageActuelle() {
		return pageActuelle;
	}

	public void setPageActuelle(int pageActuelle) {
		this.pageActuelle = pageActuelle;
	}

	public int getNbPagesTotales() {
		return nbPagesTotales;
	}

	public void setNbPagesTotales(int nbPagesTotales) {
		this.nbPagesTotales = nbPagesTotales;
	}

	public int getProchainIdPartie() {
		return prochainIdPartie;
	}

	public void setProchainIdPartie(int prochainIdPartie) {
		this.prochainIdPartie = prochainIdPartie;
	}

	public List<ModelePartie> getLesPartiesJouees() {
		return lesPartiesJouees;
	}

	public void setLesPartiesJouees(List<ModelePartie> lesPartiesJouees) {
		this.lesPartiesJouees = lesPartiesJouees;
	}
	
	public void afficherSur(VueHistorique vueHistorique) {
		vueHistorique.viderListeParties();
		
		for(ModelePartie partie : lesPartiesJouees) {
			vueHistorique.ajouterPartie(partie);
		}
	}
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		for(int i = lesPartiesJouees.size(); i > 0; i-- ) {
			builder.append("-----------------------------------------------------\n");
			builder.append(lesPartiesJouees.get(i-1).toString());
			builder.append("\n");
		}
		
		return builder.toString();
	}
	
	public void retirerPartie(int idPartie) {
		int indicePartie = -1;

		for (int i = 0; i < lesPartiesJouees.size(); i++) {
			if (lesPartiesJouees.get(i).getIdPartie() == idPartie) {
				indicePartie = i;
				break;
			}
		}

		if (indicePartie >= 0) {
			lesPartiesJouees.remove(indicePartie);

			int nouveauProchainId = 0;

			if (lesPartiesJouees.size() != 0) {
				for (int i = 1; i <= lesPartiesJouees.size(); i++) {
					lesPartiesJouees.get(i - 1).setIdPartie(i);
					nouveauProchainId++;
				}
			}

			nouveauProchainId++;
			setProchainIdPartie(nouveauProchainId);
		}
	}
}

	