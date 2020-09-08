package com.michel.lab.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Qualification {

	@Id
	@GeneratedValue
	private Integer id;
	private Integer numero;
	private String reference;
	private String produit;
	private String projet;
	private LocalDateTime date;
	private String objet;
	private boolean statut; // Ouverte, cloturée
	private boolean resultat;

	@OneToMany(mappedBy = "qualification")
	private List<Rapport> rapports;

	@OneToMany(mappedBy = "qualification")
	private List<Note> notes;

	@ManyToOne
	private Utilisateur createur;

	@OneToMany(mappedBy = "qualification")
	private List<Essai> essais = new ArrayList<Essai>();

	@OneToMany(mappedBy = "qualification")
	private List<Echantillon> echantillons;

	@OneToMany(mappedBy = "qualification")
	private List<Fiche> fiches;
	
	public Qualification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Qualification(Integer id, Integer numero, String reference, String produit, String projet,
			LocalDateTime date, String objet, boolean statut, boolean resultat, List<Rapport> rapports,
			List<Note> notes, Utilisateur createur, List<Essai> essais, List<Echantillon> echantillons,
			List<Fiche> fiches) {
		super();
		this.id = id;
		this.numero = numero;
		this.reference = reference;
		this.produit = produit;
		this.projet = projet;
		this.date = date;
		this.objet = objet;
		this.statut = statut;
		this.resultat = resultat;
		this.rapports = rapports;
		this.notes = notes;
		this.createur = createur;
		this.essais = essais;
		this.echantillons = echantillons;
		this.fiches = fiches;
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

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public boolean isResultat() {
		return resultat;
	}

	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}

	public Utilisateur getCreateur() {
		return createur;
	}

	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}

	public List<Essai> getEssais() {
		return essais;
	}

	public void setEssais(List<Essai> essais) {
		this.essais = essais;
	}

	public List<Echantillon> getEchantillons() {
		return echantillons;
	}

	public void setEchantillons(List<Echantillon> echantillons) {
		this.echantillons = echantillons;
	}

	public List<Rapport> getRapports() {
		return rapports;
	}

	public void setRapports(List<Rapport> rapports) {
		this.rapports = rapports;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Fiche> getFiches() {
		return fiches;
	}

	public void setFiches(List<Fiche> fiches) {
		this.fiches = fiches;
	}

}
