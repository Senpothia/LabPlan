package com.michel.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Essai;
import com.michel.lab.model.EssaiAux;
import com.michel.lab.model.Rapport;
import com.michel.lab.model.RapportAux;

public interface EssaiAuxRepo extends JpaRepository<EssaiAux, Integer>{


	

}
