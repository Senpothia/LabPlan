package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Echantillon;

public interface EchantillonRepo extends JpaRepository<Echantillon, Integer> {

}
