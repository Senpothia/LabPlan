package com.michel.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Domaine;
import com.michel.lab.model.Echantillon;

public interface DomaineRepo extends JpaRepository<Domaine, Integer>{

	List<Domaine> findByNom(String nom);
	List<Domaine> findAll();
}
