package tpjava;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Banque b = new Banque();
		Proprietaire p1 = new Personne("Bob", "24 avenue des brosses a dent 29200 brest", "05/06/1987");
		Proprietaire p2 = new Societe("Bzh Parcmetres", "24 place des palissades 29200 brest",
				"Jean-françois Maillard");

		b.proprietaires.add(p1);
		b.proprietaires.add(p2);
		b.comptes.add(new LEP((Personne) p1, 150.0f));
		b.comptes.add(new LDD(p2, 4500.0f));
		VirementAutomatique v = new VirementAutomatique(b.getComptes(p1).get(0), b.getComptes(p2).get(0), 100.0f);
		b.virements.add(v);
		b.appliquerInterets();
		System.out.println(b.getMontant(p1));
		System.out.println(b.getMontant(p2));
		b.appliquerVirements();
		System.out.println(b.getMontant(p1));
		System.out.println(b.getMontant(p2));
	}
}
