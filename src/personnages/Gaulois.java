package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private int nbTrophees;
	Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}
	
	private void setEffetPotion(int nouveauEffetPotion) {
		effetPotion = nouveauEffetPotion;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
		
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
			trophees[nbTrophees] = trophees[i];
		}
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
		+ ", effetPotion=" + effetPotion + "]";
	}
	public void boirePotion(int forcePotion) {
		setEffetPotion(forcePotion);
		parler("Merci Druide, je sens que ma force est "+ effetPotion + " fois décuplée.");
	}
	
	public void faireUneDonation(Musee musee) {
		if (nbTrophees!=0) {
			String texte = "Je donne au musee tous mes trophees :\n";
			for (int i=0; i<nbTrophees; i++) {
				texte += "- " + this.trophees[i] + "\n";
				Trophee trophee = new Trophee(this, trophees[i]);
				musee.donnerTrophees(this, trophee);
			}
		System.out.println(texte);
		} else {
			System.out.println("Je n'ai pas de trophées à donner.");
		}
		
	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain cesar = new Romain("César", 2);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		System.out.println(asterix.getNom());
		System.out.println(asterix);
		System.out.println(asterix.prendreParole());
		asterix.parler("Yo la famille");
		int forcePotion = panoramix.preparerPotion();
		asterix.boirePotion(forcePotion);
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		cesar.sEquiper(casque);
		cesar.sEquiper(bouclier);
		asterix.frapper(cesar);
		asterix.frapper(cesar);
		asterix.frapper(cesar);
		asterix.frapper(cesar);
		Musee musee = new Musee();
		asterix.faireUneDonation(musee);
		System.out.println(musee.extraireInstructionsCaml());
	}
}

