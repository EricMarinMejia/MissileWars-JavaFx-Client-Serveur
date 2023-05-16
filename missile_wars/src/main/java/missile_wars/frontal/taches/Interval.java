package missile_wars.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.clock;

import java.util.HashMap;
import java.util.Map;

import ca.ntro.app.tasks.frontend.FrontendTasks;

public class Interval {
	
	public static void creerTaches(FrontendTasks tasks) {
		tasks.taskGroup("Interval")
		.andContains(subTasks -> {
			
			intervalNextTick(subTasks);
			
		});
	}
	
	private static Map<Integer, Runnable> mapRunnables = new HashMap<>();
	private static int prochainId = 1;
	
	public static int ajouterMethode(Runnable methode) {
		mapRunnables.put(prochainId, methode);
		prochainId++;
		return prochainId - 1;
	}
	
	public static void retirerMethode(int idMethode) {
		mapRunnables.remove(idMethode);
	}
	
	
	private static void intervalNextTick(FrontendTasks subTasks) {
		subTasks.task("intervalNextTick")
		.waitsFor(clock().nextTick())
		.thenExecutes(inputs -> {
			for (Runnable methode : mapRunnables.values()) {
				methode.run();
			}
		});
	}
	
	
	
}
