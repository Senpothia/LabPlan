package com.michel.lab.model;

public class Upload {
	
	private Integer id;
	private String image;
	private String avis;

	public Upload() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Upload(String image, String avis) {
		super();
		this.image = image;
		this.avis = avis;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	

}
