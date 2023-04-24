package missile_wars.commun.monde2d;

import ca.ntro.app.NtroApp;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.World2dFx;
import ca.ntro.core.initialization.Ntro;
import missile_wars.commun.enums.Cadran;
import missile_wars.commun.messages.MsgAjouterPoint;

public class Missile2d extends ObjetMissileWars2d {

	private Joueur2d joueurBas;
	private Joueur2d joueurHaut;

	public Missile2d() {
		super();
	}

	public Missile2d(Joueur2d joueurBas, Joueur2d joueurHaut) {
		super();

		setJoueurBas(joueurBas);
		setJoueurHaut(joueurHaut);
		choisirEtatInitial();
	}

	public Missile2d(Joueur2d joueur, String cadran) {
		super();

		missileLancer(joueur, cadran);
	}

	private void missileLancer(Joueur2d joueur, String cadran) {
		if (cadran.equals("GAUCHE")) {
			setTopLeftX(joueur.getTopLeftX());
			setTopLeftY(joueur.getTopLeftY());
			setSpeedY(-50);
		} else {
			setTopLeftX(joueur.getTopLeftX());
			setTopLeftY(joueur.getTopLeftY());
			setSpeedY(+50);
		}
	}

	@Override
	public void initialize() {
		setWidth(10);
		setHeight(15);
	}

	private void choisirEtatInitial() {
		//Mets le missile hors de porté
		setTopLeftX(1000);
		setTopLeftY(1000);
	}

	@Override
	public void drawOn(ResizableWorld2dCanvasFx canvas) {

		canvas.drawOnWorld(gc -> {

			gc.fillRect(getTopLeftX(), getTopLeftY(), getWidth(), getHeight());

		});

	}

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);

		if (missileToucheMurAdversaire()) {
			// A retirer plus tard.
			// Relance un missile automatiquement pour des raisons de test.
			// Ajouter plus tard un else if (missileToucheBase(); pour finir partie.
			// Ajouter if else (missileRecu)
			choisirEtatInitial();
			ajouterPoint(Cadran.GAUCHE);

		}
		if (missileToucheBaseAlliee()) {
			choisirEtatInitial();
			ajouterPoint(Cadran.DROITE);
		}
	}

	private boolean missileToucheBaseAlliee() {
		return collidesWith(0, getWorld2d().getHeight() - 1, getWorld2d().getWidth(), 1);
	}

	private void ajouterPoint(Cadran cadran) {
		MsgAjouterPoint msgAjouterPoint = NtroApp.newMessage(MsgAjouterPoint.class);
		msgAjouterPoint.setMondeMS2d(getWorld2d());
		msgAjouterPoint.setCadran(cadran.name());
		msgAjouterPoint.send();
	}

	private boolean missileToucheMurAdversaire() {
		return collidesWith(0, 0, getWorld2d().getWidth(), 1);
	}

	@Override
	public String id() {
		return "missile";
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		return false;
	}

	public Joueur2d getJoueurBas() {
		return joueurBas;
	}

	public void setJoueurBas(Joueur2d joueurBas) {
		this.joueurBas = joueurBas;
	}

	public Joueur2d getJoueurHaut() {
		return joueurHaut;
	}

	public void setJoueurHaut(Joueur2d joueurHaut) {
		this.joueurHaut = joueurHaut;
	}

}
