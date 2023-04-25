
package missile_wars.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import missile_wars.commun.messages.MsgAjouterUnePage;
import missile_wars.commun.messages.MsgRetirerPages;
import missile_wars.commun.valeurs.Page;
import missile_wars.frontal.evenements.EvtAfficherMenu;
import missile_wars.frontal.vues.fragments.FragmentPage;
import missile_wars.maquettes.MaquettePages;

public class VueFileAttente extends ViewFx {
    @FXML
    private Button boutonAjouterPage;
    @FXML
    private Button boutonRetirerLesPages;
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
        Ntro.assertNotNull("boutonAjouterPage", boutonAjouterPage);
        Ntro.assertNotNull("boutonRetirerLesPages", boutonRetirerLesPages);
        Ntro.assertNotNull("boutonVersMenu", boutonVersMenu);
        Ntro.assertNotNull("conteneurPages", conteneurPages);
        installerEvtAfficherMenu();
        installerMsgAjouterPage();
        installerMsgRetirerPages();
    }

    private void installerEvtAfficherMenu() { 
        EvtAfficherMenu evenementNtro = NtroApp.newEvent(EvtAfficherMenu.class); 
        boutonVersMenu.setOnAction(evenementFx -> { 
            evenementNtro.trigger();
        });
    }

    public void installerMsgAjouterPage() {
        MsgAjouterUnePage msgAjouterUnePage = NtroApp.newMessage(MsgAjouterUnePage.class);
        boutonAjouterPage.setOnAction(evenementsFx -> {
            msgAjouterUnePage.setPageCourante(MaquettePages.pageCourante());
            msgAjouterUnePage.send();
            MaquettePages.prochainePage();
        });
    }

    public void installerMsgRetirerPages() { 
        MsgRetirerPages msgRetirerPages = NtroApp.newMessage(MsgRetirerPages.class);
        boutonRetirerLesPages.setOnAction(evevenementFx -> { 
            msgRetirerPages.send();
        });
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