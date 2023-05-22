package missile_wars.commun;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import missile_wars.commun.messages.MsgActualiserInscriptionJoueur;
import missile_wars.commun.messages.MsgActualiserInscriptionJoueurNom;
import missile_wars.commun.messages.MsgActualiserInscriptionJoueurTouche;
import missile_wars.commun.messages.MsgAjouterCouleur;
import missile_wars.commun.messages.MsgAjouterPoint;
import missile_wars.commun.messages.MsgAjouterReferenceJoueurAPartie;
import missile_wars.commun.messages.MsgDemandeNouveauJoueur;
import missile_wars.commun.messages.MsgJoueurExiste;
import missile_wars.commun.messages.MsgModifierNomJoueur;
import missile_wars.commun.messages.MsgModifierPositionJoueur;
import missile_wars.commun.messages.MsgNouveauIdJoueurBroadcast;
import missile_wars.commun.messages.MsgNouveauIdPartieBroadcast;
import missile_wars.commun.messages.MsgNouvellePartie;
import missile_wars.commun.messages.MsgRetirerPartie;
import missile_wars.commun.modeles.ModeleFileAttente;
import missile_wars.commun.modeles.ModeleHistorique;
import missile_wars.commun.modeles.ModeleInscriptionJoueur;
import missile_wars.commun.modeles.ModeleListeJoueurs;
import missile_wars.commun.modeles.ModeleParametres;
import missile_wars.commun.modeles.ModelePartie;
import missile_wars.commun.monde2d.Equipe2d;
import missile_wars.commun.monde2d.Joueur2d;
import missile_wars.commun.monde2d.Missile2d;
import missile_wars.commun.monde2d.MondeMissileWars2d;
import missile_wars.commun.monde2d.Plancher2d;
import missile_wars.commun.valeurs.Couleur;
import missile_wars.commun.valeurs.Equipe;
import missile_wars.commun.valeurs.Joueur;
import missile_wars.commun.valeurs.KeyStringRepresentation;
import missile_wars.commun.valeurs.Plancher;
import missile_wars.commun.valeurs.ReferenceJoueur;
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
		registrar.registerMessage(MsgDemandeNouveauJoueur.class);
		registrar.registerMessage(MsgNouveauIdJoueurBroadcast.class);
		registrar.registerMessage(MsgNouveauIdPartieBroadcast.class);
		registrar.registerMessage(MsgJoueurExiste.class);
		registrar.registerMessage(MsgModifierNomJoueur.class);
		registrar.registerMessage(MsgAjouterReferenceJoueurAPartie.class);
		registrar.registerMessage(MsgModifierPositionJoueur.class);
	}

	public static void declarerModeles(ModelRegistrar registrar) {
		registrar.registerModel(ModeleHistorique.class);
//		registrar.registerValue(Partie.class);
		registrar.registerValue(ModelePartie.class);
		registrar.registerValue(MondeMissileWars2d.class);
		registrar.registerValue(Missile2d.class);
		registrar.registerValue(Plancher2d.class);
		registrar.registerValue(Plancher.class);
		registrar.registerModel(ModeleInscriptionJoueur.class);
		registrar.registerValue(Equipe2d.class);
		registrar.registerModel(ModeleParametres.class);
		registrar.registerModel(ModeleListeJoueurs.class);
		registrar.registerValue(Joueur.class);
		registrar.registerValue(Equipe.class);
		registrar.registerValue(ReferenceJoueur.class);
		registrar.registerValue(Joueur2d.class);
		registrar.registerModel(ModeleFileAttente.class);
		registrar.registerValue(ReferencePartie.class);
		
		registrar.registerValue(KeyStringRepresentation.class);
		registrar.registerValue(Couleur.class);
	}

	public static void declarerServeur(ServerRegistrar registrar) {
		registrar.registerName("localhost");
		registrar.registerPort(8004); // 8002
	}

}