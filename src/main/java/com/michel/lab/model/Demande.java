package com.michel.lab.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Demande {

	@Id
	@GeneratedValue
	private Integer id;
	private String numero;
	private LocalDateTime date;
	private String code;
	private String auxiliaire;
	private boolean statut; // Close, ouverte
	private boolean attente;
	private String urgence;
	private String produit;
	private String echantillon; // Description de l'échantillon
	private String origine; // Motivation de l'essai demandé
	private String essai; // travail attendu
	private String objectif;
	private String resultat;
	private String observation;
	private String avis;
	private LocalDateTime reponse;
	private String rapport;

	@OneToOne
	private Qualification qualification;

	@ManyToOne
	private Utilisateur demandeur;

	@ManyToOne
	private Utilisateur technicien;

	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Demande(Integer id, String numero, LocalDateTime date, String code, String auxiliaire, boolean statut,
			boolean attente, String urgence, String produit, String echantillon, String origine, String essai,
			String objectif, String resultat, String observation, String avis, LocalDateTime reponse, String rapport,
			Qualification qualification, Utilisateur demandeur, Utilisateur technicien) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.code = code;
		this.auxiliaire = auxiliaire;
		this.statut = statut;
		this.attente = attente;
		this.urgence = urgence;
		this.produit = produit;
		this.echantillon = echantillon;
		this.origine = origine;
		this.essai = essai;
		this.objectif = objectif;
		this.resultat = resultat;
		this.observation = observation;
		this.avis = avis;
		this.reponse = reponse;
		this.rapport = rapport;
		this.qualification = qualification;
		this.demandeur = demandeur;
		this.technicien = technicien;
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

	public boolean isAttente() {
		return attente;
	}

	public void setAttente(boolean attente) {
		this.attente = attente;
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

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public Utilisateur getDemandeur() {
		return demandeur;
	}

	public void setDemandeur(Utilisateur demandeur) {
		this.demandeur = demandeur;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAuxiliaire() {
		return auxiliaire;
	}

	public void setAuxiliaire(String auxiliaire) {
		this.auxiliaire = auxiliaire;
	}

	public String getUrgence() {
		return urgence;
	}

	public void setUrgence(String urgence) {
		this.urgence = urgence;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Utilisateur getTechnicien() {
		return technicien;
	}

	public void setTechnicien(Utilisateur technicien) {
		this.technicien = technicien;
	}

	public LocalDateTime getReponse() {
		return reponse;
	}

	public void setReponse(LocalDateTime reponse) {
		this.reponse = reponse;
	}


	public String getRapport() {
		return rapport;
	}


	public void setRapport(String rapport) {
		this.rapport = rapport;
	}
	
	

}
