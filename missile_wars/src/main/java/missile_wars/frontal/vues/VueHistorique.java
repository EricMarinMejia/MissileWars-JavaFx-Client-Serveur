package missile_wars.frontal.vues;

import java.util.List;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import missile_wars.commun.modeles.ModeleHistorique;
import missile_wars.commun.modeles.ModelePartie;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.vues.fragments.FragmentPartie;

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
		List<ModelePartie> partie = modele.getLesPartiesJouees();
	}
	
	private void installerEvtRevenirMenu() {
		EvtAfficherMenu evtAfficherAccueil = NtroApp.newEvent(EvtAfficherMenu.class);
		
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
	
	public void ajouterPartie(ModelePartie partie) {
		FragmentPartie fragment = partie.creerFragment(viewLoaderParties);
		partie.afficherSur(fragment);
		
		conteneurParties.getChildren().add(fragment.rootNode());
	}
	
	public void viderListeParties() {
		conteneurParties.getChildren().clear();
	}

}
