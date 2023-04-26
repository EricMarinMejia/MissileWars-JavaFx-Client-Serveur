package missile_wars.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.messages.MessageNtro;
import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import missile_wars.commun.maquettes.MaquetteCouleurs;
import missile_wars.commun.messages.MsgAjouterCouleur;
import missile_wars.commun.valeurs.Couleur;
import missile_wars.frontal.vues.VueParametres;

public class ModeleParametres implements Model, WatchJson, WriteObjectGraph {
	private int max = 100;
	private int min = 0;
	private int soundFx = 50;
	private int musicFx = 50;
	private Couleur couleursPrincipales = new Couleur(66, 245, 72);

	private List<Couleur> lesCouleursPrincipales = new ArrayList<>();

	public List<Couleur> getLesCouleursPrincipales() {
		return lesCouleursPrincipales;
	}

	public void setLesCouleursPrincipales(List<Couleur> couleursPrincipales) {
		this.lesCouleursPrincipales = couleursPrincipales;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSoundFx() {
		return soundFx;
	}

	public void setSoundFx(int soundFx) {
		this.soundFx = soundFx;
	}

	public int getMusicFx() {
		return musicFx;
	}

	public void setMusicFx(int musicFx) {
		this.musicFx = musicFx;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		int numCouleursPrincipales = 1;
		for (Couleur couleur : lesCouleursPrincipales) {
			builder.append(numCouleursPrincipales);
			builder.append(". ");
			builder.append(couleur.toString());
			builder.append("\n");
			numCouleursPrincipales++;
		}
		return builder.toString();
	}

	public void afficherSur(VueParametres vueParametres) {
		//vueParametres.afficherParametresEnTexte(this.toString());
		vueParametres.viderListeCouleurs();
            
            // ajouter
            for(Couleur couleur : lesCouleursPrincipales) {
                
                vueParametres.ajouterCouleur(couleur);
            }
	}

	public void ajouterCouleur(Couleur myColor) {
		lesCouleursPrincipales.add(MaquetteCouleurs.couleurCourante());
		MaquetteCouleurs.prochaineCouleur();
	}
}
