package com.michel.lab.service;

import java.util.List;

import com.michel.lab.model.Qualification;
import com.michel.lab.model.QualificationAux;
import com.michel.lab.model.Utilisateur;

public interface IQualificationService {
	
	void ajouterQualification(Qualification qualification);
	void modifierQualification(Qualification qualification);
	List<QualificationAux> tousLesQualifications();
	List<QualificationAux> mesQualifications(Integer id);


}
