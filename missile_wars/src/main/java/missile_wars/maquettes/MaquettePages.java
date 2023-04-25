package missile_wars.maquettes;

import java.util.List;

import ca.ntro.core.initialization.Ntro;
import missile_wars.commun.valeurs.Page;

public class MaquettePages {
    public static boolean modeTest = true;
    private static Page pageCourante = pageAleatoire();

    public static Page pageCourante() {
        return pageCourante;
    }

    public static boolean siPageLocal(Page unePage) {
        boolean siLocal = false;

        if (modeTest == true) {
            siLocal = true;
        } else if (pageCourante.equals(unePage)) {
            siLocal = true;
        }

        return siLocal;
    }

    public static void prochainePage() {
        pageCourante = eviterRepetitionDeNom(pageAleatoire());
    }

    private static Page pageAleatoire() {
        Page unePage = new Page(); 
        unePage.setNomVue(nomVueAleatoire());
        unePage.setTouches(toucheAleatoire());
        unePage.setEstComplete(false);
        return unePage;
    }

    private static String toucheAleatoire() {
        List<String> choixTouches = List.of("w,d,a,s");
        return Ntro.random().choice(choixTouches);
    }

    private static String nomVueAleatoire() {
        List<String> choixDeVues = List.of("VueIntroduction","VueDeplacement", "VueCombat", "VueVictoire");
        return Ntro.random().choice(choixDeVues);
    }

    private static Page eviterRepetitionDeNom(Page unePage) {
        while (unePage.getNomVue().equals(pageCourante.getNomVue())) {
            unePage.setNomVue(nomVueAleatoire());
        }
        return unePage;
    }

    public static void initialiser(String[] args) {
        String nomFichierFXML = null;
        
        if (args.length > 0) {
            nomFichierFXML = args[0];
            modeTest = false;
        } else {
            nomFichierFXML = nomVueAleatoire();
        }
        pageCourante = new Page(nomFichierFXML, false, toucheAleatoire());
    }
}