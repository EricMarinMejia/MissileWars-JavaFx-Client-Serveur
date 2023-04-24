package missile_wars.commun.maquettes;

public class MaquetteSession {
	
	public static String regionDeUsagerCourant = "NA";
	
	public static boolean modeTest = true;
	
	public static String usagerCourant() {
		return regionDeUsagerCourant;
	}
	
	public static void initialiser(String[] args) {
		
		if (args.length > 0) {
			regionDeUsagerCourant = args[0];
		}
		
	}
	

}
