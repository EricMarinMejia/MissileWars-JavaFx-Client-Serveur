package missile_wars.frontal.vues;

import ca.ntro.app.views.ViewFx;
import javafx.scene.layout.Pane;

public class VueRacine extends ViewFx{

    @Override
    public void initialiser() {
        // C'est vide ...
    }

    public void afficherSousVue(ViewFx sousVue) {
        Pane racineSousVue = sousVue.rootNode(); 
        rootNode().getChildren().clear();
        rootNode().getChildren().add(racineSousVue);
    }    
}