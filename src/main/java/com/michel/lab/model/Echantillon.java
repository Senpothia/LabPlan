package com.michel.lab.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;




@Entity
public class Echantillon {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	private Integer version;
	private String caracteristique;
	
	
	
	public Echantillon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Echantillon(Integer id, Integer numero, LocalDateTime date, Integer version, String caracteristique) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.version = version;
		this.caracteristique = caracteristique;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(String caracteristique) {
		this.caracteristique = caracteristique;
	}
	
	
	
	

}
