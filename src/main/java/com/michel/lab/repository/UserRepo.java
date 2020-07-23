package com.michel.lab.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.michel.lab.model.Utilisateur;

public interface UserRepo extends JpaRepository<Utilisateur, Integer> {
	

	Utilisateur findByEmail(String email);
	
	Utilisateur findByEmailAndPassword(String email,String password);
	
	@Query("select u from Utilisateur u where u.nom = ?1 or u.prenom = ?1")
	  Utilisateur findByIdentity(String nom);
	

	
}