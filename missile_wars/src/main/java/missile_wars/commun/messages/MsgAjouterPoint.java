package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import missile_wars.commun.modeles.ModelePartie;
import missile_wars.commun.monde2d.MondeMissileWars2d;

public class MsgAjouterPoint extends MessageNtro {
	
	private String cadran;
	private MondeMissileWars2d mondeMS2d;
	
	
	public void ajouterPointA(ModelePartie jeu) {
//		jeu.ajouterPointPour(Cadran.valueOf(cadran));
	}
	
	public void copierDonneesDans(ModelePartie jeu) {
		jeu.copierDonneesDe(mondeMS2d);
	}
		
	public String getCadran() {
		return cadran;
	}
	public void setCadran(String cadran) {
		this.cadran = cadran;
	}
	public MondeMissileWars2d getMondeMS2d() {
		return mondeMS2d;
	}
	public void setMondeMS2d(MondeMissileWars2d mondeMS2d) {
		this.mondeMS2d = mondeMS2d;
	}
	
}
