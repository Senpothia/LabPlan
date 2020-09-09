package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Fiche;

public interface FicheRepo extends JpaRepository<Fiche, Integer> {

}
