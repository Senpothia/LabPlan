package com.michel.lab.model;

import java.time.LocalDateTime;

public class Qualification {
	
	private Integer id;
	private String produit;
	private String projet;
	private LocalDateTime date;
	private String objet;
	private boolean resultat;
	
	public Qualification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getProjet() {
		return projet;
	}

	public void setProjet(String projet) {
		this.projet = projet;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public boolean isResultat() {
		return resultat;
	}

	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}
	
	
}
