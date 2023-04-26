package missile_wars.frontal.vues.fragments;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFragmentFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import missile_wars.commun.messages.MsgRetirerPartie;
import missile_wars.frontal.evenements.EvtAfficherHistorique;

public class FragmentPartie extends ViewFragmentFx {

	@FXML
	private Label resultatPartie;
	
	@FXML
	private Label labelNomPremierJoueur;
	
	@FXML
	private Label labelNomDeuxiemeJoueur;
	
	@FXML
	private Label labelNbMissilesJ1;
	
	@FXML
	private Label labelNbMissilesJ2;
	
	@FXML
	private Label labelPointageJ1;
	
	@FXML
	private Label labelPointageJ2;
	
	@FXML
	private Label labelDate;
	
	@FXML
	private Button boutonRetirerPartie;
	
	private String idPartie;
	
	@Override
	public void initialiser() {
		Ntro.assertNotNull("resultatPartie", resultatPartie);
		Ntro.assertNotNull("labelNomPremierJoueur", labelNomPremierJoueur);
		Ntro.assertNotNull("labelNomDeuxiemeJoueur", labelNomDeuxiemeJoueur);
		Ntro.assertNotNull("labelNbMissilesJ1", labelNbMissilesJ1);
		Ntro.assertNotNull("labelNbMissilesJ2", labelNbMissilesJ2);
		Ntro.assertNotNull("labelPointageJ1", labelPointageJ1);
		Ntro.assertNotNull("labelPointageJ2", labelPointageJ2);
		Ntro.assertNotNull("labelDate", labelDate);
		Ntro.assertNotNull("boutonRetirerPartie", boutonRetirerPartie);
		
		installerEvtAfficherPartie();
	}
	
	private void installerEvtAfficherPartie() {
		EvtAfficherHistorique evtNtro = NtroApp.newEvent(EvtAfficherHistorique.class);
		
		boutonRetirerPartie.setOnAction(evtFx -> {
			evtNtro.trigger();
		});
	}
	
	public void afficherResultatPartie(String resultat) {
		String resultatTraduit = this.resources().getString(resultat);
		resultatPartie.setText(resultatTraduit);
	}
	
	public void afficherNomPremierJoueur(String nomJ1) {
		labelNomPremierJoueur.setText(nomJ1);
	}
	
	public void afficherNomDeuxiemeJoueur(String nomJ2) {
		labelNomDeuxiemeJoueur.setText(nomJ2);
	}
	
	public void afficherNbMissileJ1(String nbMissiles) {
		labelNbMissilesJ1.setText(nbMissiles);
	}
	
	public void afficherNbMissileJ2(String nbMissiles) {
		labelNbMissilesJ2.setText(nbMissiles);
	}
	
	public void afficherPointageJ1(String nbPoints) {
		labelPointageJ1.setText(nbPoints);
	}
	
	public void afficherPointageJ2(String nbPoints) {
		labelPointageJ2.setText(nbPoints);
	}
	
	public void afficherDate(String date) {
		labelDate.setText(date);
	}
	
	public void memoriserIdPartie(String idPartie) {
		this.idPartie = idPartie;
		installerMsgRetirerPartie(idPartie);
	}
	
	protected void installerMsgRetirerPartie(String idRendezVous) {
		MsgRetirerPartie msgRetirerPartie = NtroApp.newMessage(MsgRetirerPartie.class);
		msgRetirerPartie.setIdPartie(idRendezVous);
		
		boutonRetirerPartie.setOnAction(evtFx -> {
			msgRetirerPartie.send();
		});
	}

}
