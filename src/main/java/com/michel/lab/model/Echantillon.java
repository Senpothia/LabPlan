package com.michel.lab.model;

import java.time.LocalDateTime;

public class Echantillon {
	
	private Integer id;
	private int numero;
	private LocalDateTime date;
	private int version;
	private String caracteristique;
	
	public Echantillon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Echantillon(Integer id, int numero, LocalDateTime date, int version, String caracteristique) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.version = version;
		this.caracteristique = caracteristique;
	}
	
	
	
	

}
