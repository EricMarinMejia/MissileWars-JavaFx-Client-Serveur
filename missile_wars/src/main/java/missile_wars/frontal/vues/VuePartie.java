package missile_wars.frontal.vues;

import java.util.List;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import missile_wars.commun.enums.ActionsJoueurEnum;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.frontal.controles.CanvasPartie;
import missile_wars.frontal.evenements.EvtActionJoueur;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.evenements.EvtAjouterMissile;
import missile_wars.frontal.evenements.EvtTouchePressed;
import missile_wars.frontal.evenements.EvtToucheReleased;

public class VuePartie extends ViewFx {

	@FXML
	private Button boutonQuitter;
	
	@FXML
	private CanvasPartie canvasPartie;
	
	@FXML
	private Label labelNomJoueur1;
	
	@FXML
	private Label labelNomJoueur2;
	
	@FXML 
	private Label labelScoreJoueur1;
	
	@FXML
	private Label labelScoreJoueur2;
	
	@FXML
	private VBox vboxPartie;
	
	

	@Override
	public void initialiser() {
		
		Ntro.assertNotNull("labelNomJoueur1", labelNomJoueur1);
		Ntro.assertNotNull("labelNomJoueur2", labelNomJoueur2);
		Ntro.assertNotNull("labelScoreJoueur1", labelScoreJoueur1);
		Ntro.assertNotNull("labelScoreJoueur2", labelScoreJoueur2);
		
		
		Ntro.assertNotNull("boutonQuitter", boutonQuitter);
		Ntro.assertNotNull("canvasPartie", canvasPartie);
		Ntro.assertNotNull("vboxPartie", vboxPartie);
		
		installerEvtAfficherAccueil();
		installerEvtActionJoueur();

	}

	private void installerEvtAfficherAccueil() {
		EvtAfficherMenu evtNtro = NtroApp.newEvent(EvtAfficherMenu.class);

		boutonQuitter.setOnAction(evtFx -> {
			System.out.println("[VuePartie] clic: " + evtFx.getEventType());
			evtNtro.trigger();
		});
	}
	
	
	private void installerEvtActionJoueur() {
		
        EvtTouchePressed evtNtro = NtroApp.newEvent(EvtTouchePressed.class);
        EvtToucheReleased evtNtroReleased = NtroApp.newEvent(EvtToucheReleased.class);
        EvtAjouterMissile evtNtroMissile = NtroApp.newEvent(EvtAjouterMissile.class);

        vboxPartie.addEventFilter(KeyEvent.KEY_PRESSED, evtFx -> {
        	
        	if(evtFx.getCode().equals(KeyCode.D)) {

                evtNtro.setTouche(KeyCode.D.toString());
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.A)) {

            	evtNtro.setTouche(KeyCode.A.toString());
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.W)) {

            	evtNtroMissile.trigger();

            }
        });

        vboxPartie.addEventFilter(KeyEvent.KEY_RELEASED, evtFx -> {

            if(evtFx.getCode().equals(KeyCode.A)
                    || evtFx.getCode().equals(KeyCode.D)
                    || evtFx.getCode().equals(KeyCode.W)) {

                evtNtroReleased.trigger();

            }
        });
    }

	public void viderCanvas() {
		canvasPartie.clearCanvas();
	}

	public void afficherMissileWars2d(MondeMissileWars2d mondeMS2d) {
		mondeMS2d.drawOn(canvasPartie);
		
	}
	
	public void afficherImagesParSecondes(String fps) {
		canvasPartie.afficherFps(fps);
	}
	
	public void afficherLignesDeTexte(List<String> lignes) {
		this.canvasPartie.afficherLignesDeTexte(lignes);
	}
	
	public void afficherNomPremierJoueur(String nomPremierJoueur) {
		labelNomJoueur1.setText(nomPremierJoueur);
	}
	
	public void afficherNomDeuxiemeJoueur(String nomDeuxiemeJoueur) {
		labelNomJoueur2.setText(nomDeuxiemeJoueur);
	}
	
	public void afficherScorePremierJoueur(String scorePremierJoueur) {
		labelScoreJoueur1.setText(scorePremierJoueur);
	}
	
	public void afficherScoreDeuxiemeJoueur(String scoreDeuxiemeJoueur) {
		labelScoreJoueur2.setText(scoreDeuxiemeJoueur);
	}

}

