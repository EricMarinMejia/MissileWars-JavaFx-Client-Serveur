package missile_wars.commun.monde2d;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Plancher2d extends ObjetMissileWars2d{

	int positionY;
	
	private static final double DEBUT_X = 0.0;
	
	private static final double FIN_X = 1.0;
	
	List<Float> tableauPlancher;
	
	private static final int NB_DIVISION_PLANCHER = 10;
	
	public Plancher2d() {
		super();
	}
	
	public Plancher2d(int positionY) {
		this();
		setTopLeftY(positionY);
	}
	
	
	public void initialiser(MondeMissileWars2d mondeMissileWars2d) {
		this.tableauPlancher = new ArrayList<Float>();
		
		setWidth(MondeMissileWars2d.LARGEUR_MONDE);
		setHeight(10);
		
		setTopLeftX(mondeMissileWars2d.getWidth()/2 - getWidth()/2);
		
		for (int i = 0; i < NB_DIVISION_PLANCHER; i++) {
			tableauPlancher.add(10f);
		}
	}
	

	public void dessinerSurLeMonde(GraphicsContext gc) {
		gc.save();

		gc.setFill(Color.WHITE);
		
		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
		
		
		gc.restore();
	}
	
//	
//	@Override
//	public void drawOnWorld(GraphicsContext gc) {
//		gc.save();
//		
//		gc.setFill(Color.WHITE);
//		
//		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
//		
//		gc.restore();
//	}
	
	/**
	 * M�thode pour retirer de la vie � la case correspondante � cette coordonn�e virtuelle X
	 * 
	 * @param coordX coordon�e X virtuelle touch�e par un missile
	 */
	private void damageAt(double coordX) {
		
		//TODO
		/*
		 * 1. Interpolation lin�aire pour trouver case tableau correspondante (math sec 2) (y2 - y1) / (x2 - x1) 
		 * 2. 
		 * 
		 */
	}
	
	public List<Float> getTableauPlancher() {
		return tableauPlancher;
	}

	public void setTableauPlancher(List<Float> tableauPlancher) {
		this.tableauPlancher = tableauPlancher;
	}
		
	
	
	
	
	
	
	
	
	
}
