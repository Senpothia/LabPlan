package com.michel.lab.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Anomalie {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	private String produit;
	private String code;
	private String description;
	
	
	@ManyToOne
	private Utilisateur controleur;
	
	@OneToMany(mappedBy="anomalie")
	private List<Repetition> repetitions;

}
