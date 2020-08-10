package com.michel.lab.model;

import java.time.LocalDateTime;
import java.util.List;

public class EchantillonAux {
	
	private Integer id;
	private Integer numero;
	private LocalDateTime date;
	private Integer version;
	private String caracteristique;    // Variantes pouvant distinguer les échantillons
	private String actif;			   // Lié à statut 
	private boolean statut;			  // lié à actif
	private boolean selection;         // indicateur de sélection/présence dans la sequence de test
	
	public EchantillonAux() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public EchantillonAux(Integer id, Integer numero, LocalDateTime date, Integer version, String caracteristique,
			String actif, boolean statut) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.version = version;
		this.caracteristique = caracteristique;
		this.actif = actif;
		this.statut = statut;
	}



	public EchantillonAux(Echantillon echantillon) {
		
		this.id = echantillon.getId();
		this.numero = echantillon.getNumero();
		this.date = echantillon.getDate();
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
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
		while (!ok) {
			
			Echantillon ech =  echantillons.get(i);
			Integer idEch = ech.getId();
			if (this.id == idEch) {
				
				ok= true;
			estSelectionne = true;
				
			}
			
			i++;
		}
		
		this.selection = estSelectionne;
	}


}
