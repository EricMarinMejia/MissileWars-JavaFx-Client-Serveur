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
import missile_wars.commun.messages.MsgActualiserInscriptionJoueur;
import missile_wars.commun.valeurs.KeyStringRepresentation;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.evenements.EvtRemettreInfosActuelles;
import missile_wars.frontal.evenements.EvtRemettreTouchesParDefaut;
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
	
	@FXML
	private VBox vbAssociationContainer;
	
	
	private List<FragmentActionTouche> fragments = new ArrayList<>();
	

	ViewLoader<FragmentActionTouche> viewLoaderActionTouche;
	
	public ViewLoader<FragmentActionTouche> getViewLoaderActionTouche() {
		return viewLoaderActionTouche;
	}

	public void setViewLoaderActionTouche(ViewLoader<FragmentActionTouche> viewLoaderActionTouche) {
		this.viewLoaderActionTouche = viewLoaderActionTouche;
	}
	
	
	
	
	
	
	private void putTouches(Map<String, KeyStringRepresentation> source, Map<String, KeyStringRepresentation> dest) {
		for (Entry<String, KeyStringRepresentation> entry : source.entrySet()) {
			dest.put(entry.getKey(), entry.getValue().clone());
		}
	}
	
	
	
	
	//données actuelles du backend
	private String nomJoueurActuel = "";
	private Map<String, KeyStringRepresentation> touchesActuel = new HashMap<>();
	private Map<String, KeyStringRepresentation> touchesParDefaut = new HashMap<>();
	
	public void memoriserNomJoueur(String value) {
		this.nomJoueurActuel = value;
	}
	
	public void memoriserTouches(Map<String, KeyStringRepresentation> value) {
		this.putTouches(value, this.touchesActuel);
	}
	
	public void memoriserTouchesDefaut(Map<String, KeyStringRepresentation> value) {
		this.putTouches(value, this.touchesParDefaut);
	}
	
	
	
	
	
	

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
		MsgActualiserInscriptionJoueur msgActualiser = NtroApp.newMessage(MsgActualiserInscriptionJoueur.class);
		this.buttonValider.setOnAction(evtFx -> {
			
			msgActualiser.setNomJoueur(this.tfNomJoueur.getText());
			
			Map<String, KeyStringRepresentation> touches = new HashMap<>();
			for (FragmentActionTouche fragment : this.fragments) {
				touches.put(fragment.getAction(), fragment.getTouche());
			}
			msgActualiser.setTouches(touches);
			
			msgActualiser.send();
			evtAfficherMenu.trigger();
		});
	}
	
	
	
	
	public void remettreInfosActuelles() {
		this.tfNomJoueur.setText(this.nomJoueurActuel);
		this.afficherTouchesEcraser(this.touchesActuel);
	}
	
	public void remettreTouchesParDefaut() {
		this.afficherTouchesEcraser(this.touchesParDefaut);
	}
	
	
	
	public void afficherNom(String nom) {
		this.tfNomJoueur.setText(nom);
	}

	public void viderTouches() {
		this.fragments.clear();
		this.vbAssociationContainer.getChildren().clear();
	}
	
	public void afficherTouche(String action, KeyStringRepresentation touche) {
		FragmentActionTouche fragment = this.viewLoaderActionTouche.createView();
		fragment.setAction(action);
		fragment.setTouche(touche);
		
		this.fragments.add(fragment);
		this.vbAssociationContainer.getChildren().add(fragment.rootNode());
	}
	
	private void afficherTouchesEcraser(Map<String, KeyStringRepresentation> touches) {
		this.viderTouches();
		for (Entry<String, KeyStringRepresentation> entry : touches.entrySet()) {
			this.afficherTouche(entry.getKey(), entry.getValue());
		}
	}
}