package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Domaine;
import com.michel.lab.model.EchantillonData;

public interface EchantillonDataRepo extends JpaRepository<EchantillonData, Integer>{

}
