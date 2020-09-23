package com.michel.lab.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Echantillon {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	private Integer version;
	private String caracteristique;    // Variantes pouvant distinguer les échantillons
	private boolean actif;
	
	@ManyToMany(mappedBy = "echantillons")
	private List<Sequence> sequences;
	
	@ManyToOne
	private Qualification qualification;
	
	public Echantillon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Echantillon(Integer id, Integer numero, LocalDateTime date, Integer version, String caracteristique,
			boolean actif, List<Sequence> sequences) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.version = version;
		this.caracteristique = caracteristique;
		this.actif = actif;
		this.sequences = sequences;
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

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public List<Sequence> getSequences() {
		return sequences;
	}

	public void setSequences(List<Sequence> sequences) {
		this.sequences = sequences;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	

}
