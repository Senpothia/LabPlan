package com.michel.lab.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rapport {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String titre;
	private Utilisateur auteur;
	private LocalDateTime date;
	private String identifiant; // exemple : R10-15
	private Integer version;
	private List<Essai> essais;
	
	
	public Rapport() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Rapport(Integer id, String titre, Utilisateur auteur, LocalDateTime date, String identifiant, Integer version,
			List<Essai> essais) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.date = date;
		this.identifiant = identifiant;
		this.version = version;
		this.essais = essais;
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


	public List<Essai> getEssais() {
		return essais;
	}


	public void setEssais(List<Essai> essais) {
		this.essais = essais;
	}
	
	
	
	

}
