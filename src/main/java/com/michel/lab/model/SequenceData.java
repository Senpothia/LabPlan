package com.michel.lab.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SequenceData {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer sequence;    // identifiant de la Sequence associée à cette SequenceAux
	private String commentaire;
	private LocalDateTime debut;
	private String debutText;
	private LocalDateTime fin;
	private String finText;
	private long duree;
	private String niveau;
	private String nom;
	private Integer numero;  		// numéro de la séquence
	private String profil;
	private Integer essai;
	private String nomEssais;
	private Integer domaine;
	private String nomDomaine;
	private boolean statut;
	private String actif;
	private Integer qualification;  // numéro de la qualification
	private boolean resultat;
	private String avis;
	
	@ManyToOne
	private EssaiData essaiData;
	
	public SequenceData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SequenceData(Integer sequence, String commentaire, LocalDateTime debut, String debutText, LocalDateTime fin,
			String finText, long duree, String niveau, String nom, Integer numero, String profil, Integer essai,
			String nomEssais, Integer domaine, String nomDomaine, boolean statut, String actif, Integer qualification,
			boolean resultat, String avis) {
		super();
		this.sequence = sequence;
		this.commentaire = commentaire;
		this.debut = debut;
		this.debutText = debutText;
		this.fin = fin;
		this.finText = finText;
		this.duree = duree;
		this.niveau = niveau;
		this.nom = nom;
		this.numero = numero;
		this.profil = profil;
		this.essai = essai;
		this.nomEssais = nomEssais;
		this.domaine = domaine;
		this.nomDomaine = nomDomaine;
		this.statut = statut;
		this.actif = actif;
		this.qualification = qualification;
		this.resultat = resultat;
		this.avis = avis;
	} 
	
	public SequenceData(SequenceAux sequenceAux) {
		super();
		
		this.sequence = sequenceAux.getId();
		this.commentaire = sequenceAux.getCommentaire();
		this.debut = sequenceAux.getDebut();
		this.debutText = sequenceAux.getDebutText();
		this.fin = sequenceAux.getFin();
		this.finText = sequenceAux.getFinText();
		this.duree = sequenceAux.getDuree();
		this.niveau = sequenceAux.getNiveau();
		this.nom = sequenceAux.getNom();
		this.numero = sequenceAux.getNumero();
		this.profil = sequenceAux.getProfil();
		this.essai = sequenceAux.getEssai();
		this.nomEssais = sequenceAux.getNomEssais();
		this.domaine = sequenceAux.getDomaine();
		this.nomDomaine = sequenceAux.getNomDomaine();
		this.statut = sequenceAux.isStatut();
		this.actif = sequenceAux.getActif();
		this.qualification = sequenceAux.getQualification();
		this.resultat = sequenceAux.isResultat();
		this.avis = sequenceAux.getAvis();
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public LocalDateTime getDebut() {
		return debut;
	}

	public void setDebut(LocalDateTime debut) {
		this.debut = debut;
	}

	public String getDebutText() {
		return debutText;
	}

	public void setDebutText(String debutText) {
		this.debutText = debutText;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	public String getFinText() {
		return finText;
	}

	public void setFinText(String finText) {
		this.finText = finText;
	}

	public long getDuree() {
		return duree;
	}

	public void setDuree(long duree) {
		this.duree = duree;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public Integer getEssai() {
		return essai;
	}

	public void setEssai(Integer essai) {
		this.essai = essai;
	}

	public String getNomEssais() {
		return nomEssais;
	}

	public void setNomEssais(String nomEssais) {
		this.nomEssais = nomEssais;
	}

	public Integer getDomaine() {
		return domaine;
	}

	public void setDomaine(Integer domaine) {
		this.domaine = domaine;
	}

	public String getNomDomaine() {
		return nomDomaine;
	}

	public void setNomDomaine(String nomDomaine) {
		this.nomDomaine = nomDomaine;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public String getActif() {
		return actif;
	}

	public void setActif(String actif) {
		this.actif = actif;
	}

	public Integer getQualification() {
		return qualification;
	}

	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}

	public boolean isResultat() {
		return resultat;
	}

	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EssaiData getEssaiData() {
		return essaiData;
	}

	public void setEssaiData(EssaiData essaiData) {
		this.essaiData = essaiData;
	} 
	


}
