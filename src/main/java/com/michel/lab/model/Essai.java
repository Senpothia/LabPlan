package com.michel.lab.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class Essai {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	private boolean statut;
	
	@ManyToOne
	private Procedure procedure;
	
	private boolean resultat;
	
	@ManyToOne
	private Utilisateur technicien;
	
	@ManyToOne
	private Qualification qualification;
	
	@OneToMany(mappedBy = "essai")
	private List<Sequence> sequences;
	
	public Essai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Essai(Integer id, Integer numero, LocalDateTime date, Procedure procedure, boolean resultat,
			Utilisateur technicien, Qualification qualification, List<Sequence> sequences) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.procedure = procedure;
		this.resultat = resultat;
		this.technicien = technicien;
		this.qualification = qualification;
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

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public boolean isResultat() {
		return resultat;
	}

	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}

	public Utilisateur getTechnicien() {
		return technicien;
	}

	public void setTechnicien(Utilisateur technicien) {
		this.technicien = technicien;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public List<Sequence> getSequences() {
		return sequences;
	}

	public void setSequences(List<Sequence> sequences) {
		this.sequences = sequences;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	
	
	

}
