package missile_wars.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.Model;
import missile_wars.commun.enums.EtatPartie;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.commun.valeurs.Equipe;
import missile_wars.commun.valeurs.Plancher;
import missile_wars.commun.valeurs.ReferenceJoueur;
import missile_wars.frontal.donnees.DonneesVuePartie;
import missile_wars.frontal.vues.VuePartie;
import missile_wars.frontal.vues.fragments.FragmentPartie;

public class ModelePartie implements Model {
	
	private MondeMissileWars2d mondeMS2d = new MondeMissileWars2d();
	
	private String partieGagnee;
	
	private String datePartie;
	
	private String idPartie;
	
	private List<Equipe> lesEquipes = new ArrayList<>(); //il est censé y avoir seulement 2 équipes
	
	private List<Plancher> lesPlancher = new ArrayList<>();
	
	//LISTE MISSILES
	

	public ModelePartie() {
		this.lesEquipes.add(new Equipe());
		this.lesEquipes.add(new Equipe());
		this.lesPlancher.add(new Plancher());
		this.lesPlancher.add(new Plancher());
	}
	
	public void ajouterReferenceJoueur(int idJoueur) {
		int totalJoueurs = 0;
		
		for (Equipe equipe : this.lesEquipes) {
			totalJoueurs += equipe.getLesJoueurs().size();
			
			for (ReferenceJoueur referenceJoueur : equipe.getLesJoueurs()) {
				
				//si le joueur est déjà dans la partie, on ne l'ajoute pas une 2e fois
				if (referenceJoueur.getIdJoueur() == idJoueur) {
					return;
				}
			}
		}
		
		if (totalJoueurs < this.getQuantiteJoueursCible()) {
			ReferenceJoueur referenceJoueur = new ReferenceJoueur();
			referenceJoueur.setIdJoueur(idJoueur);
			int indexEquipe = 0;
			
			if (this.lesEquipes.get(0).getLesJoueurs().size() <= this.lesEquipes.get(1).getLesJoueurs().size()) {
				indexEquipe = 0;
			}
			else {
				indexEquipe = 1;
			}
			System.out.println("ajouté " + String.valueOf(idJoueur) + " à la partie " + this.idPartie + " à l'équipe d'index " + String.valueOf(indexEquipe) + "");
			this.lesEquipes.get(indexEquipe).getLesJoueurs().add(referenceJoueur);
		}
	}
	
	
	
	public int getEtatPartie() {
		return etatPartie;
	}


	public void setEtatPartie(int etatPartie) {
		this.etatPartie = etatPartie;
	}

	private int etatPartie = EtatPartie.EN_COURS.ordinal(); //EtatPartie.EN_ATTENTE_DE_JOUEUR.ordinal();
	
	private int quantiteJoueursCible = 2; //un nombre pair.
	
	public MondeMissileWars2d getMondeMS2d() {
		return mondeMS2d;
	}

	
	public List<Plancher> getLesPlancher() {
		return lesPlancher;
	}

	public void setLesPlancher(List<Plancher> lesPlancher) {
		this.lesPlancher = lesPlancher;
	}
	

	public void setMondeMS2d(MondeMissileWars2d mondeMS2d) {
		this.mondeMS2d = mondeMS2d;
	}


	public String getPartieGagnee() {
		return partieGagnee;
	}


	public void setPartieGagnee(String partieGagnee) {
		this.partieGagnee = partieGagnee;
	}




	public String getDatePartie() {
		return datePartie;
	}


	public void setDatePartie(String datePartie) {
		this.datePartie = datePartie;
	}


	public String getIdPartie() {
		return idPartie;
	}


	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}


	public void afficherInfoPartieSur(VuePartie vuePartie) {
//		vueJeu.afficherNomPremierJoueur(nomJoueur1);
//		vueJeu.afficherNomDeuxiemeJoueur(nomJoueur2);
//		
//		vueJeu.afficherScorePremierJoueur(String.valueOf(scoreJoueur1));
//		vueJeu.afficherScoreDeuxiemeJoueur(String.valueOf(scoreJoueur2));

		vuePartie.afficherNomPremierJoueur("joueur 1");
		vuePartie.afficherNomDeuxiemeJoueur("joueur 2");
		
		vuePartie.afficherScorePremierJoueur(String.valueOf("1"));
		vuePartie.afficherScoreDeuxiemeJoueur(String.valueOf("2"));
	}
	
	
	public void copierDonneesDans(DonneesVuePartie donneesVuePartie)  {
		donneesVuePartie.copierDonneesDe(this);
	}

	public void copierDonneesDe(MondeMissileWars2d mondeMS2d) {
		this.mondeMS2d.copyDataFrom(mondeMS2d);
	}
	
	public List<Equipe> getLesEquipes() {
		return lesEquipes;
	}


	public void setLesEquipes(List<Equipe> lesEquipes) {
		this.lesEquipes = lesEquipes;
	}


	public int getQuantiteJoueursCible() {
		return quantiteJoueursCible;
	}


	public void setQuantiteJoueursCible(int quantiteJoueursCible) {
		this.quantiteJoueursCible = quantiteJoueursCible;
	}


	public void ajouterPointPour(Object cadran) {
//		
//		switch(cadran) {
//        case GAUCHE:
//        default:
//        	scoreJoueur1+=6;
//            break;
//
//        case DROITE:
//        	scoreJoueur2+=6;
//            break;
//        }
	}

	public FragmentPartie creerFragment(ViewLoader<FragmentPartie> viewLoaderParties) {
		return viewLoaderParties.createView();
	}

	public void afficherSur(FragmentPartie fragmentPartie) {
		fragmentPartie.afficherResultatPartie(partieGagnee);
		fragmentPartie.afficherNomPremierJoueur("joueur 1");
		fragmentPartie.afficherNomDeuxiemeJoueur("joueur 2");
		fragmentPartie.afficherNbMissileJ1(String.valueOf("1"));
		fragmentPartie.afficherNbMissileJ2(String.valueOf("2"));
		fragmentPartie.afficherPointageJ1(String.valueOf("1"));
		fragmentPartie.afficherPointageJ2(String.valueOf("2"));
		fragmentPartie.afficherDate(datePartie);
		
		fragmentPartie.memoriserIdPartie(idPartie);
		
	}
}
