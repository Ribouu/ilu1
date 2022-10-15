package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceToujoursPositive();
		int forceAvantCoup = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe !");
		} else {
			parler("J'abandonne...");
		}
		assert force < forceAvantCoup;
	}

	private boolean forceToujoursPositive() {
		return (force >= 0);
	}

	private boolean isInvariantSatified() {
		return forceToujoursPositive();
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			equipements[0] = equipement;
			System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement + ".");
			nbEquipement += 1;
			break;
		case 1:
			if (equipements[0] == equipement) {
				System.out.println("Le soldat " + getNom() + " possède déjà un " + equipement + " !");
			} else {
				equipements[1] = equipement;
				System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement + ".");
				nbEquipement += 1;
			}
			break;
		default:
			System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		assert minus.isInvariantSatified();
		System.out.println(minus.prendreParole());
		minus.parler("Bonjour tout le mo... Astérix non !!");
		minus.recevoirCoup(4);
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		System.out.println(casque);
		System.out.println(bouclier);
		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(casque);
	}
}