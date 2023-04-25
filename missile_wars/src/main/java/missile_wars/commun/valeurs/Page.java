package missile_wars.commun.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.ModelValue;
import missile_wars.frontal.vues.fragments.FragmentPage;

public class Page implements ModelValue {
    
    public Page() {

    }
    
    public Page(String nomVue, boolean estComplete, String touche) {
        this.nomVue = nomVue;
        this.estComplete = estComplete;
        this.touche = touche;
    }
    
    private String nomVue = "";
    private boolean estComplete;
    private String touche;

    public String getNomVue() {
        return nomVue;
    }
    
    public void setNomVue(String nomVue) {
        this.nomVue = nomVue;
    }
    
    public boolean isEstComplete() {
        return estComplete;
    }
    
    public void setEstComplete(boolean estComplete) {
        this.estComplete = estComplete;
    }
    
    public String getTouches() {
        return touche;
    }
    
    public void setTouches(String touche) {
        this.touche = touche;
    } 

    public FragmentPage creerFragment(ViewLoader<FragmentPage> viewLoader) { 
        return viewLoader.createView();
    }

    public void afficherSur(FragmentPage fragment) { 
        fragment.afficherNomPage(nomVue);
    }

    @Override
    public String toString() { 
        return nomVue;
    }
 
}