package com.michel.lab.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Site {
	
	@Id
	private Integer id;
	private String nom;
	private Integer numero;
	private String voie;
	private String ville;
	private Integer codePostal;
	private String secteur;
	private Integer departement;
	private String region;
	
	@ManyToOne
	private Utilisateur commercial;
	
	@OneToMany(mappedBy="site")
	private List<Recurrence> recurrences;

	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Site(Integer id, String nom, Integer numero, String voie, String ville, Integer codePostal, String secteur,
			Integer departement, String region, Utilisateur commercial, List<Recurrence> recurrences) {
		super();
		this.id = id;
		this.nom = nom;
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.codePostal = codePostal;
		this.secteur = secteur;
		this.departement = departement;
		this.region = region;
		this.commercial = commercial;
		this.recurrences = recurrences;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		this.voie = voie;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public Integer getDepartement() {
		return departement;
	}

	public void setDepartement(Integer departement) {
		this.departement = departement;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Utilisateur getCommercial() {
		return commercial;
	}

	public void setCommercial(Utilisateur commercial) {
		this.commercial = commercial;
	}

	public List<Recurrence> getRecurrences() {
		return recurrences;
	}

	public void setRecurrences(List<Recurrence> recurrences) {
		this.recurrences = recurrences;
	}
	
	

	

}
