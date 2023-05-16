package missile_wars.commun.monde2d;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.core.initialization.Ntro;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Missile2d extends ObjetMissileWars2d {
    private static final double EPSILON = 1;
    private static final double VITESSE_MISSILE = 100;

    public Missile2d() {
        super();
    }

    @Override
    public void initialize() {
        setWidth(10);
        setHeight(10);
        setTopLeftX(100);
        setTopLeftY(100);

        double vitesse = 50 + Ntro.random().nextInt(100);

        setSpeedX(vitesse);
        setSpeedY(vitesse);
    }

    @Override
    public void drawOnWorld(GraphicsContext gc) {
        Image image = new Image("/grass.png");
//        canvas.drawOnWorld(gc -> {
        gc.drawImage(image,getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
//        });
    }

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
        return false;
    }

    @Override
    public String id() {
        return "un missile";
    }

    public void monter() {
        setSpeedY(-VITESSE_MISSILE);
    }

    public void descendre() {
        setSpeedY(VITESSE_MISSILE);
    }

    public void gauche() { 
        setSpeedX(VITESSE_MISSILE);
    }

    public void droite() { 
        setSpeedY(-VITESSE_MISSILE);
    }

    public void arreter() {
        setSpeedY(0);
        setSpeedX(0);
    }


    @Override
    public void onTimePasses(double secondesPassees) {
        super.onTimePasses(secondesPassees);
    }
    
    

}