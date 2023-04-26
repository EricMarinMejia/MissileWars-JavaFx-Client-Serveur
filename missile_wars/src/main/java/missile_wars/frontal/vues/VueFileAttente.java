package missile_wars.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import missile_wars.commun.messages.MsgNouvellePartie;
import missile_wars.commun.valeurs.Page;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.vues.fragments.FragmentPage;

public class VueFileAttente extends ViewFx {
    @FXML
    private Button boutonAjouterPartie;
//    @FXML
//    private Button boutonRetirerLesPages;
    @FXML
    private Button boutonVersMenu;
    
    @FXML
    private VBox conteneurPages;

    private ViewLoader<FragmentPage> fragmentPage;
    
    public ViewLoader<FragmentPage> getFragmentPage() {
        return fragmentPage;
    }
    public void setFragmentPage(ViewLoader<FragmentPage> fragmentPage) {
        this.fragmentPage = fragmentPage;
    }

    @Override
    public void initialiser() {
        Ntro.assertNotNull("boutonAjouterPartie", boutonAjouterPartie);
//        Ntro.assertNotNull("boutonRetirerLesPages", boutonRetirerLesPages);
        Ntro.assertNotNull("boutonVersMenu", boutonVersMenu);
        Ntro.assertNotNull("conteneurPages", conteneurPages);
        installerEvtAfficherMenu();
        installerMsgAjouterPartie();
        installerMsgRetirerPages();
    }

    private void installerEvtAfficherMenu() { 
        EvtAfficherMenu evenementNtro = NtroApp.newEvent(EvtAfficherMenu.class); 
        boutonVersMenu.setOnAction(evenementFx -> { 
            evenementNtro.trigger();
        });
    }

    public void installerMsgAjouterPartie() {
    	MsgNouvellePartie msgNouvellePartie = new MsgNouvellePartie();
    	boutonAjouterPartie.setOnAction(evtFx -> {
    		msgNouvellePartie.setQuantiteJoueursCible(2);
    		msgNouvellePartie.send();
    	});
    }

    public void installerMsgRetirerPages() { 
//        MsgRetirerPages msgRetirerPages = NtroApp.newMessage(MsgRetirerPages.class);
//        boutonRetirerLesPages.setOnAction(evevenementFx -> { 
//            msgRetirerPages.send();
//        });
    }

    public void ajouterPage(Page unePage) {
        FragmentPage fragment = unePage.creerFragment(fragmentPage);
        unePage.afficherSur(fragment);
        conteneurPages.getChildren().add(fragment.rootNode());
    }

    public void viderListePages() { 
        conteneurPages.getChildren().clear();
    }
}
