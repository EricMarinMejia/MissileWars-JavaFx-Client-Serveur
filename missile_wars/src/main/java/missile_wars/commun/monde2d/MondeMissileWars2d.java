package missile_wars.commun.monde2d;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MondeMissileWars2d extends World2dFx {
    public static final double LARGEUR_MONDE = 640;
    public static final double HAUTEUR_MONDE = 360; 

    private Missile2d unMissile;
    
    List<Plancher2d> listePlanchers;
    
    List<Equipe2d>  listeEquipes;
    
    //LISTE DE MISSILES2D
    

    @Override
    protected void initialize() {
    	this.listePlanchers = new ArrayList<>();
    	listePlanchers.add(new Plancher2d((int) HAUTEUR_MONDE - 25));
    	listePlanchers.add(new Plancher2d(25));
    	
    	this.listeEquipes = new ArrayList<>();
    	listeEquipes.add(new Equipe2d());
    	listeEquipes.add(new Equipe2d());
    	
    	
    	
    	
        setWidth(LARGEUR_MONDE);
        setHeight(HAUTEUR_MONDE);

        //unMissile = new Missile2d();


        //addObject2d(unMissile);
        
        for (Plancher2d plancher2d : listePlanchers) {
        	addObject2d(plancher2d);
        }
        
    }
    
    

    public Missile2d getUnMissile() {
		return unMissile;
	}



	public void setUnMissile(Missile2d unMissile) {
		this.unMissile = unMissile;
	}



	public List<Plancher2d> getListePlanchers() {
		return listePlanchers;
	}



	public void setListePlanchers(List<Plancher2d> listePlanchers) {
		this.listePlanchers = listePlanchers;
	}



	public List<Equipe2d> getListeEquipes() {
		return listeEquipes;
	}



	public void setListeEquipes(List<Equipe2d> listeEquipes) {
		this.listeEquipes = listeEquipes;
	}



	@Override
    public void drawOn(ResizableWorld2dCanvasFx canvas) {
        canvas.drawOnWorld(gc -> {
            dessinerTerrain(gc);
        });

        super.drawOn(canvas);
    }

    private void dessinerTerrain(GraphicsContext gc) {
        gc.save();
        gc.setStroke(Color.LIGHTGREY);
        gc.setLineWidth(1);

        gc.strokeRect(0, 0, getWidth(), getHeight());

        gc.restore();
    }

    @Override
    protected void onMouseEventNotConsumed(World2dMouseEventFx mouseEvent) {}
    
}