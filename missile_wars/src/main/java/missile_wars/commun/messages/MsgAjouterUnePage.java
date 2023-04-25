package missile_wars.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import missile_wars.commun.modele.ModelePages;
import missile_wars.commun.valeurs.Page;

public class MsgAjouterUnePage extends MessageNtro {
    
    public MsgAjouterUnePage() {

    }

    private Page pageCourante;
    
    public void setPageCourante(Page pageCourante) {
        this.pageCourante = pageCourante;
    }

    public Page getPageCourante() {
        return pageCourante;
    }


    public void ajouterUnePage(ModelePages didacticiel) {
        didacticiel.ajouterPage(pageCourante);
    }

}
