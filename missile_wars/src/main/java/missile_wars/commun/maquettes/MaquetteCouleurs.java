package missile_wars.commun.maquettes;

import java.util.List;
import java.util.Random;

import ca.ntro.core.initialization.Ntro;
import missile_wars.commun.valeurs.Couleur;

public class MaquetteCouleurs {

    public static boolean modeTest = true;

    private static Couleur couleurCourante = couleurAleatoire();

    public static boolean siUsagerLocal(Couleur usager) {
        boolean siLocal = false;

        if(modeTest) {

            siLocal = true;

        }else if(couleurCourante.equals(usager)) {

            siLocal = true;
        }

        return siLocal;
    }

    public static Couleur couleurCourante() {
        return couleurCourante;
    }

    public static void prochaineCouleur() {
    	couleurCourante = couleurAleatoire();
    }

    static Couleur couleurAleatoire() {
    	Couleur uneCouleur = new Couleur();
    	Random nbAleatoire= new Random();
        uneCouleur.setRGB(
        		nbAleatoire.nextInt(255), //Rouge
        		nbAleatoire.nextInt(255), //Bleu
        		nbAleatoire.nextInt(255)); //Vert

        return uneCouleur;
    }

    public static void initialiser(String[] args) {
    	couleurCourante = couleurAleatoire();
    	
    	
    }

}
