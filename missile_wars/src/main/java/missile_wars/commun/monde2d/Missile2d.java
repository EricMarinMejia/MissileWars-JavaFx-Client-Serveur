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
        return collidesWith(0,
                getWorld2d().getHeight(),
                getWorld2d().getWidth(),
                1);
    }

    private boolean balleFrappePlafond() {
        return collidesWith(0,
                0,
                getWorld2d().getWidth(),
                1);
    }

    private boolean balleFrappeMurDroit() {
        return collidesWith(getWorld2d().getWidth(),
                0,
                1,
                getWorld2d().getHeight());
    }

    private boolean balleFrappeMurGauche() {
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