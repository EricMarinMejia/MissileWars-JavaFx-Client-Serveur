
package missile_wars.commun.messages;

import java.util.Map;

import ca.ntro.app.messages.*;
import missile_wars.commun.modeles.ModeleInscriptionJoueur;
import missile_wars.commun.valeurs.*;

public class MsgActualiserInscriptionJoueur extends MessageNtro {

    private String nomJoueur = "";
    private Map<String, KeyStringRepresentation> touches = null;

    public String getNomJoueur() {
        return this.nomJoueur;
    }
    public void setNomJoueur(String value) {
        this.nomJoueur = value;
    }

    public Map<String, KeyStringRepresentation> getTouches() {
        return this.touches;
    }
    public void setTouches(Map<String, KeyStringRepresentation> value) {
        this.touches = value;
    }


    //public void appliqerA(ModeleInscriptionJoueur inscriptionJoueur) {  
    //}
    
}