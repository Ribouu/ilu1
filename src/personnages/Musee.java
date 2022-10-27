package personnages;

public class Musee {
	Trophee[] trophees = new Trophee[200];
	int nbTrophee = 0;
	
//	public Musee() {
//		this.trophees = new Trophee[200];
//	}
	
	public void donnerTrophees(Gaulois gaulois, Trophee trophee) {
		this.trophees[nbTrophee] = trophee;
		this.nbTrophee += 1;
	}
	
	public String extraireInstructionsCaml() {
		String texte = "let musee = [\n";
		for (int i=0; i<nbTrophee; i++) {
			texte += "    \"" + trophees[i].getGaulois().getNom() + "\", \"" + trophees[i].getEquipement() + "\";\n";
//			texte += "    \"" + "test" + "\", \"" + "test" + "\";\n";
		}
		texte += "]";
		return texte;
	}
	
	public static void main(String[] args) {
		Musee musee = new Musee();
		System.out.println(musee.extraireInstructionsCaml());
	}
}
