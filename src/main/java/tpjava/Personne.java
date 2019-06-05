package tpjava;

public class Personne extends Proprietaire {
	private final static String type = "Personne";
	String dateNaissance;

	public Personne(String nom, String adresse, String dateNaissance) {
		super(nom, adresse);
		this.dateNaissance = dateNaissance;
	}

	@Override
	public String getType() {
		return type;
	}

}
