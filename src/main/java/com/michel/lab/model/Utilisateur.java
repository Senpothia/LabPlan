package com.michel.lab.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private String prenom;
	private String role;
	private String email;
	private String password;
	private boolean enabled;

	@OneToMany(mappedBy = "auteur")
	private List<Rapport> rapports;

	@OneToMany(mappedBy = "createur")
	private List<Qualification> qualifications;

	@OneToMany(mappedBy = "auteur")
	private List<Note> notes;

	@OneToMany(mappedBy = "auteur")
	private List<Fiche> fiches;
	
	@OneToMany(mappedBy = "demandeur")
	private List<Demande> demandes;
	
	@OneToMany(mappedBy = "commercial")
	private List<Defaut> defauts;
	
	@OneToMany(mappedBy = "commercial")
	private List<Site> sites;
	
	@OneToMany(mappedBy = "createur")
	private List<Of> ofs;
	
	@OneToMany(mappedBy = "controleur")
	private List<Anomalie> anomalies;

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Utilisateur(Integer id, String nom, String prenom, String role, String email, String password,
			boolean enabled, List<Rapport> rapports, List<Qualification> qualifications, List<Note> notes,
			List<Fiche> fiches, List<Demande> demandes, List<Defaut> defauts, List<Site> sites, List<Of> ofs,
			List<Anomalie> anomalies) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.rapports = rapports;
		this.qualifications = qualifications;
		this.notes = notes;
		this.fiches = fiches;
		this.demandes = demandes;
		this.defauts = defauts;
		this.sites = sites;
		this.ofs = ofs;
		this.anomalies = anomalies;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rapport> getRapports() {
		return rapports;
	}

	public void setRapports(List<Rapport> rapports) {
		this.rapports = rapports;
	}

	public String getUsername() {
		return email;
	}

	public void setUsername(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(List<Qualification> qualifications) {
		this.qualifications = qualifications;
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



	public List<Demande> getDemandes() {
		return demandes;
	}



	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}


	public List<Defaut> getDefauts() {
		return defauts;
	}


	public void setDefauts(List<Defaut> defauts) {
		this.defauts = defauts;
	}


	public List<Site> getSites() {
		return sites;
	}


	public void setSites(List<Site> sites) {
		this.sites = sites;
	}


	public List<Of> getOfs() {
		return ofs;
	}


	public void setOfs(List<Of> ofs) {
		this.ofs = ofs;
	}


	public List<Anomalie> getAnomalies() {
		return anomalies;
	}


	public void setAnomalies(List<Anomalie> anomalies) {
		this.anomalies = anomalies;
	}
	
	

}
