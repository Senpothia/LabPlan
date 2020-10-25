package com.michel.lab.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormAnomalie {

	private Integer id;
	private Integer numero;
	private String date;
	private String produit;
	private String code;
	private String description;
	private Integer controleur;

	public FormAnomalie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormAnomalie(Integer id, Integer numero, String date, String produit, String code, String description,
			Integer controleur) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.produit = produit;
		this.code = code;
		this.description = description;
		this.controleur = controleur;
	}

	public FormAnomalie(Anomalie anomalie) {
		super();
		this.id = anomalie.getId();
		this.numero = anomalie.getNumero();
		this.date = anomalie.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		this.produit = anomalie.getProduit();
		this.code = anomalie.getCode();
		this.description = anomalie.getDescription();
		this.controleur = anomalie.getControleur().getId();
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getControleur() {
		return controleur;
	}

	public void setControleur(Integer controleur) {
		this.controleur = controleur;
	}

}