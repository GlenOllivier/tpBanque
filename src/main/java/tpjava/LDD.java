package tpjava;

public class LDD extends Compte {
	protected static float montantMin = 15.0f;
	protected static float montantMax = 12_000.0f;
	protected static float interets = 0.01f;

	public LDD(Proprietaire proprietaire) {
		super(proprietaire);
		this.montant = montantMin;
	}

	public LDD(Proprietaire proprietaire, float montant) {
		super(proprietaire, montant);
	}

	public void appliquerInterets() {
		this.montant += this.montant * interets;
	}

	@Override
	public boolean retirer(float montant) {
		if (montant < 0) {
			return false;
		}
		if (this.montant - montantMin > montant) {
			this.montant -= montant;
			return true;
		}
		return false;
	}

	@Override
	public boolean deposer(float montant) {
		if (montant < 0 || montant + this.montant > montantMax) {
			return false;
		}
		this.montant += montant;
		return true;
	}
}
