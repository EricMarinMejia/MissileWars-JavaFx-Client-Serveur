package missile_wars.commun.monde2d;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Joueur2d extends ObjetMissileWars2d {
	
	private int idJoueur;
	
//	private String nomJoueur;	NON IMPLÉMENTER ENCORE
	
	private double coordX;
	
	public Joueur2d() {
		super();
	}
	
	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}

	public double getCoordX() {
		return coordX;
	}

	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}

	public Joueur2d(int positionY) {
		super();
		setTopLeftY(positionY);
	}
	
	
	
	@Override
	public void initialize() {
		setWidth(10);
		setHeight(10);
		setTopLeftX(getWorld2d().getWidth()/2 - getWidth()/2);
	}
	
	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.save();
		
		gc.setFill(Color.BLACK);
		
		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
		
		gc.restore();
	}
	
	/*
	 * AJOUTER MÉHODES POUR BOUGER
	 */
	
	
	
	
}
