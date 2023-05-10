package missile_wars.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.Object2dFx;
import javafx.scene.canvas.GraphicsContext;

public class ObjetMissileWars2d extends Object2dFx<MondeMissileWars2d>{
//    @Override
//    public void drawOn(ResizableWorld2dCanvasFx canvas) {}

    @Override
    public String id() {
        return "";
    }

    @Override
    public void initialize() {}

    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
        return false;
    }

	@Override
	public void drawOnWorld(GraphicsContext gc) {
		// TODO Auto-generated method stub
		
	}    
}