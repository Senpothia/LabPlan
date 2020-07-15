package com.michel.lab.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Essai {
	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private LocalDateTime date;
	private Integer numero;
	private String procedure;
	private boolean resultat;
	
	private Utilisateur technicien;
	
	@ManyToOne
	private Qualification qualification;
	
	@ManyToOne
	private Echantillon echantillon;
	
	public Essai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Essai(Integer id, String nom, LocalDateTime date, Integer numero, String procedure, boolean resultat,
			Qualification qualification, Utilisateur technicien) {
		super();
		this.id = id;
		this.nom = nom;
		this.date = date;
		this.numero = numero;
		this.procedure = procedure;
		this.resultat = resultat;
		this.qualification = qualification;
		this.technicien = technicien;
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public boolean isResultat() {
		return resultat;
	}

	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public Utilisateur getTechnicien() {
		return technicien;
	}

	public void setTechnicien(Utilisateur technicien) {
		this.technicien = technicien;
	}
	
	
	
	
	
	

}
