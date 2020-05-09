package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Rapport;

public interface RapportRepo extends JpaRepository<Rapport, Integer> {

}
