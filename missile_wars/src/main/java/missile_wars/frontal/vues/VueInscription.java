package missile_wars.frontal.vues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import missile_wars.commun.messages.MsgModifierNomJoueur;
import missile_wars.commun.valeurs.KeyStringRepresentation;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.evenements.EvtRemettreInfosActuelles;
import missile_wars.frontal.evenements.EvtRemettreTouchesParDefaut;
import missile_wars.frontal.taches.Session;
import missile_wars.frontal.vues.fragments.FragmentActionTouche;

public class VueInscription extends ViewFx {
	
	@FXML
	private Button buttonAnnuler;
	
	@FXML
	private Button buttonReset;
	@FXML
	private Button buttonValider;
	@FXML
	private TextField tfNomJoueur;
	
	
	//données actuelles du backend
	private String nomJoueurActuel = "";
	
	
	
	

	@Override
	public void initialiser() {
		Ntro.assertNotNull("buttonAnnuler", this.buttonAnnuler);
		Ntro.assertNotNull("buttonReset", this.buttonReset);
		Ntro.assertNotNull("buttonValider", this.buttonValider);
		Ntro.assertNotNull("tfNomJoueur", this.tfNomJoueur);
		

		this.installerButtonAnnuler();
		this.installerButtonReset();
		this.installerBoutonValider();
	}
	
	
	private void installerButtonAnnuler() {
		EvtRemettreInfosActuelles evtRemettreInfosActuelles = NtroApp.newEvent(EvtRemettreInfosActuelles.class);
		EvtAfficherMenu evtAfficherMenu = NtroApp.newEvent(EvtAfficherMenu.class);
		
		this.buttonAnnuler.setOnAction(evtFx -> {
			evtRemettreInfosActuelles.trigger();
			evtAfficherMenu.trigger();
		});
		
	}

	
	private void installerButtonReset() {
		EvtRemettreTouchesParDefaut evtRemettreTouchesParDefaut = NtroApp.newEvent(EvtRemettreTouchesParDefaut.class);
		
		this.buttonReset.setOnAction(evtFx -> {
			evtRemettreTouchesParDefaut.trigger();
		});
		
	}

	private void installerBoutonValider() {
		EvtAfficherMenu evtAfficherMenu= NtroApp.newEvent(EvtAfficherMenu.class);
//		MsgActualiserInscriptionJoueur msgActualiser = NtroApp.newMessage(MsgActualiserInscriptionJoueur.class);
		MsgModifierNomJoueur msgModifierNomJoueur = NtroApp.newMessage(MsgModifierNomJoueur.class);
		this.buttonValider.setOnAction(evtFx -> {
			
			msgModifierNomJoueur.setIdJoueur(Session.idJoueur);
			msgModifierNomJoueur.setNom(this.tfNomJoueur.getText());
//			msgActualiser.setNomJoueur(this.tfNomJoueur.getText());
//			
//			Map<String, KeyStringRepresentation> touches = new HashMap<>();
//			for (FragmentActionTouche fragment : this.fragments) {
//				touches.put(fragment.getAction(), fragment.getTouche());
//			}
//			msgActualiser.setTouches(touches);
			
			msgModifierNomJoueur.send();
			evtAfficherMenu.trigger();
		});
	}
	
	
	
	
	public void remettreInfosActuelles() {
		this.tfNomJoueur.setText(this.nomJoueurActuel);
	}
	
	
	
	public void afficherNom(String nom) {
		this.tfNomJoueur.setText(nom);
	}

}