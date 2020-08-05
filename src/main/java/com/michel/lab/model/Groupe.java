package com.michel.lab.model;

public class Groupe {
	
	private Integer domaine;
	private Integer qualification;
	
	public Groupe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Groupe(Integer domaine, Integer qualification) {
		super();
		this.domaine = domaine;  				 // id du domaine
		this.qualification = qualification;   	// numéro de ma qualification
	}

	public Integer getDomaine() {
		return domaine;
	}

	public void setDomaine(Integer domaine) {
		this.domaine = domaine;
	}

	public Integer getQualification() {
		return qualification;
	}

	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}
	


}
