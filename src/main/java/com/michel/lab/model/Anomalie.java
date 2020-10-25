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
public class Anomalie {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	private String produit;
	private String code;
	private String description;
	
	
	@ManyToOne
	private Utilisateur controleur;
	
	@OneToMany(mappedBy="anomalie")
	private List<Repetition> repetitions;

	public Anomalie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Anomalie(Integer id, Integer numero, LocalDateTime date, String produit, String code, String description,
			Utilisateur controleur, List<Repetition> repetitions) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.produit = produit;
		this.code = code;
		this.description = description;
		this.controleur = controleur;
		this.repetitions = repetitions;
	}
	
	public Anomalie(FormAnomalie formAnomalie, Utilisateur controleur) {
		super();
		this.id = formAnomalie.getId();
		this.numero = formAnomalie.getNumero();
		this.date = LocalDateTime.parse(formAnomalie.getDate()+ " " + "00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.produit = formAnomalie.getProduit();
		this.code = formAnomalie.getCode();
		this.description = formAnomalie.getDescription();
		this.controleur = controleur;
		
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

	public Utilisateur getControleur() {
		return controleur;
	}

	public void setControleur(Utilisateur controleur) {
		this.controleur = controleur;
	}

	public List<Repetition> getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(List<Repetition> repetitions) {
		this.repetitions = repetitions;
	}
	
	

}
