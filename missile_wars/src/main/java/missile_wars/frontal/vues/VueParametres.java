package missile_wars.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import missile_wars.commun.maquettes.MaquetteCouleurs;
import missile_wars.commun.messages.MsgAjouterCouleur;
import missile_wars.commun.valeurs.Couleur;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.vues.fragments.FragmentCouleur;

public class VueParametres extends ViewFx {

	@FXML
	private Label labelParametres;
	@FXML
	private Button boutonJoindreMenu;
	@FXML
	private Button boutonAddColor;
	@FXML
    private VBox conteneurCouleurs;
	 
	private ViewLoader<FragmentCouleur> viewLoaderCouleurs;

	public ViewLoader<FragmentCouleur> getViewLoaderCouleurs() {
		return viewLoaderCouleurs;
	}

	public void setViewLoaderCouleurs(ViewLoader<FragmentCouleur> viewLoaderCouleurs) {
		this.viewLoaderCouleurs = viewLoaderCouleurs;
	}

	@Override
	public void initialiser() {
		//Ntro.assertNotNull("labelParametres", labelParametres);
		//Ntro.assertNotNull("boutonJoindreMenu", boutonJoindreMenu);
		//installerEvtAfficherParametres();
		installerMsgAjouterCouleurs();
		Ntro.assertNotNull("boutonSInscrire", boutonAddColor);
		Ntro.assertNotNull("conteneurCouleurs", conteneurCouleurs);

	}

//	public void afficherParametresEnTexte(String message) {
//		System.out.println("Roxanne");
//		labelParametres.setText(message);
//	}

//	private void installerEvtAfficherParametres() {
//		EvtAfficherMenu evtNtro = NtroApp.newEvent(EvtAfficherMenu.class);
//		boutonJoindreMenu.setOnAction(evtFx -> {
//			evtNtro.trigger();
//		});
//	}
    private void installerMsgAjouterCouleurs() {
    	MsgAjouterCouleur msgAjouterCouleur = NtroApp.newMessage(MsgAjouterCouleur.class);
    	boutonAddColor.setOnAction(evtFx -> {
            // On a un clic
        	// l'usager courant s'inscrit
        	msgAjouterCouleur.setCouleur(MaquetteCouleurs.couleurCourante());
        	msgAjouterCouleur.send();
            // à chaque clic, on passe à un nouvel usager
            MaquetteCouleurs.prochaineCouleur();
        });
    }
	public void ajouterCouleur(Couleur couleur) {
		FragmentCouleur fragment = couleur.creerFragment(viewLoaderCouleurs);
		couleur.afficherSur(fragment);

		conteneurCouleurs.getChildren().add(fragment.rootNode());
	}
	public void viderListeCouleurs() {
		conteneurCouleurs.getChildren().clear();
	}

}


