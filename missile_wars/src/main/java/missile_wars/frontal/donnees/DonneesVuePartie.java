package missile_wars.frontal.donnees;


import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewData;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.core.initialization.Ntro;
import missile_wars.commun.enums.EtatPartie;
import missile_wars.commun.messages.MsgModifierPositionJoueur;
import missile_wars.commun.modeles.ModelePartie;
import missile_wars.commun.monde2d.Joueur2d;
import missile_wars.commun.monde2d.Missile2d;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.commun.valeurs.Equipe;
import missile_wars.commun.valeurs.Missile;
import missile_wars.commun.valeurs.Plancher;
import missile_wars.commun.valeurs.ReferenceJoueur;
import missile_wars.frontal.evenements.EvtTouchePressed;
import missile_wars.frontal.evenements.EvtToucheReleased;
import missile_wars.frontal.vues.VuePartie;

public class DonneesVuePartie implements ViewData {
	
	private int idJoueur = -1; //id du joueur this, nous.
	private String idPartie = "";
	
	public void memoriserIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public void memoriserIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}
	

	private List<Equipe> lesEquipes = new ArrayList<>();
	private List<Plancher> lesPlanchers = new ArrayList<>();
	private List<Missile> lesMissiles= new ArrayList<>();
	private int quantiteJoueursCible = 2; //un nombre pair.
	private int etatPartie = EtatPartie.NULLE.ordinal();
	
	
	private ReferenceJoueur obtenirReferenceJoueurThis() {
		for (Equipe equipe : this.lesEquipes) {
			for (ReferenceJoueur referenceJoueur : equipe.getLesJoueurs()) {
				if (referenceJoueur.getIdJoueur() == this.idJoueur) {
					return referenceJoueur;
				}
			}
		}
		return null;
	}
	

	private MondeMissileWars2d mondeMissileWars2d = new MondeMissileWars2d();
	private String fpsCourant = "0";
	

    private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;


    private long horodatageDernierCalculFps = Ntro.time().nowMilliseconds();
    private long imagesAfficheesDepuisDernierCalculFps = 0;

    public void afficherSur(VuePartie vuePartie) {
        calculerFpsSiNecessaire();

        vuePartie.viderCanvas();
//        vuePartie.afficherImagesParSecondes(fpsCourant);
//        vuePartie.afficherImagesParSeconde("FPS " + fpsCourant);
        
        List<String> testList = new ArrayList<>();
        testList.add(EtatPartie.aPartirDeInt(this.etatPartie).name());
        for (int indexEquipe = 0; indexEquipe < this.lesEquipes.size(); indexEquipe++) {
        	Equipe equipe = this.lesEquipes.get(indexEquipe);
        	testList.add("Equipe #" + String.valueOf(indexEquipe));
        	for (ReferenceJoueur referenceJoueur : equipe.getLesJoueurs()) {
        		testList.add("    Joueur id=" + String.valueOf(referenceJoueur.getIdJoueur()));
        	}
        }
        vuePartie.afficherLignesDeTexte(testList);
        
        
        vuePartie.afficherMissileWars2d(mondeMissileWars2d);

        imagesAfficheesDepuisDernierCalculFps++;
    }
    

    private void calculerFpsSiNecessaire() {
        long horodatageMaintenant = Ntro.time().nowMilliseconds();
        long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFps;

        if(millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
            calculerFpsMaintenant(millisecondesEcoulees);

            imagesAfficheesDepuisDernierCalculFps = 0;
            horodatageDernierCalculFps = horodatageMaintenant;
        }
    }

    private void calculerFpsMaintenant(long millisecondesEcoulees) {
        double secondesEcoulees = millisecondesEcoulees / 1E3;
        double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;
        fpsCourant = String.valueOf(Math.round(fps));
    }
    
    public void reagirTempsQuiPasse(double elapsedTime) {
    	mondeMissileWars2d.onTimePasses(elapsedTime);
    }

    public void copierDonneesDe(ModelePartie modelePartie) {
    	mondeMissileWars2d.copyDataFrom(modelePartie.getMondeMS2d());
    	
    	this.lesEquipes = modelePartie.getLesEquipes();
    	this.quantiteJoueursCible = modelePartie.getQuantiteJoueursCible();
    	this.etatPartie = modelePartie.getEtatPartie();
    	this.lesPlanchers = modelePartie.getLesPlancher();
    	this.lesMissiles = modelePartie.getLesMissiles();
    	
    	
    	for (int i = 0; i < lesEquipes.size(); i++) {
    		
    		List<ReferenceJoueur> joueursEquipeModele = lesEquipes.get(i).getLesJoueurs();
    		List<Joueur2d> joueursEquipeModele2d = this.mondeMissileWars2d.getListeEquipes().get(i).getListeJoueurs();
    		
    		
    		while (joueursEquipeModele.size() > joueursEquipeModele2d.size()) {
    			joueursEquipeModele2d.add(new Joueur2d());
    		}
    		//TODO RETIRER LES JOUEURS EN TROP
    		
    		for (int j = 0; j < joueursEquipeModele.size(); j++) {
    			joueursEquipeModele2d.get(j).setPosition(joueursEquipeModele.get(j).getPosition());
    		}
    		
    	}
    	
    	for (int i = 0; i < lesPlanchers.size(); i++) {
    		this.mondeMissileWars2d.getListePlanchers().get(i).setTableauPlancher(lesPlanchers.get(i).getTableauPlancher());
    
    	}
    	
    	//TODO les missiles
    	
    	List<Missile2d> lesMissiles2d = this.mondeMissileWars2d.getListeMissiles();
    	
    	while (lesMissiles.size() >  lesMissiles2d.size()) {
    		lesMissiles2d.add(new Missile2d());
    	}
    	
    	
    	
    }
    
    MsgModifierPositionJoueur msgModifierPositionJoueur = NtroApp.newMessage(MsgModifierPositionJoueur.class);
    
    public void appliquerTouchePressed(EvtTouchePressed evt) {
    	
    	ReferenceJoueur joueur = obtenirReferenceJoueurThis();
    	double positionActuelle = joueur.getPosition();
    	
    	if (evt.getTouche() == "D") {
    		joueur.setPosition(positionActuelle + 0.2);
    	} else if (evt.getTouche() == "A") {
    		joueur.setPosition(positionActuelle - 0.2);
    	}
    	
    	positionActuelle = joueur.getPosition();
    	this.msgModifierPositionJoueur.setIdJoueur(idJoueur);
    	this.msgModifierPositionJoueur.setIdPartie(idPartie);
    	this.msgModifierPositionJoueur.setPosition(positionActuelle);
    	this.msgModifierPositionJoueur.setChannelId(idPartie);
    	
    	msgModifierPositionJoueur.send();
    }
    
    public void appliquerToucheReleased(EvtToucheReleased evt) {
    	
    }
    
    
	public void reagirClicSouris(World2dMouseEventFx evt) {
		mondeMissileWars2d.dispatchMouseEvent(evt);
	}
	
}


















