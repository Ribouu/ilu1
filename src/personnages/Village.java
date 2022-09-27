package personnages;

public class Village {
	private String nom;
	private int nombreVillageois;
	
	public Village(String nom, int nombreVillageois) {
		this.nom = nom;
		this.nombreVillageois = nombreVillageois;
	}

	public String getNom() {
		return nom;
	}

	public void setNombreVillageois(int nombreVillageois) {
		this.nombreVillageois = nombreVillageois;
	}
}
