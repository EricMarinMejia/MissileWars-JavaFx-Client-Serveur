package missile_wars.commun;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import missile_wars.commun.messages.MsgAjouterPoint;
import missile_wars.commun.messages.MsgRetirerPartie;
import missile_wars.commun.modeles.ModeleHistorique;
import missile_wars.commun.modeles.ModelePartie;
import missile_wars.commun.monde2d.Joueur2d;
import missile_wars.commun.monde2d.Missile2d;
import missile_wars.commun.monde2d.MondeMissileWars2d;

public class Declarations {

	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgRetirerPartie.class);
		registrar.registerMessage(MsgAjouterPoint.class);
	}

	public static void declarerModeles(ModelRegistrar registrar) {
		registrar.registerModel(ModeleHistorique.class);
//		registrar.registerValue(Partie.class);
		registrar.registerModel(ModelePartie.class);
		registrar.registerValue(MondeMissileWars2d.class);
		registrar.registerValue(Missile2d.class);
		registrar.registerValue(Joueur2d.class);
	}

	public static void declarerServeur(ServerRegistrar registrar) {
		registrar.registerName("localhost");
		registrar.registerPort(8002);
	}

}