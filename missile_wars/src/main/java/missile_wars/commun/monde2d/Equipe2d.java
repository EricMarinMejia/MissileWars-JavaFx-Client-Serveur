package missile_wars.commun.monde2d;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Equipe2d extends ObjetMissileWars2d {

	private List<Joueur2d> listeJoueurs = new ArrayList<>();
	

	public List<Joueur2d> getListeJoueurs() {
		return listeJoueurs;
	}

	public void setListeJoueurs(List<Joueur2d> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}
	
	@Override
	public void initialize() {
	}
	
	
	public void dessinerSurLeMonde(GraphicsContext gc, Plancher2d plancher2d) {
		gc.save();
		
		for (Joueur2d joueur2d : this.listeJoueurs) {
			joueur2d.dessinerSurLeMonde(gc, plancher2d);
			
		}
		
		
		gc.restore();
	}
	
//	@Override
//	public void drawOnWorld(GraphicsContext gc) {
//		gc.save();
//		
//		gc.setFill(Color.RED);
//		
//		
//		
//		gc.restore();
//	}
	
	
}
