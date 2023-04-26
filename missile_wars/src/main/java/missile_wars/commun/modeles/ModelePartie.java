package missile_wars.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.Model;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.commun.valeurs.Equipe;
import missile_wars.frontal.donnees.DonneesVueJeu;
import missile_wars.frontal.vues.VuePartie;
import missile_wars.frontal.vues.fragments.FragmentPartie;

public class ModelePartie implements Model {
	
	private MondeMissileWars2d mondeMS2d = new MondeMissileWars2d();
	
	
	private List<Equipe> lesEquipes = new ArrayList<>();

	private String partieGagnee;
	

	private String datePartie;
	
	private String idPartie;
	
	private int quantiteJoueursCible = 2; //un nombre pair.
	
	public MondeMissileWars2d getMondeMS2d() {
		return mondeMS2d;
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

	
	public ModelePartie() {
		this.lesEquipes.add(new Equipe());
		this.lesEquipes.add(new Equipe());
	}

	public void afficherInfoPartieSur(VuePartie vueJeu) {
//		vueJeu.afficherNomPremierJoueur(nomJoueur1);
//		vueJeu.afficherNomDeuxiemeJoueur(nomJoueur2);
//		
//		vueJeu.afficherScorePremierJoueur(String.valueOf(scoreJoueur1));
//		vueJeu.afficherScoreDeuxiemeJoueur(String.valueOf(scoreJoueur2));

		vueJeu.afficherNomPremierJoueur("joueur 1");
		vueJeu.afficherNomDeuxiemeJoueur("joueur 2");
		
		vueJeu.afficherScorePremierJoueur(String.valueOf("1"));
		vueJeu.afficherScoreDeuxiemeJoueur(String.valueOf("2"));
	}
	
	
	public void copierDonneesDans(DonneesVueJeu donneesVueJeu)  {
		donneesVueJeu.copierDonneesDe(mondeMS2d);
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
