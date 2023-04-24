package missile_wars.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import missile_wars.commun.enums.Action;
import missile_wars.commun.enums.Cadran;

public class MondeMissileWars2d extends World2dFx {
	public static final double LARGEUR_MONDE = 640;
	public static final double HAUTEUR_MONDE = 360;

	private Joueur2d joueurBas;
	private Joueur2d joueurHaut;
	private Missile2d missile;

	@Override
	protected void initialize() {
		setWidth(LARGEUR_MONDE);
		setHeight(HAUTEUR_MONDE);

		joueurBas = new Joueur2d(HAUTEUR_MONDE - 100);
		joueurHaut = new Joueur2d(100);
		missile = new Missile2d(joueurBas, joueurHaut);

		addObject2d(joueurBas);
		addObject2d(joueurHaut);
		addObject2d(missile);

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
	protected void onMouseEventNotConsumed(World2dMouseEventFx mouseEvent) {
		// TODO Auto-generated method stub

	}

	public void appliquerActionJoueur(Cadran cadran, Action action) {
		Joueur2d joueur = joueurDuCadran(cadran);

		appliquerActionJoueur(joueur, action, cadran);

	}

	private void appliquerActionJoueur(Joueur2d joueur, Action action, Cadran cadran) {
		switch (action) {
			case HAUT:
				joueur.monter();
				break;

			case BAS:
				joueur.descendre();
				break;

			case DROITE:
				joueur.droite();
				break;
				
			case GAUCHE:
				joueur.gauche();
				break;
				
			case TIRER:
				joueur.tirer(cadran.name());
				break;

			case ARRET:
			default:
				joueur.arreter();
				break;
		}

	}

	private Joueur2d joueurDuCadran(Cadran cadran) {
		Joueur2d joueur;

		switch (cadran) {
		case GAUCHE:
		default:
			joueur = joueurBas;
			break;

		case DROITE:
			joueur = joueurHaut;
			break;
		}

		return joueur;
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
	
	
	public void lancerMissile(Joueur2d joueur, String cadran) {
		Missile2d nouveauMissile = new Missile2d(joueur, cadran);
		addObject2d(nouveauMissile);
	}
}
