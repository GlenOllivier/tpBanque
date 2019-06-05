package tpjava;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Banque b = new Banque();
		Personne p = new Personne("Bob", "24 avenue des brosses a dent 29200 brest", "05/06/1987");
		b.proprietaires.add(p);
		b.comptes.add(new LDD(p, 150.0f));
		try {
			b.save();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
}
