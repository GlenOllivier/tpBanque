package tpjava;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banque implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9194473230706953200L;
	List<Proprietaire> proprietaires;
	List<Compte> comptes;

	public Banque() {
		proprietaires = new ArrayList<Proprietaire>();
		comptes = new ArrayList<Compte>();
	}

	public void appliquerInterets() {
		Iterator<Compte> i = comptes.iterator();
		Compte tmp;
		while (i.hasNext()) {
			tmp = i.next();
			if (tmp instanceof LDD) {
				((LDD) tmp).appliquerInterets();
			}
		}
	}

	public ArrayList<Compte> getComptes(Proprietaire proprietaire) {
		ArrayList<Compte> comptes = new ArrayList<Compte>();
		Iterator<Compte> i = this.comptes.iterator();
		Compte tmp;
		while (i.hasNext()) {
			tmp = i.next();
			if (tmp.getProprietaire() == proprietaire) {
				comptes.add(tmp);
			}
		}
		return comptes;
	}

	public ArrayList<Compte> getComptesDecouvert() {
		ArrayList<Compte> comptes = new ArrayList<Compte>();
		Iterator<Compte> i = this.comptes.iterator();
		Compte tmp;
		while (i.hasNext()) {
			tmp = i.next();
			if (tmp.getMontant() <= 0) {
				comptes.add(tmp);
			}
		}
		return comptes;
	}

	public float getMontant(Proprietaire proprietaire) {
		ArrayList<Compte> comptes = getComptes(proprietaire);
		Iterator<Compte> i = comptes.iterator();
		Compte tmp;
		float montant = 0.0f;
		while (i.hasNext()) {
			tmp = i.next();
			montant += tmp.getMontant();
		}
		return montant;
	}

	public Proprietaire getProprietaire(String nomPartiel) {
		Iterator<Proprietaire> i = this.proprietaires.iterator();
		Proprietaire tmp;
		while (i.hasNext()) {
			tmp = i.next();
			if (tmp.getNom().contains(nomPartiel)) {
				return tmp;
			}
		}
		return null;
	}

	public void save() throws IOException {
		FileOutputStream fos = new FileOutputStream("resources/banque.data");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this);
		oos.close();
	}
}
