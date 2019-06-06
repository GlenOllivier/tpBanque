package tpjava;

public class VirementAutomatique {
	private Compte in;
	private Compte out;
	private float montant;

	protected VirementAutomatique(Compte in, Compte out, float montant) {
		this.in = in;
		this.out = out;
		this.montant = montant;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public boolean appliquer() {
		return in.virement(out, montant);
	}
}
