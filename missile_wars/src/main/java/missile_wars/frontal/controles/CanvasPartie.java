package missile_wars.frontal.controles;

import java.util.List;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
			gc.setFill(Color.web("#ffffff"));
//			gc.fillRect(0, 0, 100, 100);
			gc.setFont(Font.font(30f));
			gc.fillText(imagesParSeconde, 0, 12);
		});	
	}
	
	public void afficherLignesDeTexte(List<String> lignes) {
		drawOnCanvas(gc -> {
			int height = 30;
			int currentY = height;
			
			gc.setFont(Font.font((float)height));
			gc.setFill(Color.web("#ffffff"));
			
			for (String line : lignes) {
				gc.fillText(line, 0, currentY);
				currentY += height;
			}
			
		});
	}
	
}