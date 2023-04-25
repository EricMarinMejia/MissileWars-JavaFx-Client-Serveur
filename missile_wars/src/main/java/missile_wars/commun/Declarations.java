package missile_wars.commun;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import missile_wars.commun.messages.MsgActualiserInscriptionJoueur;
import missile_wars.commun.messages.MsgActualiserInscriptionJoueurNom;
import missile_wars.commun.messages.MsgActualiserInscriptionJoueurTouche;
import missile_wars.commun.modeles.ModeleInscriptionJoueur;
import missile_wars.commun.monde2d.Missile2d;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.commun.valeurs.KeyStringRepresentation;

public class Declarations {

	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgActualiserInscriptionJoueur.class);
		registrar.registerMessage(MsgActualiserInscriptionJoueurTouche.class);
		registrar.registerMessage(MsgActualiserInscriptionJoueurNom.class);
	}

	public static void declarerModeles(ModelRegistrar registrar) {
			registrar.registerModel(ModeleInscriptionJoueur.class);
			
			registrar.registerValue(KeyStringRepresentation.class);
			registrar.registerValue(MondeMissileWars2d.class);
			registrar.registerValue(Missile2d.class);
	}
	
	
	
	public static void declarerServeur(ServerRegistrar registrar) {
		registrar.registerName("localhost");
		registrar.registerPort(8002);
	}

}


















