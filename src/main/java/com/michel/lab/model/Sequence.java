package com.michel.lab.model;

import java.time.LocalDateTime;

public class Sequence {
	
	private Integer id;
	private String nom;
	private LocalDateTime debut;
	private LocalDateTime fin;
	private int numero;
	private String profil; // profil de test, conditions
	private String niveau;  // exemple: 1kV; 40°c, etc...
	private String commentaire;  // observation faite en cours d'essai
	private boolean resultat; 
	private Essai essai;
	private Echantillon echantillon;
	
	
	public Sequence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sequence(Integer id, String nom, LocalDateTime debut, LocalDateTime fin, int numero, String profil,
			String niveau, String commentaire, boolean resultat, Essai essai, Echantillon echantillon) {
		super();
		this.id = id;
		this.nom = nom;
		this.debut = debut;
		this.fin = fin;
		this.numero = numero;
		this.profil = profil;
		this.niveau = niveau;
		this.commentaire = commentaire;
		this.resultat = resultat;
		this.essai = essai;
		this.echantillon = echantillon;
	}
	
	
}
