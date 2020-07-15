package com.michel.lab.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sequence {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private LocalDateTime debut;
	private LocalDateTime fin;
	private Integer numero;    // Dans la qualification en cours
	private String profil; // profil de test, conditions: 12V, Charge=10 Ohms,...
	private String niveau;  // exemple: 1kV; 40°c, etc...
	private String commentaire;  // observation faite en cours d'essai
	private boolean resultat; 
	private Essai essai;
	private Echantillon echantillon;
	
	
	public Sequence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sequence(Integer id, String nom, LocalDateTime debut, LocalDateTime fin, Integer numero, String profil,
			String niveau, String commentaire, boolean resultat, Essai essai, Echantillon echantillon) {
		super();
		this.id = id;
		this.nom = nom;
		this.debut = debut;
		this.fin = fin;
		this.numero = numero;
		this.profil = profil;
		this.niveau = niveau;
		this.commentaire = commentaire;
		this.resultat = resultat;
		this.essai = essai;
		this.echantillon = echantillon;
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

	public LocalDateTime getDebut() {
		return debut;
	}

	public void setDebut(LocalDateTime debut) {
		this.debut = debut;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public boolean isResultat() {
		return resultat;
	}

	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}

	public Essai getEssai() {
		return essai;
	}

	public void setEssai(Essai essai) {
		this.essai = essai;
	}

	public Echantillon getEchantillon() {
		return echantillon;
	}

	public void setEchantillon(Echantillon echantillon) {
		this.echantillon = echantillon;
	}
	
	
	
}
