package missile_wars.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Plancher implements ModelValue {
	
	int positionY;
	
	float[] tableauPlancher = new float[10];
	
	public Plancher() {
		for (int i = 0; i < tableauPlancher.length; i++) {
			tableauPlancher[i] = 10;
		}
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public float[] getTableauPlancher() {
		return tableauPlancher;
	}

	public void setTableauPlancher(float[] tableauPlancher) {
		this.tableauPlancher = tableauPlancher;
	}
}
