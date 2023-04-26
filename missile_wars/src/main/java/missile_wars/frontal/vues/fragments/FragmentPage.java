package missile_wars.frontal.vues.fragments;

import ca.ntro.app.fx.controls.ResizableAvatar;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class FragmentPage extends ViewFx{

    @FXML
    private ResizableAvatar logo;
    @FXML
    private Label labelPage;

    @Override
    public void initialiser() {
        Ntro.assertNotNull("logo", logo);
        Ntro.assertNotNull("labelPage", labelPage);
        logo.setImage(new Image("/content/feuille.png"));    
    }

    public void afficherNomPage(String nomPage) { 
        labelPage.setText(nomPage);
    }
}
