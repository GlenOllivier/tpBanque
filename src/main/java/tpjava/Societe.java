package tpjava;

public class Societe extends Proprietaire {
	String nomGerant;
	private static final String type = "Societe";

	public Societe(String nom, String adresse, String nomGerant) {
		super(nom, adresse);
		this.nomGerant = nomGerant;
	}

	@Override
	public String getType() {
		return type;
	}

}
