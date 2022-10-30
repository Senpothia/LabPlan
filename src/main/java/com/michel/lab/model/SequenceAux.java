package com.michel.lab.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SequenceAux {

	private Integer id; // identifiant de la Sequence associée à cette SequenceAux
	private String commentaire;
	private LocalDateTime debut;
	private String debutText;
	private LocalDateTime fin;
	private String finText;
	private long duree;
	private String dureeText;
	private String niveau;
	private String nom;
	private Integer numero; // numéro de la séquence
	private String profil;
	private Integer essai;
	private String nomEssais;
	private Integer domaine;
	private String nomDomaine;
	private boolean statut;
	private String actif;
	private Integer qualification; // numéro de la qualification
	private boolean resultat;
	private String avis; // ex: conforme, non conforme

	public SequenceAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SequenceAux(Integer id, String commentaire, LocalDateTime debut, String debutText, LocalDateTime fin,
			String finText, long duree, String dureeText, String niveau, String nom, Integer numero, String profil,
			Integer essai, String nomEssais, Integer domaine, String nomDomaine, boolean statut, String actif,
			Integer qualification, boolean resultat, String avis) {
		super();
		this.id = id;
		this.commentaire = commentaire;
		this.debut = debut;
		this.debutText = debutText;
		this.fin = fin;
		this.finText = finText;
		this.duree = duree;
		this.dureeText = dureeText;
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

	public SequenceAux(Sequence sequence) {

		this.id = sequence.getId();
		this.commentaire = sequence.getCommentaire();
		this.debut = sequence.getDebut();
		this.debutText = sequence.getDebut().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.fin = sequence.getFin();
		this.finText = sequence.getFin().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.niveau = sequence.getNiveau();
		this.nom = sequence.getNom();
		this.numero = sequence.getNumero();
		this.profil = sequence.getProfil();
		this.essai = sequence.getEssai().getId();
		this.nomEssais = sequence.getEssai().getProcedure().getNom();
		this.domaine = sequence.getEssai().getProcedure().getDomaine().getId();
		this.nomDomaine = sequence.getEssai().getProcedure().getDomaine().getNom();
		this.dureeText = getDureeText(sequence);
		this.statut = sequence.isStatut();

		if (sequence.isStatut()) {

			this.actif = "En cours";
			this.avis = "En cours";

		} else {

			this.actif = "Terminée";
		}

		this.qualification = sequence.getEssai().getQualification().getId();

		this.resultat = sequence.isResultat();

		if (this.resultat && !sequence.isStatut()) {

			this.avis = "Conforme";

		}

		if (!this.resultat && !sequence.isStatut()) {

			this.avis = "Non conforme";
		}

	}

	private String getDureeText(Sequence sequence) {

		Duration duration = Duration.between(sequence.getDebut(), sequence.getFin());
		long duree = duration.toHours();
		long minutes = duration.toMinutes();
		long minutesRestantes = 0;
		try {
			minutesRestantes = minutes % duree * 60;
			String intercalaire = "";
			if (minutesRestantes < 10) {
				intercalaire = "0";
			}

			String dureeText = Long.toString(duree) + ":" + intercalaire + Long.toString(minutesRestantes);

			return dureeText;

		} catch (Exception e) {

			return "00:" + minutes;

		}

	}

	public SequenceAux(SequenceData s) {

		this.id = s.getSequence();
		this.commentaire = s.getCommentaire();
		this.debut = s.getDebut();
		this.debutText = s.getDebutText();
		this.fin = s.getFin();
		this.finText = s.getFinText();
		this.duree = s.getDuree();
		this.niveau = s.getNiveau();
		this.nom = s.getNom();
		this.numero = s.getNumero();
		this.profil = s.getProfil();
		this.essai = s.getEssai();
		this.nomEssais = s.getNomEssais();
		this.domaine = s.getDomaine();
		this.nomDomaine = s.getNomDomaine();
		this.statut = s.isStatut();
		this.actif = s.getActif();
		this.qualification = s.getQualification();
		this.resultat = s.isResultat();
		this.avis = s.getAvis();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
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

	public String getDebutText() {
		return debutText;
	}

	public void setDebutText(String debutText) {
		this.debutText = debutText;
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

	public String getDureeText() {
		return dureeText;
	}

	public void setDureeText(String dureeText) {
		this.dureeText = dureeText;
	}

}