package com.michel.lab.model;

import java.time.LocalDateTime;
import java.util.Date;

public class FormQualif {
	
	private String produit;
	private String projet;
	//private Date date;
	private String objet;
	private boolean statut;  // Ouverte, cloturée
	private boolean resultat;
	private Integer createurId;
	
	
	public FormQualif() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FormQualif(String produit, String projet, String objet, boolean statut, boolean resultat) {
		super();
		this.produit = produit;
		this.projet = projet;
		this.objet = objet;
		this.statut = statut;
		this.resultat = resultat;
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


	public String getObjet() {
		return objet;
	}


	public void setObjet(String objet) {
		this.objet = objet;
	}


	public boolean isStatut() {
		return statut;
	}


	public void setStatut(boolean statut) {
		this.statut = statut;
	}


	public boolean isResultat() {
		return resultat;
	}


	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}

	

	public Integer getCreateurId() {
		return createurId;
	}


	public void setCreateurId(Integer createurId) {
		this.createurId = createurId;
	}


	@Override
	public String toString() {
		return "FormQualif [produit=" + produit + ", projet=" + projet + ", objet=" + objet + ", statut=" + statut
				+ ", resultat=" + resultat + ", createurId=" + createurId + "]";
	}


}
