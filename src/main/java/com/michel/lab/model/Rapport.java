package com.michel.lab.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Rapport {

	@Id
	@GeneratedValue
	private Integer id;

	private String titre;

	@ManyToOne
	private Utilisateur auteur;

	private LocalDateTime date;
	private String identifiant; // exemple : R10-15
	private Integer version;
	private String projet;
	private String demande;
	private String objet;
	private String avis;

	@OneToOne
	private RapportEnr rapportEng;

	@OneToMany(mappedBy = "rapport")
	private List<EchantillonAux> echantillonsAux;

	@ManyToOne
	private Qualification qualification;

	@OneToMany(mappedBy = "rapport")
	private List<Image> images;

	public Rapport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rapport(Integer id, String titre, Utilisateur auteur, LocalDateTime date, String identifiant,
			Integer version, String projet, String demande, String objet, String avis, RapportEnr rapportEng,
			List<EchantillonAux> echantillonsAux, Qualification qualification, List<Image> images) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.date = date;
		this.identifiant = identifiant;
		this.version = version;
		this.projet = projet;
		this.demande = demande;
		this.objet = objet;
		this.avis = avis;
		this.rapportEng = rapportEng;
		this.echantillonsAux = echantillonsAux;
		this.qualification = qualification;
		this.images = images;
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

	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getProjet() {
		return projet;
	}

	public void setProjet(String projet) {
		this.projet = projet;
	}

	public String getDemande() {
		return demande;
	}

	public void setDemande(String demande) {
		this.demande = demande;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public RapportEnr getRapportEng() {
		return rapportEng;
	}

	public void setRapportEng(RapportEnr rapportEng) {
		this.rapportEng = rapportEng;
	}

	public List<EchantillonAux> getEchantillonsAux() {
		return echantillonsAux;
	}

	public void setEchantillonsAux(List<EchantillonAux> echantillonsAux) {
		this.echantillonsAux = echantillonsAux;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}
