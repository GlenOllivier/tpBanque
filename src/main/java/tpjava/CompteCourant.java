package tpjava;

public class CompteCourant extends Compte {
	protected float decouvertAutorise;

	public CompteCourant(Proprietaire proprietaire) {
		super(proprietaire);
	}

	public CompteCourant(Proprietaire proprietaire, float montant) {
		super(proprietaire, montant);
	}

	public float getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(float decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	@Override
	public boolean retirer(float montant) {
		if (montant < 0) {
			return false;
		}
		if (this.montant + decouvertAutorise > montant) {
			this.montant -= montant;
			return true;
		}
		return false;
	}
}
