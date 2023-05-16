package missile_wars.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Plancher2d extends ObjetMissileWars2d{

	int positionY;
	
	private static final float DEBUT_X = 0.0f;
	
	private static final float FIN_X = 1.0f;
	
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
	}
	
	
	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.save();
		
		gc.setFill(Color.WHITE);
		
		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
		
		gc.restore();
	}
	
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
	
	
	
	
	
	
	
	
	
}
