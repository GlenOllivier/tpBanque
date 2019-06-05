package tpjava;

import java.io.Serializable;

public abstract class Proprietaire implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nom;
	protected String adresse;

	protected Proprietaire(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public abstract String getType();

}
