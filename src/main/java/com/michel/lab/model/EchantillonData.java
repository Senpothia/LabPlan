package com.michel.lab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EchantillonData {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer echantillon;   // identifiant de l'Echantillon associé
	private Integer numero;
	//private LocalDateTime date;
	private String date;
	private String dateText;
	private Integer version;
	private String caracteristique;    // Variantes pouvant distinguer les échantillons
	private String actif;			   // Lié à statut 
	private boolean statut;			  // lié à actif
	private Integer qualification;
	private boolean selection;
	
	@ManyToOne
	private Rapport rapport;
	
	public EchantillonData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EchantillonData(Integer id, Integer echantillon, Integer numero, String date, String dateText,
			Integer version, String caracteristique, String actif, boolean statut, Integer qualification,
			boolean selection) {
		super();
		
		this.id = id;
		this.echantillon = echantillon;
		this.numero = numero;
		this.date = date;
		this.dateText = dateText;
		this.version = version;
		this.caracteristique = caracteristique;
		this.actif = actif;
		this.statut = statut;
		this.qualification = qualification;
		this.selection = selection;
		
	}
	
	public EchantillonData(EchantillonAux echantillonAux) {
		
		super();
		this.echantillon = echantillonAux.getId();
		this.numero = echantillonAux.getNumero();
		this.date = echantillonAux.getDate();
		this.dateText = echantillonAux.getDateText();
		this.version = echantillonAux.getVersion();
		this.caracteristique = echantillonAux.getCaracteristique();
		this.actif = echantillonAux.getActif();
		this.statut = echantillonAux.isStatut();
		this.qualification = echantillonAux.getQualification();
		this.selection = echantillonAux.isSelection();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEchantillon() {
		return echantillon;
	}

	public void setEchantillon(Integer echantillon) {
		this.echantillon = echantillon;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDateText() {
		return dateText;
	}

	public void setDateText(String dateText) {
		this.dateText = dateText;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(String caracteristique) {
		this.caracteristique = caracteristique;
	}

	public String getActif() {
		return actif;
	}

	public void setActif(String actif) {
		this.actif = actif;
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	public Integer getQualification() {
		return qualification;
	}

	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}

	public boolean isSelection() {
		return selection;
	}

	public void setSelection(boolean selection) {
		this.selection = selection;
	}

	public Rapport getRapport() {
		return rapport;
	}

	public void setRapport(Rapport rapport) {
		this.rapport = rapport;
	}
	
	
	

}



