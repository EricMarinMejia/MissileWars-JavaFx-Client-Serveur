package missile_wars.frontal.vues.fragments;

import ca.ntro.app.views.ViewFragmentFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import missile_wars.commun.valeurs.KeyStringRepresentation;
import missile_wars.maquettes.MaquetteTouches;

public class FragmentActionTouche extends ViewFragmentFx {
	@FXML
	private Label lblNom = null;
	
	@FXML
	private Button btnChanger = null;

	@Override
	public void initialiser() {
		Ntro.assertNotNull(this.lblNom);
		Ntro.assertNotNull(this.btnChanger);
		
		this.installerBtnChanger();
	}
	
	private void installerBtnChanger() {
		this.btnChanger.setOnAction(evtFx -> {
			this.setTouche(new KeyStringRepresentation(MaquetteTouches.toucheAleatoire()));
		});
	}
	
	
	
	private String action = "";
	private KeyStringRepresentation touche = null;
	
	public void setAction(String action) {
		this.action = action;
//		this.lblNom.setText(action);
		this.lblNom.setText(this.resources().getString(action));
	}
	public String getAction() {
		return this.action;
	}
	
	public void setTouche(KeyStringRepresentation touche) {
		this.touche = touche.clone();
		this.btnChanger.setText(touche.getValue());
	}
	public KeyStringRepresentation getTouche() {
		return this.touche;
	}

}