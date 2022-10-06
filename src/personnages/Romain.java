package personnages;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
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
	
	public static void main(String[] args) {
		Romain cesar = new Romain("César", 6);
		assert cesar.isInvariantSatified();
		System.out.println(cesar.prendreParole());
		cesar.parler("Bonjour mon peup... Astérix non !!");
		cesar.recevoirCoup(4);
	}
	
}
