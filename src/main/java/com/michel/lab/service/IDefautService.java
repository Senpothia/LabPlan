package com.michel.lab.service;

import com.michel.lab.model.Defaut;


public interface IDefautService {
	
	Defaut obtenirDefautParId(Integer id);
	
	void enregistrerDefaut(Defaut defaut);

}
