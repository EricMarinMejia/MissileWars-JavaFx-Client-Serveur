package missile_wars.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.frontal.controles.CanvasPartie;
import missile_wars.frontal.evenements.EvtAfficherAccueil;

public class VuePartie extends ViewFx {
	
	
	
	@FXML
	private Button boutonQuitterPartie;
	
	@FXML
	private CanvasPartie canvasPartie;

	@Override
	public void initialiser() {
		Ntro.assertNotNull(this.boutonQuitterPartie);
		
		this.installerBoutonQuitterPartie();
	}
    
    
    public void viderCanvas() {
        canvasPartie.clearCanvas();
    }

    public void afficherImagesParSeconde(String fps) {
        canvasPartie.afficherFps(fps);
    }

    public void afficherMissileWars2d(MondeMissileWars2d mondeMissileWars2d) {
    	mondeMissileWars2d.drawOn(canvasPartie);
    }

    
    
    private void installerBoutonQuitterPartie() {
		EvtAfficherAccueil evtAfficherAccueil = NtroApp.newEvent(EvtAfficherAccueil.class);
		
		this.boutonQuitterPartie.setOnAction(evtFx -> {
			evtAfficherAccueil.trigger();
		});
    	
    }
    
    
    
}











