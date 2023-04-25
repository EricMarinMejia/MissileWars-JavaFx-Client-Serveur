package missile_wars.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import missile_wars.frontal.evenements.EvtAfficherDidacticiel;
import missile_wars.frontal.evenements.EvtAfficherInscription;
import missile_wars.frontal.evenements.EvtAfficherParametres;

public class VueMenu extends ViewFx {
	@FXML
	private Button boutonVersInscription;
	@FXML
	private Button boutonVersParametres;
	@FXML
	private Button boutonVersDidacticiel;

	@Override
	public void initialiser() {
		Ntro.assertNotNull("boutonVersParametres", boutonVersParametres);
		Ntro.assertNotNull("boutonVersDidacticiel", boutonVersDidacticiel);
		Ntro.assertNotNull("boutonVersInscription", boutonVersInscription);
		installerEvtAfficherParametres();
		installerEvtAfficherInscription();
		installerEvtAfficherDidacticiel();
	}

	private void installerEvtAfficherInscription() {
		EvtAfficherInscription evtNtro = NtroApp.newEvent(EvtAfficherInscription.class);
		boutonVersInscription.setOnAction(evtFx -> {
			evtNtro.trigger();
		});
	}

	private void installerEvtAfficherDidacticiel() {
		EvtAfficherDidacticiel evtNtro = NtroApp.newEvent(EvtAfficherDidacticiel.class);
		boutonVersDidacticiel.setOnAction(evtFx -> {
			evtNtro.trigger();
		});
	}

	private void installerEvtAfficherParametres() {
		EvtAfficherParametres evtNtro = NtroApp.newEvent(EvtAfficherParametres.class);
		boutonVersParametres.setOnAction(evtFx -> {
			evtNtro.trigger();
		});
	}
}