package com.michel.lab.model;

import java.time.LocalDateTime;

public class Essai {
	
	private Integer id;
	private String nom;
	private LocalDateTime date;
	private int numero;
	private String procedure;
	private boolean resultat;
	private Qualification qualification;
	private Utilisateur technicien;
	
	public Essai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Essai(Integer id, String nom, LocalDateTime date, int numero, String procedure, boolean resultat,
			Qualification qualification, Utilisateur technicien) {
		super();
		this.id = id;
		this.nom = nom;
		this.date = date;
		this.numero = numero;
		this.procedure = procedure;
		this.resultat = resultat;
		this.qualification = qualification;
		this.technicien = technicien;
	}
	
	
	
	
	
	

}
