package com.michel.lab.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RapportAux {
	
	private Integer id;
	private String titre;
	private String auteur;
	private String date;
	private Integer version;
	private String identifiant;
	private String demande;
	
	public RapportAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RapportAux(Integer id, String titre, String auteur, String date, Integer version, String identifiant,
			String demande) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.date = date;
		this.version = version;
		this.identifiant = identifiant;
		this.demande = demande;
	}
	
	
	public RapportAux(Rapport rapport) {
		
		this.id = rapport.getId();
		this.titre = rapport.getTitre();
		
		Utilisateur user = rapport.getAuteur();
	
		this.auteur = user.getPrenom() + user.getNom();
		/*
		LocalDateTime dateAux = rapport.getDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 
		this.date = dateAux.format(formatter);
		
		*/
		this.date = "fff";
		this.version = rapport.getVersion();
		this.identifiant = rapport.getIdentifiant();
		this.demande = rapport.getDemande();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getDemande() {
		return demande;
	}

	public void setDemande(String demande) {
		this.demande = demande;
	}
	

}
