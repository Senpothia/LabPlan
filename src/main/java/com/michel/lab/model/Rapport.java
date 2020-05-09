package com.michel.lab.model;

import java.time.LocalDateTime;
import java.util.List;

public class Rapport {
	
	private Integer id;
	private String titre;
	private Utilisateur auteur;
	private LocalDateTime date;
	private String identifiant; // exemple : R10-15
	private int version;
	private List<Essai> essais;
	
	
	public Rapport() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Rapport(Integer id, String titre, Utilisateur auteur, LocalDateTime date, String identifiant, int version,
			List<Essai> essais) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.date = date;
		this.identifiant = identifiant;
		this.version = version;
		this.essais = essais;
	}
	
	
	
	

}
