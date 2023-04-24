package missile_wars.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;

public class Joueur2d extends ObjetMissileWars2d {

	private static final double VITESSE_JOUEUR = 100;
	
	public Joueur2d() {
		super();
	}
	
	public Joueur2d(double topLeftY) {
		super();
		setTopLeftY(topLeftY);
	}
	
	@Override
	public void drawOn(ResizableWorld2dCanvasFx canvas) {
		canvas.drawOnWorld(gc ->  {
			gc.save();
			
			gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
			
			gc.restore();
		});
		
	}

	@Override
	public String id() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initialize() {
		setWidth(10);
		setHeight(10);
		
		setTopLeftX(getWorld2d().getWidth()/2 - getWidth()/2);
		
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		return false;
	}
	
	public void monter() {
		setSpeedY(-VITESSE_JOUEUR);
	}
	
	public void descendre() {
		setSpeedY(+VITESSE_JOUEUR);
	}
	
	public void droite() {
		setSpeedX(+VITESSE_JOUEUR);
	}
	
	public void gauche() {
		setSpeedX(-VITESSE_JOUEUR);
	}
	
	public void arreter() {
		setSpeedY(0);
		setSpeedX(0);
	}
	
	public void tirer(String cadran) {
		this.getWorld2d().lancerMissile(this, cadran);
	}

}
