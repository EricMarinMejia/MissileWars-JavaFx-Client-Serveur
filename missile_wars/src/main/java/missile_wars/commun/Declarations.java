package missile_wars.commun;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import missile_wars.commun.messages.MsgActualiserInscriptionJoueur;
import missile_wars.commun.messages.MsgActualiserInscriptionJoueurNom;
import missile_wars.commun.messages.MsgActualiserInscriptionJoueurTouche;
import missile_wars.commun.messages.MsgAjouterCouleur;
import missile_wars.commun.messages.MsgAjouterPoint;
import missile_wars.commun.messages.MsgNouvellePartie;
import missile_wars.commun.messages.MsgRetirerPartie;
import missile_wars.commun.modeles.ModeleFileAttente;
import missile_wars.commun.modeles.ModeleHistorique;
import missile_wars.commun.modeles.ModeleInscriptionJoueur;
import missile_wars.commun.modeles.ModeleParametres;
import missile_wars.commun.modeles.ModelePartie;
import missile_wars.commun.monde2d.Missile2d;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.commun.valeurs.Couleur;
import missile_wars.commun.valeurs.KeyStringRepresentation;
import missile_wars.commun.valeurs.ReferencePartie;

public class Declarations {

	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgRetirerPartie.class);
		registrar.registerMessage(MsgAjouterPoint.class);
		registrar.registerMessage(MsgAjouterCouleur.class);
		registrar.registerMessage(MsgActualiserInscriptionJoueur.class);
		registrar.registerMessage(MsgActualiserInscriptionJoueurTouche.class);
		registrar.registerMessage(MsgActualiserInscriptionJoueurNom.class);
		registrar.registerMessage(MsgNouvellePartie.class);
	}

	public static void declarerModeles(ModelRegistrar registrar) {
		registrar.registerModel(ModeleHistorique.class);
//		registrar.registerValue(Partie.class);
		registrar.registerValue(ModelePartie.class);
		registrar.registerValue(MondeMissileWars2d.class);
		registrar.registerValue(Missile2d.class);
		registrar.registerModel(ModeleInscriptionJoueur.class);
		registrar.registerModel(ModeleParametres.class);
		
		registrar.registerModel(ModeleFileAttente.class);
		registrar.registerValue(ReferencePartie.class);
		
		registrar.registerValue(KeyStringRepresentation.class);
		registrar.registerValue(Couleur.class);
	}

	public static void declarerServeur(ServerRegistrar registrar) {
		registrar.registerName("localhost");
		registrar.registerPort(8002);
	}

}