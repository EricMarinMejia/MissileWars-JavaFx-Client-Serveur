package missile_wars.frontal.vues;


import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import missile_wars.frontal.evenements.EvtAfficherFileAttente;
import missile_wars.frontal.evenements.EvtAfficherHistorique;

public class VueAccueil extends ViewFx {

	@FXML
	private Button boutonAfficherHistorique;
	
	@FXML
	private Button boutonAfficherFileAttente;
	
	

	@Override
	public void initialiser() {

		Ntro.assertNotNull("boutonAfficherHistorique", boutonAfficherHistorique);
		Ntro.assertNotNull("boutonAfficherFileAttente", boutonAfficherFileAttente);
		
		installerEvtAfficherHistorique();
		installerEvtAfficherFileAttente();

	}

	private void installerEvtAfficherHistorique() {
		EvtAfficherHistorique evtNtro = NtroApp.newEvent(EvtAfficherHistorique.class);

		boutonAfficherHistorique.setOnAction(evtFx -> {
			System.out.println("[VueAccueil] clic: " + evtFx.getEventType());
			evtNtro.trigger();
		});
	}
	
	private void installerEvtAfficherFileAttente() {
		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);
		
		this.boutonAfficherFileAttente.setOnAction(evtFx -> {
			evtNtro.trigger();
		});
	}
	

	
}
