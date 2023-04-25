package missile_wars.frontal.controles;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import missile_wars.commun.monde2d.MondeMissileWars2d;

public class CanevasDidacticiel extends ResizableWorld2dCanvasFx{
    private Image logo;
    @Override
    protected void initialize() {
        logo = new Image("/grass.png");
        dessinerLeMonde2d();
        setInitialWorldSize(MondeMissileWars2d.LARGEUR_MONDE, MondeMissileWars2d.HAUTEUR_MONDE);
    }

    private void dessinerLeMonde2d() {
        drawOnWorld(pinceau -> {
            pinceau.setFill(Color.AQUA);
            pinceau.fillRect(0,0,getWorldWidth(),getWorldHeight());
            pinceau.setFill(Color.DARKGREY);
            pinceau.fillArc(getWorldWidth() / 2 - 100, getWorldHeight() / 2 - 100, 200, 200,
                    0,
                    360,
                    ArcType.CHORD);
            pinceau.drawImage(logo, getWorldWidth() / 2 - logo.getWidth() / 2, getWorldHeight() / 2 - logo.getHeight() / 2);

        });
    }

    public void afficherFps(String fps) {
        drawOnCanvas(gc -> {
            gc.fillText(fps, 0, 12);
        });
    }   
}