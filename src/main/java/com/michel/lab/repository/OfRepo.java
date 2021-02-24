package com.michel.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Defaut;
import com.michel.lab.model.FormOf;
import com.michel.lab.model.Of;

public interface OfRepo extends JpaRepository<Of, Integer> {

	void save(FormOf formOf);

	List<Of> findByProduit(String produit);

}
