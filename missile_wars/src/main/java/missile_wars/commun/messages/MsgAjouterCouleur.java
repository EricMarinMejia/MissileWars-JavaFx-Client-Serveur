package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import missile_wars.commun.modeles.ModeleParametres;
import missile_wars.commun.valeurs.Couleur;

public class MsgAjouterCouleur extends MessageNtro {

    private Couleur couleurCourante;

    public MsgAjouterCouleur() {
    }

    public Couleur getCouleur() {
        return couleurCourante;
    }

    public void setCouleur(Couleur couleur) {
        this.couleurCourante = couleur;
    }
    public void ajouterCouleur(ModeleParametres unParametre) {
    	unParametre.ajouterCouleur(couleurCourante);
    }
}