package missile_wars.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import missile_wars.commun.messages.MsgNouvellePartie;
import missile_wars.commun.valeurs.ReferencePartie;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.vues.fragments.FragmentReferencePartieRejoindre;

public class VueFileAttente extends ViewFx {
    @FXML
    private Button boutonAjouterPartie;
//    @FXML
//    private Button boutonRetirerLesPages;
    @FXML
    private Button boutonVersMenu;
    
    @FXML
    private VBox conteneurPages;

    private ViewLoader<FragmentReferencePartieRejoindre> viewLoaderFragmentReferencePartieRejoindre;
    
    public ViewLoader<FragmentReferencePartieRejoindre> getViewLoaderFragmentReferencePartieRejoindre() {
        return viewLoaderFragmentReferencePartieRejoindre;
    }
    public void setViewLoaderFragmentReferencePartieRejoindre(ViewLoader<FragmentReferencePartieRejoindre> fragmentReferencePartieRejoindre) {
        this.viewLoaderFragmentReferencePartieRejoindre = fragmentReferencePartieRejoindre;
    }

    @Override
    public void initialiser() {
        Ntro.assertNotNull("boutonAjouterPartie", boutonAjouterPartie);
//        Ntro.assertNotNull("boutonRetirerLesPages", boutonRetirerLesPages);
        Ntro.assertNotNull("boutonVersMenu", boutonVersMenu);
        Ntro.assertNotNull("conteneurPages", conteneurPages);
        installerEvtAfficherMenu();
        installerMsgNouvellePartie();
    }

    private void installerEvtAfficherMenu() { 
        EvtAfficherMenu evenementNtro = NtroApp.newEvent(EvtAfficherMenu.class); 
        boutonVersMenu.setOnAction(evenementFx -> { 
            evenementNtro.trigger();
        });
    }

    public void installerMsgNouvellePartie() {
    	MsgNouvellePartie msgNouvellePartie = NtroApp.newMessage(MsgNouvellePartie.class);
    	boutonAjouterPartie.setOnAction(evtFx -> {
    		msgNouvellePartie.setQuantiteJoueursCible(2);
    		msgNouvellePartie.send();
    		
    		//installer l'écoute d'un message avertissant les clients qu'une nouvelle partie a été créé, afin de rejoindre cette partie.
    		
    	});
    }


    public void ajouterReferencePartie(ReferencePartie uneReferencePartie) {
        FragmentReferencePartieRejoindre fragment = viewLoaderFragmentReferencePartieRejoindre.createView();
        uneReferencePartie.afficherSur(fragment);
        conteneurPages.getChildren().add(fragment.rootNode());
    }

    public void viderListeFragmentReferencePartieRejoindre() { 
        conteneurPages.getChildren().clear();
    }
}
