package com.michel.lab.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Of {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private String produit;
	private String code;
	private LocalDateTime date;
	private Integer taille;
	
	@ManyToOne
	private Utilisateur createur;

	public Of() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Of(Integer id, Integer numero, String produit, String code, LocalDateTime date, Integer taille,
			Utilisateur createur) {
		super();
		this.id = id;
		this.numero = numero;
		this.produit = produit;
		this.code = code;
		this.date = date;
		this.taille = taille;
		this.createur = createur;
	}
	
	
	public Of(FormOf formOf, Utilisateur createur) {
		super();
		this.id = formOf.getId();
		this.numero = formOf.getNumero();
		this.produit = formOf.getProduit();
		this.code = formOf.getCode();
		this.date = LocalDateTime.parse(formOf.getDate()+ " " + "00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.taille = formOf.getTaille();
		this.createur = createur;
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getTaille() {
		return taille;
	}

	public void setTaille(Integer taille) {
		this.taille = taille;
	}

	public Utilisateur getCreateur() {
		return createur;
	}

	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}
	

}
