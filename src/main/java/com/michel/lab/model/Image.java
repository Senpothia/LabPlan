package com.michel.lab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Image {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer numero;
	private String nom;
	private String legende;
	
	@ManyToOne
	private Rapport rapport;

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(Integer id, Integer numero, String nom, String legende, Rapport rapport) {
		super();
		this.id = id;
		this.numero = numero;
		this.nom = nom;
		this.legende = legende;
		this.rapport = rapport;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLegende() {
		return legende;
	}

	public void setLegende(String legende) {
		this.legende = legende;
	}

	public Rapport getRapport() {
		return rapport;
	}

	public void setRapport(Rapport rapport) {
		this.rapport = rapport;
	}
	

}
