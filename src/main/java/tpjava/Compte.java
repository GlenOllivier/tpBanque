package tpjava;

import java.io.Serializable;

public class Compte implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4568735854623980676L;
	protected Proprietaire proprietaire;
	protected int id;
	protected static int autoIncrement = 0;
	protected float montant;

	public Compte(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
		this.montant = 0.0f;
		this.id = autoIncrement;
		autoIncrement++;
	}

	public Compte(Proprietaire proprietaire, float montant) {
		this.proprietaire = proprietaire;
		this.montant = montant;
		this.id = autoIncrement;
		autoIncrement++;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public int getId() {
		return id;
	}

	public float getMontant() {
		return montant;
	}

	public boolean retirer(float montant) {
		if (montant < 0) {
			return false;
		}
		if (this.montant > montant) {
			this.montant -= montant;
			return true;
		}
		return false;
	}

	public boolean deposer(float montant) {
		if (montant < 0) {
			return false;
		}
		this.montant += montant;
		return true;
	}

	public boolean virement(Compte c, float montant) {
		float montantRetire = montant + 1;
		if (c.getProprietaire() == this.getProprietaire()) {
			montantRetire = montant;
		}
		if (this.retirer(montantRetire)) {
			if (c.deposer(montant)) {
				return true;
			} else {
				this.deposer(montantRetire);
				return false;
			}
		} else {
			return false;
		}
	}

	public void setAutoIncrement(int nb) {
		autoIncrement = nb;
	}
}
