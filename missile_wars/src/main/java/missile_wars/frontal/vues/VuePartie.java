package missile_wars.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import missile_wars.commun.enums.Action;
import missile_wars.commun.enums.Cadran;
import missile_wars.commun.modeles.valeurs.ActionJoueur;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.frontal.controles.CanvasPartie;
import missile_wars.frontal.evenements.EvtActionJoueur;
import missile_wars.frontal.evenements.EvtAfficherHistorique;

public class VuePartie extends ViewFx {

	@FXML
	private Button boutonQuitter;
	
	@FXML
	private CanvasPartie canvasJeu;
	
	@FXML
	private Label labelNomPremierJoueur;
	
	@FXML
	private Label labelNomDeuxiemeJoueur;
	
	@FXML 
	private Label labelScorePremierJoueur;
	
	@FXML
	private Label labelScoreDeuxiemeJoueur;
	
	@FXML
	private VBox vboxPartie;
	
	

	@Override
	public void initialiser() {
		Ntro.assertNotNull("labelNomPremierJoueur", labelNomPremierJoueur);
		Ntro.assertNotNull("labelNomDeuxiemeJoueur", labelNomDeuxiemeJoueur);
		Ntro.assertNotNull("labelScorePremierJoueur", labelScorePremierJoueur);
		Ntro.assertNotNull("labelScoreDeuxiemeJoueur", labelScoreDeuxiemeJoueur);
		
		
		Ntro.assertNotNull("boutonQuitter", boutonQuitter);
		Ntro.assertNotNull(canvasJeu);
		
		Ntro.assertNotNull("vboxPartie", vboxPartie);
		
		installerEvtAfficherAccueil();
		installerEvtActionJoueur();

	}

	private void installerEvtAfficherAccueil() {
		EvtAfficherHistorique evtNtro = NtroApp.newEvent(EvtAfficherHistorique.class);

		boutonQuitter.setOnAction(evtFx -> {
			System.out.println("[VuePartie] clic: " + evtFx.getEventType());
			evtNtro.trigger();
		});
	}
	
	private void installerEvtActionJoueur() {

        EvtActionJoueur evtNtro = NtroApp.newEvent(EvtActionJoueur.class);

        vboxPartie.addEventFilter(KeyEvent.KEY_PRESSED, evtFx -> {

            if(evtFx.getCode().equals(KeyCode.W)) {

                evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.HAUT));
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.S)) {

                evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.BAS));
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.D)) {

                evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.DROITE));
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.A)) {

                evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.GAUCHE));
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.E)) {

                evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.TIRER));
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.UP)) {

                evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.HAUT));
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.DOWN)) {

                evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.BAS));
                evtNtro.trigger();
            }else if(evtFx.getCode().equals(KeyCode.RIGHT)) {

                evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.DROITE));
                evtNtro.trigger();
            }else if(evtFx.getCode().equals(KeyCode.LEFT)) {

                evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.GAUCHE));
                evtNtro.trigger();
            }else if(evtFx.getCode().equals(KeyCode.L)) {

                evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.TIRER));
                evtNtro.trigger();
            }
        });

        vboxPartie.addEventFilter(KeyEvent.KEY_RELEASED, evtFx -> {

            if(evtFx.getCode().equals(KeyCode.W)
                    || evtFx.getCode().equals(KeyCode.S)
                    || evtFx.getCode().equals(KeyCode.A)
                    || evtFx.getCode().equals(KeyCode.D)) {

                evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.ARRET));
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.UP)
                    || evtFx.getCode().equals(KeyCode.DOWN)
                    || evtFx.getCode().equals(KeyCode.LEFT)
                    || evtFx.getCode().equals(KeyCode.RIGHT)) {

                evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.ARRET));
                evtNtro.trigger();
            }
        });
    }

	public void viderCanvas() {
		canvasJeu.clearCanvas();
	}

	public void afficherMissileWars2d(MondeMissileWars2d mondeMS2d) {
		mondeMS2d.drawOn(canvasJeu);
		
	}
	
	public void afficherImagesParSecondes(String fps) {
		canvasJeu.afficherFps(fps);
	}
	
	public void afficherNomPremierJoueur(String nomPremierJoueur) {
		labelNomPremierJoueur.setText(nomPremierJoueur);
	}
	
	public void afficherNomDeuxiemeJoueur(String nomDeuxiemeJoueur) {
		labelNomDeuxiemeJoueur.setText(nomDeuxiemeJoueur);
	}
	
	public void afficherScorePremierJoueur(String scorePremierJoueur) {
		labelScorePremierJoueur.setText(scorePremierJoueur);
	}
	
	public void afficherScoreDeuxiemeJoueur(String scoreDeuxiemeJoueur) {
		labelScoreDeuxiemeJoueur.setText(scoreDeuxiemeJoueur);
	}

}
