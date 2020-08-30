package com.michel.lab.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EchantillonAux {
	
	private Integer id;   // identifiant de l'Echantillon associé
	private Integer numero;
	//private LocalDateTime date;
	private String date;
	private String dateText;
	private Integer version;
	private String caracteristique;    // Variantes pouvant distinguer les échantillons
	private String actif;			   // Lié à statut 
	private boolean statut;			  // lié à actif
	private Integer qualification;
	private boolean selection;         // indicateur de sélection/présence dans la sequence de test
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public EchantillonAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public EchantillonAux(Integer id, Integer numero, String date, String dateText, Integer version,
			String caracteristique, String actif, boolean statut, Integer qualification, boolean selection) {
		super();
		this.id = id;
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


	public EchantillonAux(Echantillon echantillon) {
		
		this.id = echantillon.getId();
		this.numero = echantillon.getNumero();
		this.date = echantillon.getDate().format(formatter);
		this.version = echantillon.getVersion();
		this.caracteristique = echantillon.getCaracteristique();
		
		if (echantillon.isActif()) {
			
			this.actif = "Actif";
			this.statut = true;
			
		}else {
			
			this.actif = "Inactif";
			this.statut = false;
		}
		
		this.qualification = echantillon.getQualification().getId();
	}

	public EchantillonAux(EchantillonData e) {
		
		this.id = e.getEchantillon();
		this.numero = e.getNumero();
		this.date = e.getDate();
		this.dateText = e.getDateText();
		this.version = e.getVersion();
		this.caracteristique = e.getCaracteristique();
		this.actif = e.getActif();
		this.statut = e.isStatut();
		this.qualification = e.getQualification();
		this.selection = e.isSelection();
		
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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



	public boolean isSelection() {
		return selection;
	}



	public void setSelection(boolean selection) {
		this.selection = selection;
	}


	public void setSelection(List<Echantillon> echantillons) {
		
		boolean ok = false;
		boolean estSelectionne = false;
		int i = 0;
		while (!ok && i<echantillons.size()) {
			
			Echantillon ech =  echantillons.get(i);
			Integer idEch = ech.getId();
			if (this.id == idEch) {
				
				ok = true;
				estSelectionne = true;
				
			}
			
			i++;
		}
		
		this.selection = estSelectionne;
	}



	public Integer getQualification() {
		return qualification;
	}



	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}

	public String getDateText() {
		return dateText;
	}


	public void setDateText(String dateText) {
		this.dateText = dateText;
	}


}
