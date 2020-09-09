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
	private boolean statut; // Close, ouverte
	private String produit;
	private String echantillon; // Description de l'échantillon
	private String origine; // Motivation de l'essai demandé
	private String essai; // travail attendu
	private String objectif;
	private String resultat;
	private String avis;

	@OneToOne
	private Qualification qualification;

	@ManyToOne
	private Utilisateur demandeur;

	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Demande(Integer id, String numero, LocalDateTime date, boolean statut, String produit, String echantillon,
			String origine, String essai, String objectif, String resultat, String avis, Qualification qualification,
			Utilisateur demandeur) {
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

	

}
