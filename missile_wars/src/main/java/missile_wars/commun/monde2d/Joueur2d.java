package missile_wars.commun.monde2d;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Joueur2d extends ObjetMissileWars2d {
	
	private int idJoueur;
	
//	private String nomJoueur;	NON IMPL�MENTER ENCORE
	
	private double position;
	
	public Point2D calculerPositionGraphiqueActuelle(Plancher2d plancher2d) {
		return new Point2D(
			plancher2d.getTopLeftX() + (this.position * plancher2d.getWidth()),
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

	public double getPosition() {
		return position;
	}

	public void setPosition(double position) {
		this.position = position;
	}

	public Joueur2d(int positionY) {
		super();
		setTopLeftY(positionY);
	}
	
	
	@Override
	public void initialize() {

	}
	

	public void dessinerSurLeMonde(GraphicsContext gc, Plancher2d plancher2d) {
		setWidth(10);
		setHeight(10);
		
		gc.save();
		
		Point2D posGraphique = this.calculerPositionGraphiqueActuelle(plancher2d);	
		
		gc.setFill(Color.GREEN);
		
		gc.fillRect(posGraphique.getX() - (getWidth() / 2d), plancher2d.getTopLeftY(), getWidth(), plancher2d.getHeight());

		gc.restore();
	}
	

	
	
	
}
