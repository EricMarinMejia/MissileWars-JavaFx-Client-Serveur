package missile_wars.commun.valeurs;

import ca.ntro.app.models.*;

/**
 * 
 * @author charles
 * Représente une touche du clavier avec ue valeur textuelle de la touche.
 * 
 * Pour les lettres et les numéros, c'est juste une chaine de texte de 1 caractère qui contient le caractère de la touche correspondante.
 * Pour les autres touches, la représentation est non-spécifié.
 *
 */
public class KeyStringRepresentation implements ModelValue {
	
	private String value = "a";
	
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
	
	public KeyStringRepresentation() {
		
	}
	public KeyStringRepresentation(String value) {
		this.value = value;
	}
	
	public KeyStringRepresentation clone() {
		return new KeyStringRepresentation(this.value);
	}
}
