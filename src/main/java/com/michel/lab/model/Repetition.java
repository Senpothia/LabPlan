package com.michel.lab.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Repetition {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Of of;
	
	@ManyToOne
	private Defaut anomalie;
	
	private Integer total;    // nombre de défaut recenser sur un of  (recurrence du défaut par of)

	public Repetition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Repetition(Integer id, Of of, Defaut anomalie, Integer total) {
		super();
		this.id = id;
		this.of = of;
		this.anomalie = anomalie;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Of getOf() {
		return of;
	}

	public void setOf(Of of) {
		this.of = of;
	}

	public Defaut getAnomalie() {
		return anomalie;
	}

	public void setAnomalie(Defaut anomalie) {
		this.anomalie = anomalie;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}


	
}
