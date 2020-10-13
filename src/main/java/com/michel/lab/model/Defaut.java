package com.michel.lab.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Defaut {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	private String produit;
	private String code;
	private String description;
	
	
	@ManyToOne
	private Utilisateur commercial;
	
	@OneToMany(mappedBy="defaut")
	private List<Recurrence> recurrences;

	public Defaut() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Defaut(Integer id, Integer numero, LocalDateTime date, String produit, String code, String description,
			Utilisateur commercial, List<Recurrence> recurrences) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.produit = produit;
		this.code = code;
		this.description = description;
		this.commercial = commercial;
		this.recurrences = recurrences;
	}
	
	public Defaut(FormIncident formIncident, Utilisateur commercial) {
		super();
	
	
		this.date = LocalDateTime.parse(formIncident.getDate()+ " " + "00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.produit = formIncident.getProduit();
		this.code = formIncident.getCode() ;
		this.description = formIncident.getDescription();
		this.commercial = commercial;
		this.recurrences = null;
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
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
