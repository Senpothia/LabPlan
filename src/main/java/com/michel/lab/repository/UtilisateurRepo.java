package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Utilisateur;

public interface UtilisateurRepo extends JpaRepository<Utilisateur, Integer> {

}
