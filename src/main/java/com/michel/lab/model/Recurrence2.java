package com.michel.lab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Recurrence2 {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	private Integer site;
	
	private Integer defaut;
	
	private Integer total;    // nombre de défaut recenser sur un site  (recurrence du défaut par site)

	public Recurrence2() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Recurrence2(Integer id, Integer site, Integer defaut, Integer total) {
		super();
		this.id = id;
		this.site = site;
		this.defaut = defaut;
		this.total = total;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getSite() {
		return site;
	}



	public void setSite(Integer site) {
		this.site = site;
	}



	public Integer getDefaut() {
		return defaut;
	}



	public void setDefaut(Integer defaut) {
		this.defaut = defaut;
	}



	public Integer getTotal() {
		return total;
	}



	public void setTotal(Integer total) {
		this.total = total;
	}

}
