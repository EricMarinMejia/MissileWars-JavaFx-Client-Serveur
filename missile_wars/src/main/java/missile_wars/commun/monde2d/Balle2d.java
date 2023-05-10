package missile_wars.commun.monde2d;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.core.initialization.Ntro;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class Balle2d extends ObjetPong2d {
    
    private static final double EPSILON = 1;
    private AudioClip sonPoc = new AudioClip(Balle2d.class.getResource("/poc.wav").toString());

    public Balle2d() {
        super();
    }
    private void jouerSonPoc() {
	    sonPoc.play();
	}

    @Override
    public void initialize() {
        setWidth(30);
        setHeight(30);
        setTopLeftX(100);
        setTopLeftY(100);
        setSpeedX(100 + Ntro.random().nextInt(100));
        setSpeedY(100 + Ntro.random().nextInt(100));
    }

    @Override
    public void drawOnWorld(GraphicsContext gc) {

            gc.setFill(Color.LIMEGREEN);
            gc.fillArc(getTopLeftX(),
                    getTopLeftY(),
                    getWidth(),
                    getHeight(),
                    0,
                    360,
                    ArcType.CHORD);
    }

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
        return false;
    }

    @Override
    public String id() {
        return "balle";
    }

    @Override
    public void onTimePasses(double secondsElapsed) {
        super.onTimePasses(secondsElapsed);

        if (balleFrappeMurGauche()) {

            balleRebondiSurMurGauche();

        } else if (balleFrappeMurDroit()) {

            balleRebondiSurMurDroit();

        } else if (balleFrappePlafond()) {

            balleRebondiSurPlafond();

        } else if (balleFrappePlancher()) {

            balleRebondiSurPlancher();
        }
    }

    private boolean balleFrappePlancher() {
        jouerSonPoc();
        return collidesWith(0,
                getWorld2d().getHeight(),
                getWorld2d().getWidth(),
                1);
    }

    private boolean balleFrappePlafond() {
        jouerSonPoc();
        return collidesWith(0,
                0,
                getWorld2d().getWidth(),
                1);
    }

    private boolean balleFrappeMurDroit() {
        jouerSonPoc();
        return collidesWith(getWorld2d().getWidth(),
                0,
                1,
                getWorld2d().getHeight());
    }

    private boolean balleFrappeMurGauche() {
        jouerSonPoc();
        return collidesWith(0,
                0,
                1,
                getWorld2d().getHeight());
    }

    private void balleRebondiSurPlancher() {
        setTopLeftY(getWorld2d().getHeight() - this.getHeight() - EPSILON);
        setSpeedY(-getSpeedY());
    }

    private void balleRebondiSurPlafond() {
        setTopLeftY(0 + EPSILON);
        setSpeedY(-getSpeedY());
    }

    private void balleRebondiSurMurDroit() {
        setTopLeftX(getWorld2d().getWidth() - this.getWidth() - EPSILON);
        setSpeedX(-getSpeedX());
    }

    private void balleRebondiSurMurGauche() {
        setTopLeftX(0 + EPSILON);
        setSpeedX(-getSpeedX());
    }

}