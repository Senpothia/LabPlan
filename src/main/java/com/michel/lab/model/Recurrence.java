package com.michel.lab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Recurrence {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Site site;
	
	@ManyToOne
	private Defaut defaut;
	
	private Integer total;    // nombre de défaut recenser sur un site  (recurrence du défaut par site)

	public Recurrence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recurrence(Integer id, Site site, Defaut defaut, Integer total) {
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

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Defaut getDefaut() {
		return defaut;
	}

	public void setDefaut(Defaut defaut) {
		this.defaut = defaut;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	

}
