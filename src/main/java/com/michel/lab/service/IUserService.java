package com.michel.lab.service;


import java.util.List;

import com.michel.lab.model.Utilisateur;

public interface IUserService {
	
	List<Utilisateur> listerUsers();
	Utilisateur obtenirUser(Integer id);
	Utilisateur obtenirUser(String string);
	Utilisateur obtenirUserParEmail(String email);
	void ajouterUser(Utilisateur user);
	void modifierUser(Utilisateur user);
	void supprimerUser(Utilisateur user);
	Utilisateur obtenirUserParlogin(String email, String password);
	
}