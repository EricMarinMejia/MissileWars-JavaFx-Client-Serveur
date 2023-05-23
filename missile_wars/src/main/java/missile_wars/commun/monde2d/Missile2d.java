package missile_wars.commun.monde2d;

import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.core.initialization.Ntro;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Missile2d extends ObjetMissileWars2d {
    private static final double EPSILON = 1;
    private static final double VITESSE_MISSILE = 100;
    
    private double positionX = 0;
    private double positionY = 0;

    public double getPositionX() {
		return positionX;
	}
    
    public double getPositionX(double positionX) {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public Missile2d() {
        super();
    }
	
	public Missile2d(double positionX, double positionY) {
        super();
        setTopLeftX(positionX);
        setTopLeftY(positionY);
    }

    @Override
    public void initialize() {

    }

    public void dessinerSurLeMonde(GraphicsContext gc) {
		setWidth(10);
		setHeight(10);
		
		gc.save();
		gc.setFill(Color.RED);
		
		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());

		gc.restore();
	}
    

	/*
	 * @Override public void onTimePasses(double secondesPassees) {
	 * super.onTimePasses(secondesPassees); }
	 */
    
}