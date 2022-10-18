package com.michel.lab.model;

import java.util.ArrayList;
import java.util.List;

public class EssaiAux implements Comparable<EssaiAux>{

	private Integer id; // identifiant de l'Essai associé à cette EssaiAux
	private Integer numero;
	private String nom;
	private String version;
	private String domaine;
	private String statut;
	private String resultat;
	private List<SequenceAux> sequences;

	public EssaiAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EssaiAux(Integer id, Integer numero, String nom, String version, String domaine, String statut,
			String resultat, List<SequenceAux> sequences) {
		super();
		this.id = id;
		this.numero = numero;
		this.nom = nom;
		this.version = version;
		this.domaine = domaine;
		this.statut = statut;
		this.resultat = resultat;
		this.sequences = sequences;
	}

	public EssaiAux(Essai essai) {

		this.id = essai.getId();
		this.numero = essai.getNumero();
		this.nom = essai.getProcedure().getNom();
		this.version = essai.getProcedure().getVersion();
		this.domaine = essai.getProcedure().getDomaine().getNom();

		if (essai.isStatut()) {

			this.statut = "En cours";
			this.resultat = "En cours";

		} else {

			this.statut = "Terminé";

			if (essai.isResultat()) {

				this.resultat = "Conforme";

			} else {

				this.resultat = "Non conforme";
			}
		}

		List<Sequence> seqs = essai.getSequences();

		List<SequenceAux> sequencesAux = new ArrayList<SequenceAux>();

		for (Sequence s : seqs) {

			SequenceAux seqAux = new SequenceAux(s);
			sequencesAux.add(seqAux);

		}

		this.sequences = sequencesAux;

	}

	public EssaiAux(EssaiData es) {

		this.id = es.getEssai();
		this.numero = es.getNumero();
		this.nom = es.getNom();
		this.version = es.getVersion();
		this.domaine = es.getDomaine();
		this.statut = es.getStatut();
		this.resultat = es.getResultat();
		
		List<SequenceData> seqsData = es.getSequences();
		List<SequenceAux> seqsAux = new ArrayList<SequenceAux>();
		
		for(SequenceData s: seqsData) {
			
			SequenceAux seqAux = new SequenceAux(s);
			seqsAux.add(seqAux);
			
		}
		
		this.sequences = seqsAux;

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

	public List<SequenceAux> getSequences() {
		return sequences;
	}

	public void setSequences(List<SequenceAux> sequences) {
		this.sequences = sequences;
	}

	@Override
	public int compareTo(EssaiAux o) {
		
		return (this.numero - o.numero);
		
	}

}
