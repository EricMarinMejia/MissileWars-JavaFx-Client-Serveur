package missile_wars.commun.monde2d;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.app.fx.world2d.World2dFx;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import missile_wars.commun.enums.ActionsJoueurEnum;

public class MondeMissileWars2d extends World2dFx {
    public static final double LARGEUR_MONDE = 640;
    public static final double HAUTEUR_MONDE = 360; 

    private Missile2d unMissile;
    
    List<Plancher2d> listePlanchers;
    
    List<Equipe2d>  listeEquipes;
    
//    
//    List<Joueur2d> listeJoueursEquipe1;
//    List<Joueur2d> listeJoueursEquipe2;
//    
//    Joueur2d joueur1;
//    Joueur2d joueur2;
    
    //LISTE DE MISSILES2D
    

    @Override
    protected void initialize() {
//    	listeJoueursEquipe1 = new ArrayList<Joueur2d>();
//    	listeJoueursEquipe2 = new ArrayList<Joueur2d>();
//    	
//    	joueur1 = new Joueur2d((int) HAUTEUR_MONDE - 25);
//    	joueur2 = new Joueur2d(0);
//    	
//    	listeJoueursEquipe1.add(joueur1);
//    	listeJoueursEquipe2.add(joueur2);
    	
    	this.listePlanchers = new ArrayList<>();
    	listePlanchers.add(new Plancher2d((int) HAUTEUR_MONDE - 25));
    	listePlanchers.add(new Plancher2d(25));
    	
    	this.listeEquipes = new ArrayList<>();
    	listeEquipes.add(new Equipe2d());
    	listeEquipes.add(new Equipe2d());
    	
//    	listeEquipes.get(0).setListeJoueurs(listeJoueursEquipe1);
//    	listeEquipes.get(1).setListeJoueurs(listeJoueursEquipe2);
    	
    	
        setWidth(LARGEUR_MONDE);
        setHeight(HAUTEUR_MONDE);

        
        for (Plancher2d plancher2d : listePlanchers) {
        	plancher2d.initialiser(this);
        }
        
//        addObject2d(joueur1);
//        addObject2d(joueur2);
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

//        super.drawOn(canvas); // à retirer
    }

    private void dessinerTerrain(GraphicsContext gc) {
        gc.save();
        gc.setStroke(Color.LIGHTGREY);
        gc.setLineWidth(1);

        gc.strokeRect(0, 0, getWidth(), getHeight());

        gc.restore();
        
        
        // faire le dessin récursif ici 
        
        
        //ne pas oublier qu'il y a la même quantité d'équipe que de plancher
        for (int indexEquipe = 0; indexEquipe < this.listeEquipes.size(); indexEquipe++ ) {
        	Equipe2d equipe2d = this.listeEquipes.get(indexEquipe);
        	Plancher2d plancher2d = this.listePlanchers.get(indexEquipe);
        	
        	// on fait dessiner le plancher en premier
        	
        	plancher2d.dessinerSurLeMonde(gc);
        	
        	// on fait dessiner les équipes ensuite
        	equipe2d.dessinerSurLeMonde(gc, plancher2d);
        	
        }

    }

    @Override
    protected void onMouseEventNotConsumed(World2dMouseEventFx mouseEvent) {
    	
    }
    
	/*
	 * public void appliquerActionJoueur(ActionsJoueurEnum action) { //Joueur2d
	 * joueur = joueurDuCadran(cadran);
	 * 
	 * appliquerActionJoueur(action, cadran);
	 * 
	 * }
	 * 
	 * private void appliquerActionJoueur(Joueur2d joueur, Action action, Cadran
	 * cadran) { switch (action) { case HAUT: joueur.monter(); break;
	 * 
	 * case BAS: joueur.descendre(); break;
	 * 
	 * case DROITE: joueur.droite(); break;
	 * 
	 * case GAUCHE: joueur.gauche(); break;
	 * 
	 * case TIRER: joueur.tirer(cadran.name()); break;
	 * 
	 * case ARRET: default: joueur.arreter(); break; }
	 * 
	 * }
	 */
    
}