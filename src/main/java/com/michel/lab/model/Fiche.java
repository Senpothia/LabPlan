package com.michel.lab.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.michel.lab.service.jpa.QualificationService;

@Entity
public class Fiche {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer numero;
	private LocalDateTime date;
	private boolean statut;			// Close, ouverte
	private Integer niveau;			// gravité
	private String degre;
	private String projet;
	private String code;
	private String produit;
	private String circonstance;
	private String observation;		// description du symptome, phénomène observé
	private String incidence;		// conséquences
	private String solution; 		// proposition
	private String domaine;			// électronique, mécanique
	private String objet;  			// n° de carte, pièce mécanique
	private String reponse;
	
	@ManyToOne
	private Qualification qualification;
	
	@ManyToOne
	private Utilisateur auteur;
	
	

	public Fiche() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Fiche(Integer id, Integer numero, LocalDateTime date, boolean statut, Integer niveau, String degre,
			String projet, String code, String produit, String circonstance, String observation, String incidence,
			String solution, String domaine, String objet, String reponse, Qualification qualification,
			Utilisateur auteur) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.statut = statut;
		this.niveau = niveau;
		this.degre = degre;
		this.projet = projet;
		this.code = code;
		this.produit = produit;
		this.circonstance = circonstance;
		this.observation = observation;
		this.incidence = incidence;
		this.solution = solution;
		this.domaine = domaine;
		this.objet = objet;
		this.reponse = reponse;
		this.qualification = qualification;
		this.auteur = auteur;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
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

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

	public String getDegre() {
		return degre;
	}

	public void setDegre(String degre) {
		this.degre = degre;
	}

	
}
