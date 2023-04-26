package missile_wars.frontal.controles;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import missile_wars.commun.monde2d.MondeMissileWars2d;

public class CanvasPartie extends ResizableWorld2dCanvasFx {
	@FXML
	private Image logo;
	
	@Override
	protected void initialize() {
		this.logo = new Image("/logo.png");
		this.setInitialWorldSize(MondeMissileWars2d.LARGEUR_MONDE, MondeMissileWars2d.HAUTEUR_MONDE);
	}

    private void dessinerLeMonde2d() {
    
	}
    
	public void afficherFps(String imagesParSeconde) {
		drawOnCanvas(gc -> {
			gc.fillText(imagesParSeconde, 0, 12);
		});	
	}
}