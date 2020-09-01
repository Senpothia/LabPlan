package com.michel.lab.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NoteAux {

	private Integer id;
	private Integer numero;
	private String date;
	private String texte;

	private String auteur;
	private Integer qualification;
	private boolean active;

	public NoteAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public NoteAux(Integer id, Integer numero, String date, String texte, String auteur, Integer qualification,
			boolean active) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.texte = texte;
		this.auteur = auteur;
		this.qualification = qualification;
		this.active = active;
	}




	public NoteAux(Note note) {
		super();
		this.id = note.getId();
		this.numero = note.getNumero();	
		this.date = note.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		this.texte = note.getTexte();
		this.auteur = note.getAuteur().getPrenom() + " " + note.getAuteur().getNom();
		this.active = note.isActive();
		this.qualification = note.getQualification().getNumero();
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

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}




	public Integer getQualification() {
		return qualification;
	}




	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}
	
	

}
