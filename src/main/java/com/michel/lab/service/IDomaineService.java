package com.michel.lab.service;

import java.util.List;

import com.michel.lab.model.Domaine;
import com.michel.lab.model.Qualification;

public interface IDomaineService {
	
	void ajouterDomaine(Domaine domaine);
	void modifierDomaine(Domaine domaine);
	List<Domaine> TousLesDomaines();
	List<String> tousLesNomsDomaines();


}
