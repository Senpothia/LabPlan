package com.michel.lab.model;

import java.time.LocalDateTime;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class FormDemande {
	
	private Integer id;
	private String numero;
	private LocalDateTime date;
	private boolean statut; // Close, ouverte
	private String produit;
	private String echantillon; // Description de l'échantillon
	private String origine; // Motivation de l'essai demandé
	private String essai; // travail attendu
	private String objectif;
	private String resultat;
	private String avis;
	private Integer qualification;
	private Integer demandeur;
	private String reponse;
	
	private String rapport;
	private String auxiliaire;
	private String dateReponse;
	private String urgence;
	private String code;
	private String observation;
	
	public FormDemande() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public FormDemande(Integer id, String numero, LocalDateTime date, boolean statut, String produit,
			String echantillon, String origine, String essai, String objectif, String resultat, String avis,
			Integer qualification, Integer demandeur, String reponse, String rapport, String auxiliaire,
			String dateReponse, String urgence, String code, String observation) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.statut = statut;
		this.produit = produit;
		this.echantillon = echantillon;
		this.origine = origine;
		this.essai = essai;
		this.objectif = objectif;
		this.resultat = resultat;
		this.avis = avis;
		this.qualification = qualification;
		this.demandeur = demandeur;
		this.reponse = reponse;
		this.rapport = rapport;
		this.auxiliaire = auxiliaire;
		this.dateReponse = dateReponse;
		this.urgence = urgence;
		this.code = code;
		this.observation = observation;
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

	public Integer getQualification() {
		return qualification;
	}

	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}

	public Integer getDemandeur() {
		return demandeur;
	}

	public void setDemandeur(Integer demandeur) {
		this.demandeur = demandeur;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}



	public String getRapport() {
		return rapport;
	}



	public void setRapport(String rapport) {
		this.rapport = rapport;
	}



	public String getAuxiliaire() {
		return auxiliaire;
	}



	public void setAuxiliaire(String auxiliaire) {
		this.auxiliaire = auxiliaire;
	}



	public String getDateReponse() {
		return dateReponse;
	}



	public void setDateReponse(String dateReponse) {
		this.dateReponse = dateReponse;
	}



	public String getUrgence() {
		return urgence;
	}



	public void setUrgence(String urgence) {
		this.urgence = urgence;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getObservation() {
		return observation;
	}



	public void setObservation(String observation) {
		this.observation = observation;
	}

	
	
}
