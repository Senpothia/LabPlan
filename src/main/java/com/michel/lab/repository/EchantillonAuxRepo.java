package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.EchantillonAux;
import com.michel.lab.model.Qualification;

public interface EchantillonAuxRepo extends JpaRepository<EchantillonAux, Integer>{

}
