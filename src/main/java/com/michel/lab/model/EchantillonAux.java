package com.michel.lab.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EchantillonAux {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer idEchantillon;
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
	//private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	@ManyToOne
	private Rapport rapport;
	
	public EchantillonAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public EchantillonAux(Integer id, Integer idEchantillon, Integer numero, String date, String dateText,
			Integer version, String caracteristique, String actif, boolean statut, Integer qualification,
			boolean selection, Rapport rapport) {
		super();
		this.id = id;
		this.idEchantillon = idEchantillon;
		this.numero = numero;
		this.date = date;
		this.dateText = dateText;
		this.version = version;
		this.caracteristique = caracteristique;
		this.actif = actif;
		this.statut = statut;
		this.qualification = qualification;
		this.selection = selection;
		this.rapport = rapport;
	}




	public EchantillonAux(Echantillon echantillon) {
		
		this.idEchantillon = echantillon.getId();
		this.numero = echantillon.getNumero();
		this.date = echantillon.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		this.version = echantillon.getVersion();
		this.caracteristique = echantillon.getCaracteristique();
		
		if (echantillon.isActif()) {
			
			this.actif = "Actif";
			this.statut = true;
			
		}else {
			
			this.actif = "Inactif";
			this.statut = false;
		}
		
	}

	public Integer getId() {
		return idEchantillon;
	}

	public void setId(Integer id) {
		this.idEchantillon = id;
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
			if (this.idEchantillon == idEch) {
				
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


	public Integer getIdEchantillon() {
		return idEchantillon;
	}


	public void setIdEchantillon(Integer idEchantillon) {
		this.idEchantillon = idEchantillon;
	}




	public Rapport getRapport() {
		return rapport;
	}




	public void setRapport(Rapport rapport) {
		this.rapport = rapport;
	}

/*
	public DateTimeFormatter getFormatter() {
		return formatter;
	}



	public void setFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

*/
	

}
