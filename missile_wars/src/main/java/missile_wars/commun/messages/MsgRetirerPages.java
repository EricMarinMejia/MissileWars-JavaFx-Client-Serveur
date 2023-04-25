package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import missile_wars.commun.modele.ModelePages;

public class MsgRetirerPages extends MessageNtro {
    
    public MsgRetirerPages() { 

    }

    public void retirerPages(ModelePages unModeleDidacticiel) { 
       unModeleDidacticiel.retirerLesPages();
    }

}