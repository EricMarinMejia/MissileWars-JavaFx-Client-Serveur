package missile_wars.frontal.controles;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import missile_wars.commun.monde2d.MondeMissileWars2d;

public class CanvasPartie extends ResizableWorld2dCanvasFx{

	@Override
	protected void initialize() {
		setInitialWorldSize(MondeMissileWars2d.LARGEUR_MONDE, MondeMissileWars2d.HAUTEUR_MONDE);
		
	}
	
	public void afficherFps(String imagesParSecondes) {
		drawOnCanvas(gc -> {
			gc.fillText(imagesParSecondes, 0, 12);
		});
	}
		
}
