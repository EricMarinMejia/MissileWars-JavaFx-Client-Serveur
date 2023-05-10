package missile_wars.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.core.initialization.Ntro;
import missile_wars.commun.valeurs.Joueur;

public class ModeleListeJoueurs implements Model {
	
	private int idProchainJoeur = 1;
	
	public int getIdProchainJoeur() {
		return idProchainJoeur;
	}

	public void setIdProchainJoeur(int idProchainJoeur) {
		this.idProchainJoeur = idProchainJoeur;
	}

	private List<Joueur> listeJoueurs = new ArrayList<>();

	public List<Joueur> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(List<Joueur> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}
	
	
	public Joueur obtenirJoueurParId(int idJoueur) {
		try {
			return this.listeJoueurs.stream().filter(joueur -> {
				return joueur.getId() == idJoueur;
			}).findFirst().get();
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	
	public int creerNouveauJoueur() {
		int id = this.getIdProchainJoeur();
		this.setIdProchainJoeur(id + 1);
		
		Joueur joueur = new Joueur();
		joueur.setId(id);
		joueur.setNom("Joueur" + Ntro.random().nextId());
		this.listeJoueurs.add(joueur);
		
		return id;
	}
	
	
}
