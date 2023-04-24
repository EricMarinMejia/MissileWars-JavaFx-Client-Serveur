package missile_wars.frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import missile_wars.commun.messages.MsgRetirerPartie;
import missile_wars.commun.modeles.ModeleHistorique;
import missile_wars.commun.modeles.valeurs.Partie;
import missile_wars.frontal.evenements.EvtAfficherAccueil;
import missile_wars.frontal.fragments.FragmentPartie;

public class VueHistorique extends ViewFx {
	
	@FXML
	private Button boutonRevenirMenu;
	
	@FXML
	private VBox conteneurParties;
	
	private ViewLoader<FragmentPartie> viewLoaderParties;

	@Override
	public void initialiser() {
		Ntro.assertNotNull("boutonRevenirMenu", boutonRevenirMenu);
		Ntro.assertNotNull("conteneurParties", conteneurParties);
		installerEvtRevenirMenu();
	}
	
	public void afficher(ModeleHistorique modele) {
		List<Partie> partie = modele.getLesPartiesJouees();
	}
	
	private void installerEvtRevenirMenu() {
		EvtAfficherAccueil evtAfficherAccueil = NtroApp.newEvent(EvtAfficherAccueil.class);
		
		boutonRevenirMenu.setOnAction(evtFx -> {
			System.out.println("[VueHistorique] clic: " + evtFx.getEventType());
			evtAfficherAccueil.trigger();
		});
	}

	public ViewLoader<FragmentPartie> getViewLoaderParties() {
		return viewLoaderParties;
	}

	public void setViewLoaderParties(ViewLoader<FragmentPartie> viewLoaderParties) {
		this.viewLoaderParties = viewLoaderParties;
	}
	
	public void ajouterPartie(Partie partie) {
		FragmentPartie fragment = partie.creerFragment(viewLoaderParties);
		partie.afficherSur(fragment);
		
		conteneurParties.getChildren().add(fragment.rootNode());
	}
	
	public void viderListeParties() {
		conteneurParties.getChildren().clear();
	}

}
