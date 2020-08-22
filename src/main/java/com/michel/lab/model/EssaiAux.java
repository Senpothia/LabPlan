package com.michel.lab.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EssaiAux {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer idEssai;
	private Integer numero;
	private String nom;
	private String version;
	private String domaine;
	private String statut;
	private String resultat;
	
	@ManyToOne
	private RapportAux rapportAux;
	
	@OneToMany(mappedBy = "essaiAux")
	private List<SequenceAux> sequencesAux; 
	
	
	public EssaiAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public EssaiAux(Integer id, Integer idEssai, Integer numero, String nom, String version, String domaine,
			String statut, String resultat, RapportAux rapportAux, List<SequenceAux> sequencesAux) {
		super();
		this.id = id;
		this.idEssai = idEssai;
		this.numero = numero;
		this.nom = nom;
		this.version = version;
		this.domaine = domaine;
		this.statut = statut;
		this.resultat = resultat;
		this.rapportAux = rapportAux;
		this.sequencesAux = sequencesAux;
	}


	public EssaiAux(Essai essai){
		
		this.idEssai = essai.getId();
		this.numero = essai.getNumero();
		this.nom = essai.getProcedure().getNom();
		this.version = essai.getProcedure().getVersion();
		this.domaine = essai.getProcedure().getDomaine().getNom();
		
		if (essai.isStatut()) {
			
			this.statut = "En cours";
			this.resultat = "En cours";
			
		}else {
			
			this.statut = "Terminé";
			
			if (essai.isResultat()) {
				
				this.resultat = "Conforme";
				
			}else {
				
				this.resultat = "Non conforme";
			}
		}
		
		List<Sequence> seqs = essai.getSequences();
		
		List<SequenceAux> sequencesAux = new ArrayList<SequenceAux>();
		
		for(Sequence s: seqs) {
			
			SequenceAux seqAux = new SequenceAux(s);
			sequencesAux.add(seqAux);
			
		}
		
		this.sequencesAux = sequencesAux;
		
	}


	public Integer getId() {
		return idEssai;
	}



	public void setId(Integer id) {
		this.idEssai = id;
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
		return sequencesAux;
	}


	public void setSequences(List<SequenceAux> sequences) {
		this.sequencesAux = sequences;
	}


	public Integer getIdEssai() {
		return idEssai;
	}


	public void setIdEssai(Integer idEssai) {
		this.idEssai = idEssai;
	}


	public RapportAux getRapportAux() {
		return rapportAux;
	}


	public void setRapportAux(RapportAux rapportAux) {
		this.rapportAux = rapportAux;
	}


	public List<SequenceAux> getSequencesAux() {
		return sequencesAux;
	}


	public void setSequencesAux(List<SequenceAux> sequencesAux) {
		this.sequencesAux = sequencesAux;
	}


}
