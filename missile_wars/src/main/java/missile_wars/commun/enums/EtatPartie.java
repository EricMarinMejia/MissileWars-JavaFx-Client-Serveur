package missile_wars.commun.enums;

public enum EtatPartie {
	NULLE,
	EN_ATTENTE_DE_JOUEUR,
	EN_COURS,
	TERMINE;
	
	public static EtatPartie aPartirDeInt(int ordinal) {
		for (EtatPartie ep : EtatPartie.values()) {
			if (ep.ordinal() == ordinal) {
				return ep;
			}
		}
		return EtatPartie.NULLE;
	}
}
