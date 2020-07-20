package com.michel.lab.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Qualification {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String produit;
	private String projet;
	private LocalDateTime date;
	private String objet;
	private boolean statut;  // Ouverte, cloturée
	private boolean resultat;
	
	
	@OneToMany(mappedBy="qualification")
	private List<Essai> essais = new ArrayList<Essai>();
	
	public Qualification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Qualification(Integer id, String produit, String projet, LocalDateTime date, String objet, boolean resultat,
			List<Essai> essais) {
		super();
		this.id = id;
		this.produit = produit;
		this.projet = projet;
		this.date = date;
		this.objet = objet;
		this.resultat = resultat;
		this.essais = essais;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public String getProjet() {
		return projet;
	}

	public void setProjet(String projet) {
		this.projet = projet;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public boolean isResultat() {
		return resultat;
	}

	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}

	public List<Essai> getEssais() {
		return essais;
	}

	public void setEssais(List<Essai> essais) {
		this.essais = essais;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	
	
	
}
