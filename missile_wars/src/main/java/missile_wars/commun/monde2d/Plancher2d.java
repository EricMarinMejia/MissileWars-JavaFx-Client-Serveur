package missile_wars.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Plancher2d extends ObjetMissileWars2d{

	int positionY;
	
	private static final double DEBUT_X = 0.0;
	
	private static final double FIN_X = 1.0;
	
	float[] tableauPlancher = new float[10];
	
	public Plancher2d() {
		super();
	}
	
	public Plancher2d(int positionY) {
		super();
		setTopLeftY(positionY);
	}
	
	@Override
	public void initialize() {
		setWidth(MondeMissileWars2d.LARGEUR_MONDE);
		setHeight(10);
		
		setTopLeftX(getWorld2d().getWidth()/2 - getWidth()/2);
		
		for (int i = 0; i < tableauPlancher.length; i++) {
			tableauPlancher[i] = 10;
		}
	}
	
	
	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.save();
		
		gc.setFill(Color.WHITE);
		
		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
		
		gc.restore();
	}
	
	/**
	 * Méthode pour retirer de la vie à la case correspondante à cette coordonnée virtuelle X
	 * 
	 * @param coordX coordonée X virtuelle touchée par un missile
	 */
	private void damageAt(double coordX) {
		
		//TODO
		/*
		 * 1. Interpolation linéaire pour trouver case tableau correspondante (math sec 2) (y2 - y1) / (x2 - x1) 
		 * 2. 
		 * 
		 */
	}
	
	public float[] getTableauPlancher() {
		return tableauPlancher;
	}

	public void setTableauPlancher(float[] tableauPlancher) {
		this.tableauPlancher = tableauPlancher;
	}
		
	
	
	
	
	
	
	
	
	
}
