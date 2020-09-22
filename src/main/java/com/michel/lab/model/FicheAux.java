package com.michel.lab.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FicheAux {

	private Integer id;
	private Integer numero;
	private String date;
	private boolean statut; // Close, ouverte
	private String etat;
	private Integer niveau; // gravité
	private String degre;
	private String projet;
	private String produit;
	private String code;
	private String circonstance;
	private String observation; // description du symptome, phénomène observé
	private String incidence; // conséquences
	private String solution; // proposition
	private String domaine; // électronique, mécanique
	private String objet; // n° de carte, pièce mécanique
	private Integer qualification;
	private Integer numQualification;
	private Integer auteur;
	private String nomAuteur;
	private String reponse;
	private String service;
	private String document;

	public FicheAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FicheAux(Integer id, Integer numero, String date, boolean statut, String etat, Integer niveau, String degre,
			String projet, String produit, String code, String circonstance, String observation, String incidence,
			String solution, String domaine, String objet, Integer qualification, Integer numQualification,
			Integer auteur, String nomAuteur, String reponse, String service, String document) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.statut = statut;
		this.etat = etat;
		this.niveau = niveau;
		this.degre = degre;
		this.projet = projet;
		this.produit = produit;
		this.code = code;
		this.circonstance = circonstance;
		this.observation = observation;
		this.incidence = incidence;
		this.solution = solution;
		this.domaine = domaine;
		this.objet = objet;
		this.qualification = qualification;
		this.numQualification = numQualification;
		this.auteur = auteur;
		this.nomAuteur = nomAuteur;
		this.reponse = reponse;
		this.service = service;
		this.document = document;
	}

	public FicheAux(Fiche fiche) {

		super();
		this.id = fiche.getId();
		this.numero = fiche.getNumero();
		if (fiche.getDate() != null) {
			this.date = fiche.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		}
		this.statut = fiche.isStatut();
		this.niveau = fiche.getNiveau();
		this.degre = fiche.getDegre();
		this.projet = fiche.getProjet();
		this.code = fiche.getCode();
		this.circonstance = fiche.getCirconstance();
		this.observation = fiche.getCirconstance();
		this.incidence = fiche.getIncidence();
		this.solution = fiche.getSolution();
		this.domaine = fiche.getDomaine();
		this.objet = fiche.getObjet();
		this.service = fiche.getService();
		this.document = fiche.getDocument();

		Qualification qualif = fiche.getQualification();

		if (qualif != null) {

			this.qualification = fiche.getQualification().getId();
			this.numQualification = fiche.getQualification().getNumero();

		}

		this.auteur = fiche.getAuteur().getId();
		this.reponse = fiche.getReponse();
		this.produit = fiche.getProduit();
		if (fiche.isStatut()) {

			this.etat = "Active";

		} else {

			this.etat = "Fermée";
		}

		Utilisateur utilisateur = fiche.getAuteur();

		this.nomAuteur = utilisateur.getPrenom() + " " + utilisateur.getNom();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Integer getNiveau() {
		return niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	public String getProjet() {
		return projet;
	}

	public void setProjet(String projet) {
		this.projet = projet;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCirconstance() {
		return circonstance;
	}

	public void setCirconstance(String circonstance) {
		this.circonstance = circonstance;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getIncidence() {
		return incidence;
	}

	public void setIncidence(String incidence) {
		this.incidence = incidence;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public Integer getQualification() {
		return qualification;
	}

	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}

	public Integer getAuteur() {
		return auteur;
	}

	public void setAuteur(Integer auteur) {
		this.auteur = auteur;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	public Integer getNumQualification() {
		return numQualification;
	}

	public void setNumQualification(Integer numQualification) {
		this.numQualification = numQualification;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getDegre() {
		return degre;
	}

	public void setDegre(String degre) {
		this.degre = degre;
	}

}
