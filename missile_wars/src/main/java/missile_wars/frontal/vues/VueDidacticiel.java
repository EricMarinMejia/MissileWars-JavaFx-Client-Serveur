package missile_wars.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.frontal.evenements.EvtAfficherMenu;

public class VueDidacticiel extends ViewFx {
    @FXML
    private Button boutonVersMenu;

    @Override
    public void initialiser() {
        Ntro.assertNotNull("boutonVersMenu", boutonVersMenu);
        installerEvtAfficherVueMenu();
    }

    public void installerEvtAfficherVueMenu() {
        EvtAfficherMenu evenementNtro = NtroApp.newEvent(EvtAfficherMenu.class);
        boutonVersMenu.setOnAction(evenementFx -> {
            evenementNtro.trigger();
        });
    }

    public void viderCanvas() {
    }

    public void afficherImagesParSeconde(String string) {
    }

    public void afficherPong2d(MondeMissileWars2d mondeMissileWars2d) {
    }
}