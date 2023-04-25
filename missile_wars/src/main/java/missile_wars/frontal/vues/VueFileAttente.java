package missile_wars.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import missile_wars.frontal.evenements.EvtAfficherAccueil;

public class VueFileAttente extends ViewFx {
	
	
	@FXML
	private Button boutonAfficherAccueil;
	
	@FXML
	private Button boutonNouvellePartie2;
	
	@Override
	public void initialiser() {
		Ntro.assertNotNull("boutonAfficherAccueil", boutonAfficherAccueil);
		Ntro.assertNotNull("boutonNouvellePartie2", boutonNouvellePartie2);
		
		installerEvtAfficherAccueil();
	}
	
	private void installerEvtAfficherAccueil() {
		EvtAfficherAccueil evtAfficherAccueil = NtroApp.newEvent(EvtAfficherAccueil.class);
		
		boutonAfficherAccueil.setOnAction(evtFx -> {
			evtAfficherAccueil.trigger();
		});
	}
	
	
	
	
}