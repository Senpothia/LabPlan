package com.michel.lab.model;

public class EssaiAux {
	
	private Integer id;
	private Integer numero;
	private String nom;
	private String version;
	private String domaine;
	private String statut;
	private String resultat;
	
	public EssaiAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public EssaiAux(Integer id, Integer numero, String referentiel, String version, String domaine, String statut,
			String resultat) {
		super();
		this.id = id;
		this.numero = numero;
		this.nom = referentiel;
		this.version = version;
		this.domaine = domaine;
		this.statut = statut;
		this.resultat = resultat;
	}



	public EssaiAux(Essai essai){
		
		this.id = essai.getId();
		this.numero = essai.getNumero();
		this.nom = essai.getProcedure().getNom();
		this.version = essai.getProcedure().getVersion();
		this.domaine = essai.getProcedure().getDomaine().getNom();
		
		if (essai.isStatut()) {
			
			this.statut = "En cours";
			this.resultat = "En cours";
			
		}else {
			
			this.statut = "Terminé";
			
			if (essai.isResultat()) {
				
				this.resultat = "Conforme";
				
			}else {
				
				this.resultat = "Non conforme";
			}
		}
		
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getNumero() {
		return numero;
	}



	public void setNumero(Integer numero) {
		this.numero = numero;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getVersion() {
		return version;
	}



	public void setVersion(String version) {
		this.version = version;
	}



	public String getDomaine() {
		return domaine;
	}



	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}



	public String getStatut() {
		return statut;
	}



	public void setStatut(String statut) {
		this.statut = statut;
	}



	public String getResultat() {
		return resultat;
	}



	public void setResultat(String resultat) {
		this.resultat = resultat;
	}


}
