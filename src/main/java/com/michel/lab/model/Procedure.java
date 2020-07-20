package com.michel.lab.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Procedure {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nom;   // nom de l'essai: ESD, Ondes de choc
	private String referentiel;  // EN 61000-4-5
	private String version;      // 2015, V1.8.1
	
	@OneToMany(mappedBy = "procedure")
	private List<Essai> essais;
	
	
	public Procedure() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Procedure(Integer id, String nom, String referentiel, String version, List<Essai> essais) {
		super();
		this.id = id;
		this.nom = nom;
		this.referentiel = referentiel;
		this.version = version;
		this.essais = essais;
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


	public String getReferentiel() {
		return referentiel;
	}


	public void setReferentiel(String referentiel) {
		this.referentiel = referentiel;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public List<Essai> getEssais() {
		return essais;
	}


	public void setEssais(List<Essai> essais) {
		this.essais = essais;
	}


	

}
