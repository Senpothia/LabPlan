package com.michel.lab.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EssaiData {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer essai; // identifiant de l'Essai associé à cette EssaiAux
	private Integer numero;
	private String nom;
	private String version;
	private String domaine;
	private String statut;
	private String resultat;
	
	@ManyToOne
	private Rapport rapport;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Rapport getRapport() {
		return rapport;
	}

	public void setRapport(Rapport rapport) {
		this.rapport = rapport;
	}

	@OneToMany(mappedBy = "essaiData")
	private List<SequenceData> sequences;

	public EssaiData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EssaiData(Integer essai, Integer numero, String nom, String version, String domaine, String statut,
			String resultat, List<SequenceData> sequences) {
		super();
		this.essai = essai;
		this.numero = numero;
		this.nom = nom;
		this.version = version;
		this.domaine = domaine;
		this.statut = statut;
		this.resultat = resultat;
		this.sequences = sequences;
	}

	public EssaiData(EssaiAux essaiAux) {

		super();
		this.essai = essaiAux.getId();
		this.numero = essaiAux.getNumero();
		this.nom = essaiAux.getNom();
		this.version = essaiAux.getVersion();
		this.domaine = essaiAux.getDomaine();
		this.statut = essaiAux.getStatut();
		this.resultat = essaiAux.getResultat();

		List<SequenceAux> listeSeqs = essaiAux.getSequences();
		List<SequenceData> listeSequences = new ArrayList<SequenceData>();
		for (SequenceAux s : listeSeqs) {

			SequenceData SeqData = new SequenceData(s);
			listeSequences.add(SeqData);

		}

		this.sequences = listeSequences;

	}

	public Integer getEssai() {
		return essai;
	}

	public void setEssai(Integer essai) {
		this.essai = essai;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDomaine() {
		return domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	public List<SequenceData> getSequences() {
		return sequences;
	}

	public void setSequences(List<SequenceData> sequences) {
		this.sequences = sequences;
	}

}
