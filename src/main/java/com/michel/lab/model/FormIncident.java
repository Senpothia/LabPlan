package com.michel.lab.model;

import java.time.format.DateTimeFormatter;

public class FormIncident {

	private Integer id;
	private Integer commercial;
	private String date;
	private String produit;
	private String code;
	private String description;
	private Integer recurrence;
	private Integer site;

	public FormIncident() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public FormIncident(Integer id, Integer commercial, String date, String produit, String code, String description,
			Integer recurrence, Integer site) {
		super();
		this.id = id;
		this.commercial = commercial;
		this.date = date;
		this.produit = produit;
		this.code = code;
		this.description = description;
		this.recurrence = recurrence;
		this.site = site;
	}



	public FormIncident(Defaut defaut) {

		this.id = defaut.getId();
		this.commercial = defaut.getCommercial().getId();
		this.date = defaut.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		this.produit = defaut.getProduit();
		this.code = defaut.getCode();
		this.description = defaut.getDescription();
		this.recurrence = 0;
		this.site = null;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCommercial() {
		return commercial;
	}

	public void setCommercial(Integer commercial) {
		this.commercial = commercial;
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

	public Integer getRecurrence() {
		return recurrence;
	}

	public void setRecurrence(Integer recurrence) {
		this.recurrence = recurrence;
	}



	public Integer getSite() {
		return site;
	}



	public void setSite(Integer site) {
		this.site = site;
	}
	
	

}
