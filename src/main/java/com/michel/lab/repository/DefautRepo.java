package com.michel.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Defaut;


public interface DefautRepo extends JpaRepository<Defaut, Integer> {

	List<Defaut> findByProduit(String produit);



}
