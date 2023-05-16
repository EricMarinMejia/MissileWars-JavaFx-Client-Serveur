package missile_wars.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import javafx.scene.canvas.GraphicsContext;

public class Plancher extends ObjetMissileWars2d {

	int positionY;
	
	private static final float DEBUT_X = 0.0f;
	
	private static final float FIN_X = 1.0f;
	
	float[] tableauPlancher = new float[10];
	
	
	
	public Plancher() {
		super();
	}
	
	public Plancher(int positionY) {
		super();
		this.positionY = positionY;
	}
	
	@Override
	public void drawOnWorld(GraphicsContext gc) {
		gc.save();
		
		gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
		
		gc.restore();
	}
	
	
	
	
	
}
