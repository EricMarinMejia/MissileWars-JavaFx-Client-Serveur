package missile_wars.frontal.vues.fragments;

import ca.ntro.app.NtroApp;
import ca.ntro.app.fx.controls.ResizableAvatar;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import missile_wars.commun.messages.MsgAjouterReferenceJoueurAPartie;
import missile_wars.frontal.evenements.EvtAfficherPartie;

public class FragmentReferencePartieRejoindre extends ViewFx {
	
	private String idPartie = "";
	private int idJoueur = -1;

    @FXML
    private ResizableAvatar logo;
    @FXML
    private Label labelIdPartie;
    @FXML
    private Button boutonRejoindrePartie;

    @Override
    public void initialiser() {
//        Ntro.assertNotNull("logo", logo);
        Ntro.assertNotNull("labelIdPartie", labelIdPartie);
        Ntro.assertNotNull("boutonRejoindrePartie", boutonRejoindrePartie);
//        logo.setImage(new Image("/content/feuille.png"));
    }
    
    public void memoriserIdPartie(String idPartie) {
    	this.idPartie = idPartie;
    	this.afficherIdPartie();
    }
    public void memoriserIdJoueur(int idJoueur) {
    	this.idJoueur = idJoueur;
    }

    private void afficherIdPartie() { 
    	labelIdPartie.setText(this.idPartie);
    	this.installerEvtRejoindrePartie();
    }

    private void installerEvtRejoindrePartie() {
    	EvtAfficherPartie evtAfficherPartie = NtroApp.newEvent(EvtAfficherPartie.class);
    	MsgAjouterReferenceJoueurAPartie msgAjouterReferenceJoueurAPartie = NtroApp.newMessage(MsgAjouterReferenceJoueurAPartie.class, this.idPartie);
    	this.boutonRejoindrePartie.setOnAction(evtFx -> {
    		evtAfficherPartie.setIdPartie(this.idPartie);
    		evtAfficherPartie.trigger();
    		
    		msgAjouterReferenceJoueurAPartie.setIdPartie(this.idPartie);
    		msgAjouterReferenceJoueurAPartie.setIdJoueur(this.idJoueur);
    		msgAjouterReferenceJoueurAPartie.setChannelId(this.idPartie);
//    		System.out.println("SENDING at " + this.idPartie + " with idJoueur : " + String.valueOf(this.idJoueur));
    		msgAjouterReferenceJoueurAPartie.send();
    	});
    }
    
    
}
