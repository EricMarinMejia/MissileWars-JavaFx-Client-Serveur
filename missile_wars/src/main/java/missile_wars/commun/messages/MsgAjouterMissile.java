package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;

public class MsgAjouterMissile  extends MessageNtro {
	double positionX;
	double positionY;
	double vitesseY;
	
	
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
	public double getVitesseY() {
		return vitesseY;
	}
	public void setVitesseY(double vitesseY) {
		this.vitesseY = vitesseY;
	}
}
