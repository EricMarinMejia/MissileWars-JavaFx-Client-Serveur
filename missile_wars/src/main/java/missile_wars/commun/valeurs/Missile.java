package missile_wars.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Missile implements ModelValue{
	
	private static final double EPSILON = 1;
    private static final double VITESSE_MISSILE = 100;
    private double positionX = 0;
    private double positionY = 0;
    
    
    public double getPositionX() {
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
	public static double getEpsilon() {
		return EPSILON;
	}
	public static double getVitesseMissile() {
		return VITESSE_MISSILE;
	}
	
	
	
}
