package missile_wars.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MondePong2d extends World2dFx {

    public static final double LARGEUR_MONDE = 640;
    public static final double HAUTEUR_MONDE = 360;

    private Balle2d balle;

    @Override
    protected void initialize() {
        setWidth(LARGEUR_MONDE);
        setHeight(HAUTEUR_MONDE);
        balle = new Balle2d();
        addObject2d(balle);
        for(int i = 0; i < 1; i++) {
            addObject2d(new Balle2d());
        }
    }

    @Override
    public void drawOn(ResizableWorld2dCanvasFx canvas) {
        canvas.drawOnWorld(gc -> {
            dessinerTerrain(gc);
        });

        super.drawOn(canvas);
    }

    private void dessinerTerrain(GraphicsContext gc) {
        gc.save();
        gc.setStroke(Color.LIMEGREEN);
        gc.setLineWidth(1);
        gc.strokeRect(0, 0, getWidth(), getHeight());
        gc.restore();
    }

    @Override
    protected void onMouseEventNotConsumed(World2dMouseEventFx mouseEvent) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'onMouseEventNotConsumed'");
    }
}