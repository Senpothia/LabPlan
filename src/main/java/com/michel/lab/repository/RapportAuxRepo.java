package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Qualification;
import com.michel.lab.model.Rapport;
import com.michel.lab.model.RapportAux;

public interface RapportAuxRepo extends JpaRepository<RapportAux, Integer>{

	RapportAux findByVersion(Integer version);


}
