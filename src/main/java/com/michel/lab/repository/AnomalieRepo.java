package com.michel.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Anomalie;
import com.michel.lab.model.Defaut;

public interface AnomalieRepo extends JpaRepository<Anomalie, Integer>{

	List<Anomalie> findByProduit(String produit);

}
