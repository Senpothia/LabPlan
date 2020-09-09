package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Demande;
import com.michel.lab.model.Fiche;

public interface DemandeRepo extends JpaRepository<Demande, Integer> {

}
