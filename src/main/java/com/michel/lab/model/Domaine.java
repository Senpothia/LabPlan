package com.michel.lab.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Domaine {
	

	@Id
	@GeneratedValue
	private Integer id;
	
	private String nom;
	
	@OneToMany(mappedBy = "domaine")
	private List<Procedure> procedures;

	public Domaine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Domaine(Integer id, String nom, List<Procedure> procedures) {
		super();
		this.id = id;
		this.nom = nom;
		this.procedures = procedures;
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

	public List<Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}

	



}
