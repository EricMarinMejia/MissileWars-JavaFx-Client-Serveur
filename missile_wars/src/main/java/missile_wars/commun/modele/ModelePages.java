package missile_wars.commun.modele;

import java.util.LinkedList;
import java.util.List;
import ca.ntro.app.models.Model;
import ca.ntro.app.models.WriteObjectGraph;
import missile_wars.commun.valeurs.Page;
import missile_wars.frontal.vues.VueFileAttente;

public class ModelePages implements Model, WriteObjectGraph {
    private List<Page> listesPage = new LinkedList<>();
    
    public List<Page> getListesPage() {
        return listesPage;
    }
    
    public void setListesPage(List<Page> listesPage) {
        this.listesPage = listesPage;
    } 
    
    
    @Override
    public String toString() {
        StringBuilder constructeur = new StringBuilder();
        int numeroPage = 1;
        for (Page page : listesPage) {
            constructeur.append(numeroPage);
            constructeur.append(". ");
            constructeur.append(page.toString());
            constructeur.append("\n");
            numeroPage++;
        }  

        return constructeur.toString(); 
    }

    public void ajouterPage(Page unePage) { 
        listesPage.add(unePage);
    }
    
    public void retirerLesPages() { 
        listesPage.clear();
    }
    
    public String genererIdRendezVous() { 
        return String.valueOf(listesPage.size()); 
    }

    public void afficherSur(VueFileAttente uneVue) {
        uneVue.viderListePages();
        for (Page lesPage : listesPage) {
            uneVue.ajouterPage(lesPage);
        }
    }
}