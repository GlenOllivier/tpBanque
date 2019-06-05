package tpjava;

public class LEP extends LDD {
	protected static float montantMin = 30.0f;
	protected static float montantMax = 7_700.0f;
	protected static float interets = 0.015f;

	public LEP(Personne proprietaire) {
		super(proprietaire);
		this.montant = montantMin;
	}

	public LEP(Personne proprietaire, float montant) {
		super(proprietaire, montant);
	}

}
