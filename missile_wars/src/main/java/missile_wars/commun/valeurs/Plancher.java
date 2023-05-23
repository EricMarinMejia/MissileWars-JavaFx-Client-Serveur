package missile_wars.commun.valeurs;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.ModelValue;

public class Plancher implements ModelValue {
	
	int positionY;
	
	List<Float> tableauPlancher = new ArrayList<Float>();
	
	private static final int NB_DIVISION_PLANCHER = 10;
	
	public Plancher() {
		for (int i = 0; i < NB_DIVISION_PLANCHER; i++) {
			tableauPlancher.add(10f);
		}
	}
	
	public Plancher(int positionY) {
		this();
		this.positionY = positionY;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public List<Float> getTableauPlancher() {
		return tableauPlancher;
	}

	public void setTableauPlancher(List<Float> tableauPlancher) {
		this.tableauPlancher = tableauPlancher;
	}
}
