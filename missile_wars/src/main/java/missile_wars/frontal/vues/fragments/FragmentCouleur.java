package missile_wars.frontal.vues.fragments;


import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFragmentFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import missile_wars.frontal.evenements.EvtAfficherMenu;

public class FragmentCouleur extends ViewFragmentFx {

    @FXML
    private Button boutonJoindrePartie;

    @FXML
    private Label labelNomCouleur;

    @Override
    public void initialiser() {
        Ntro.assertNotNull("boutonJoindrePartie", boutonJoindrePartie);
        Ntro.assertNotNull("labelNomCouleur", labelNomCouleur);
        installerEvtAfficherMenu();
    }

    private void installerEvtAfficherMenu() {
        EvtAfficherMenu evtNtro = NtroApp.newEvent(EvtAfficherMenu.class);
        boutonJoindrePartie.setOnAction(evtFx -> {
            evtNtro.trigger();
        });
    }

    public void afficherCouleur(String couleur) {
        labelNomCouleur.setText(couleur);
    }
}