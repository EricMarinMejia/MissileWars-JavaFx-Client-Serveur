package missile_wars.commun.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.ModelValue;
import missile_wars.frontal.vues.fragments.FragmentCouleur;

import java.util.Random;

public class Couleur implements ModelValue {
	private int rouge;
	private int vert;
	private int bleu;

	public Couleur() {

	}

	public Couleur(int rouge, int vert, int bleu) {
		this.rouge = rouge;
		this.vert = vert;
		this.bleu = bleu;
	}

	public void setRGB(int rouge, int vert, int bleu) {
		setRouge(rouge);
		setVert(vert);
		setBleu(bleu);
	}

	public int getRouge() {
		return rouge;
	}

	public void setRouge(int rouge) {
		this.rouge = rouge;
	}

	public int getVert() {
		return vert;
	}

	public void setVert(int vert) {
		this.vert = vert;
	}

	public int getBleu() {
		return bleu;
	}

	public void setBleu(int bleu) {
		this.bleu = bleu;
	}

	public String toString() {
		// Définition de noms de couleurs
		String[] colors = {
			"Red", "Green", "Blue", "Yellow", "Orange", "Purple", "Pink", "Brown", "Gray", "Black", "White",
			"Cyan", "Magenta", "Lime", "Turquoise", "Olive", "Maroon", "Navy", "Teal", "Silver", "Gold",
			"Beige", "Lavender", "Mint", "Peach", "Plum", "Salmon", "Slate", "Violet", "Amber", "Aqua",
			"Azure", "Charcoal", "Crimson", "Cobalt", "Coral", "Cinnamon", "Coffee", "Copper", "Cream", "Denim",
			"Emerald", "Forest", "Fuchsia", "Garnet", "Hazel", "Indigo", "Ivory", "Jade", "Khaki", "Lemon",
			"Lilac", "Mauve", "Mustard", "Nude", "Ochre", "Olive", "Onyx", "Pewter", "Ruby", "Rust",
			"Saffron", "Scarlet", "Sienna", "Sky", "Slate", "Steel", "Taupe", "Terra cotta", "Topaz", "Tangerine",
			"Tiffany", "Tomato", "Tropical", "Tulip", "Turquoise", "Wheat", "Wisteria", "Zaffre", "Zinnia", "Sapphire"
		};
        Random r=new Random(); 
        int randomNumber=r.nextInt(colors.length); 
		System.out.println(colors[randomNumber]); 
        return(colors[randomNumber]); 
	}

	public FragmentCouleur creerFragment(ViewLoader<FragmentCouleur> viewLoaderParametres) {
		return viewLoaderParametres.createView();
	}

	public void afficherSur(FragmentCouleur fragmentCouleur) {
		fragmentCouleur.afficherCouleur(this.toString());
	}
}