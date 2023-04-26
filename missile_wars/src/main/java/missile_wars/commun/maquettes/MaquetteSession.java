package missile_wars.commun.maquettes;

import missile_wars.commun.valeurs.Couleur;

public class MaquetteSession {

    public static boolean modeTest = true;

    static Couleur CouleurCourant = MaquetteCouleurs.couleurAleatoire();
    //private static Cadran cadranCourant = Cadran.DROITE;

    public static Couleur CouleurCourant () {
        return CouleurCourant;
    }

    // public static boolean siOnPeutJouerGauche() {
    //     return cadranCourant == Cadran.GAUCHE 
    //             || cadranCourant == Cadran.LES_DEUX;

    // }

    // public static boolean siOnPeutJouerDroite() {
    //     return cadranCourant == Cadran.DROITE 
    //             || cadranCourant == Cadran.LES_DEUX;

    // }

    // public static void memoriserCadranCourant(String idPremierJoueur, 
    //                                           String idDeuxiemeJoueur) {

    //     if(idPremierJoueur.equals(CouleurCourant.getId())) {

    //         cadranCourant = Cadran.GAUCHE;

    //     }else if(idDeuxiemeJoueur.equals(CouleurCourant.getId())) {

    //         cadranCourant = Cadran.DROITE;

    //     }else {

    //         cadranCourant = Cadran.LES_DEUX;
    //     }
    // }

    public static void initialiser(String[] args) {
        //CouleurCourant = couleurAleatoire();

        
        // String id = null;
        // String prenom = null;
        // String nom = null;

        // if(args.length > 0) {
        //     id = args[0];
        //     modeTest = false;
        // }else {
        //     id = MaquetteCouleurs.idAleatoire();
        // }           

        // if(args.length > 1) {
        //     prenom = args[1];
        // }else {
        //     prenom = MaquetteCouleurs.prenomAleatoire();
        // }

        // if(args.length > 2) {
        //     nom = args[2];
        // }else {
        //     nom = MaquetteCouleurs.nomAleatoire();
        // }

        // CouleurCourant = new Couleur();
    }

}