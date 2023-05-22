package missile_wars.commun.monde2d;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Joueur2d extends ObjetMissileWars2d {
	
	private int idJoueur;
	
//	private String nomJoueur;	NON IMPL�MENTER ENCORE
	
	private double coordX;
	
	public Point2D calculerPositionGraphiqueActuelle(Plancher2d plancher2d) {
		return new Point2D(
			plancher2d.getTopLeftX() + (this.coordX * plancher2d.getWidth()),
			plancher2d.getTopLeftY() + (plancher2d.getHeight() / 2d)
		);
	}
	
	
	public Joueur2d() {
		super();
		this.setTopLeftY(0d);
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
//		setWidth(10);
//		setHeight(10);
//		setTopLeftX(getWorld2d().getWidth()/2 - getWidth()/2);
	}
	

	public void dessinerSurLeMonde(GraphicsContext gc, Plancher2d plancher2d) {
		setWidth(10);
		setHeight(10);
		
		gc.save();
		
		
		
		
		
		gc.setFill(Color.RED);
		
		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
		
		
		gc.restore();
	}
	
//	@Override
//	public void drawOnWorld(GraphicsContext gc) {
//		gc.save();
//		
//		gc.setFill(Color.RED);
//		
//		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
//		
//		gc.restore();
//	}
	
	/*
	 * AJOUTER M�HODES POUR BOUGER
	 */
	
	
	
}
