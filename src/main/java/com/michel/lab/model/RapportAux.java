package com.michel.lab.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class RapportAux {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer idEssai;
	private String titre;
	private String auteur;
	private String date;
	private Integer version;
	private String identifiant;
	private String demande;
	private Integer qualification; 
	private String objet;
	private String projet;
	private String avis;
	
	
	
	public RapportAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public RapportAux(Integer id, String titre, String auteur, String date, Integer version, String identifiant,
			String demande, Integer qualification, String objet, String projet, String avis) {
		super();
		this.idEssai = id;
		this.titre = titre;
		this.auteur = auteur;
		this.date = date;
		this.version = version;
		this.identifiant = identifiant;
		this.demande = demande;
		this.qualification = qualification;
		this.objet = objet;
		this.projet = projet;
		this.avis = avis;
	}




	public RapportAux(Rapport rapport) {
		
		this.idEssai = rapport.getId();
		this.titre = rapport.getTitre();
		
		Utilisateur user = rapport.getAuteur();
	
		this.auteur = user.getPrenom()+ " " + user.getNom();
		
		LocalDateTime dateAux = rapport.getDate();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		this.date = dateAux.format(formatter);
		
		this.version = rapport.getVersion();
		this.identifiant = rapport.getIdentifiant();
		this.demande = rapport.getDemande();
		this.qualification = rapport.getQualification().getNumero();
		this.objet = rapport.getObjet();
		this.projet = rapport.getProjet();
		this.avis = rapport.getAvis();
		
	}

	public Integer getId() {
		return idEssai;
	}

	public void setId(Integer id) {
		this.idEssai = id;
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




	public Integer getQualification() {
		return qualification;
	}




	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}


	public String getObjet() {
		return objet;
	}


	public void setObjet(String objet) {
		this.objet = objet;
	}





	public String getProjet() {
		return projet;
	}


	public void setProjet(String projet) {
		this.projet = projet;
	}



	public String getAvis() {
		return avis;
	}



	public void setAvis(String avis) {
		this.avis = avis;
	}
	
	

}
