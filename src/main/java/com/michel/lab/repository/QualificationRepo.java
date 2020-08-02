package com.michel.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Qualification;
import com.michel.lab.model.QualificationAux;
import com.michel.lab.model.Utilisateur;

public interface QualificationRepo extends JpaRepository<Qualification, Integer> {
	
	
	List<Qualification> findByCreateur(Utilisateur createur);

	QualificationAux findByNumero(Integer id);
	

}
