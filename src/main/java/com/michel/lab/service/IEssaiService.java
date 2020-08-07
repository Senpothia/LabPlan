package com.michel.lab.service;

import com.michel.lab.model.Essai;

public interface IEssaiService {
	
	void ajouterEssai(Integer id, Integer qualification, Integer utilisateur);
	
	Essai obtenirEssaiParId(Integer id);

}
