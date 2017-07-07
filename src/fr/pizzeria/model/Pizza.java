package fr.pizzeria.model;

public class Pizza {

	int id;
	String code;
	String nom;
	Double prix;
	
	/**
	 * @param id
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(int id, String code, String nom, Double prix){
		
		this.id = id;
		this.code=code;
		this.nom=nom;
		this.prix=prix;
	}
	
	/**
	 * @param code
	 * @param nom
	 * @param prix
	 */
	public Pizza(String code, String nom, Double prix){
	
		this.code=code;
		this.nom=nom;
		this.prix=prix;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return
	 */
	public Double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 */
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
}
