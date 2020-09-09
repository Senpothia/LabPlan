package com.michel.lab.model;

import java.time.LocalDateTime;

public class DemandeAux {

	private Integer id;
	private String numero;
	private LocalDateTime date;
	private boolean statut; // Close, ouverte
	private String etat;
	private boolean attente;
	private String encours;
	private String produit;
	private String echantillon; // Description de l'échantillon
	private String origine; // Motivation de l'essai demandé
	private String essai; // travail attendu
	private String objectif;
	private String resultat;
	private String avis;
	private Integer idQualification;
	private String refQualification;
	private Integer idDemandeur;
	private String demandeur;

	public DemandeAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandeAux(Integer id, String numero, LocalDateTime date, boolean statut, String etat, boolean attente,
			String encours, String produit, String echantillon, String origine, String essai, String objectif,
			String resultat, String avis, Integer idQualification, String refQualification, Integer idDemandeur,
			String demandeur) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.statut = statut;
		this.etat = etat;
		this.attente = attente;
		this.encours = encours;
		this.produit = produit;
		this.echantillon = echantillon;
		this.origine = origine;
		this.essai = essai;
		this.objectif = objectif;
		this.resultat = resultat;
		this.avis = avis;
		this.idQualification = idQualification;
		this.refQualification = refQualification;
		this.idDemandeur = idDemandeur;
		this.demandeur = demandeur;
	}

	public DemandeAux(Demande demande) {
		super();
		this.id = demande.getId();
		this.numero = demande.getNumero();
		this.date = demande.getDate();
		this.statut = demande.isStatut();
		this.produit = demande.getProduit();
		this.echantillon = demande.getEchantillon();
		this.origine = demande.getOrigine();
		this.essai = demande.getEssai();
		this.objectif = demande.getObjectif();
		this.resultat = demande.getResultat();
		this.avis = demande.getAvis();
		this.demandeur = demande.getDemandeur().getPrenom() + " " + demande.getDemandeur().getNom();
		this.idDemandeur = demande.getDemandeur().getId();

		Qualification qualification = demande.getQualification();
		if (qualification != null) {

			this.idQualification = demande.getQualification().getId();
			this.refQualification = demande.getQualification().getReference();

		} else {

			this.idQualification = null;
			this.refQualification = null;
		}
		
		if(!demande.isStatut()) {
			
			this.etat = "Ouverte";
			
		}else {
			
			this.etat = "Fermée";
		}
		
		if(demande.isAttente()) {
			
			this.encours = "En cours";
			
		}else {
			
			
			this.encours = "En attente";
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getEchantillon() {
		return echantillon;
	}

	public void setEchantillon(String echantillon) {
		this.echantillon = echantillon;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public String getEssai() {
		return essai;
	}

	public void setEssai(String essai) {
		this.essai = essai;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public Integer getIdQualification() {
		return idQualification;
	}

	public void setIdQualification(Integer idQualification) {
		this.idQualification = idQualification;
	}

	public String getRefQualification() {
		return refQualification;
	}

	public void setRefQualification(String refQualification) {
		this.refQualification = refQualification;
	}

	public Integer getIdDemandeur() {
		return idDemandeur;
	}

	public void setIdDemandeur(Integer idDemandeur) {
		this.idDemandeur = idDemandeur;
	}

	public String getDemandeur() {
		return demandeur;
	}

	public void setDemandeur(String demandeur) {
		this.demandeur = demandeur;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public boolean isAttente() {
		return attente;
	}

	public void setAttente(boolean attente) {
		this.attente = attente;
	}

	public String getEncours() {
		return encours;
	}

	public void setEncours(String encours) {
		this.encours = encours;
	}
	
	

}
