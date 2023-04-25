package missile_wars.frontal.evenements;

import ca.ntro.app.frontend.events.EventNtro;
import missile_wars.frontal.donnees.DonneesVueDidacticiel;

public class EvtActionJoueur extends EventNtro {
    String touche;
    
    public void setAction(String touche) {
        this.touche = touche;
    }

    public String getTouche() { 
        return touche;
    }
    //TODO: a revoir : 
    public void appliquerA(DonneesVueDidacticiel donneesVueDidacticiel) {
            
        
    }
}