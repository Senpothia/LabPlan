package com.michel.lab.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Qualification;
import com.michel.lab.model.QualificationAux;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.repository.QualificationRepo;
import com.michel.lab.service.IQualificationService;

@Service
public class QualificationService implements IQualificationService{
	
	@Autowired
	QualificationRepo qualificationRepo;
	
	@Autowired
	UserService userService;
	
	@Override
	public void ajouterQualification(Qualification qualification) {
		 
		qualificationRepo.save(qualification);
		
	}

	@Override
	public void modifierQualification(Qualification qualification) {
		
		qualificationRepo.save(qualification);
		
	}

	@Override
	public List<QualificationAux> tousLesQualifications() {
		
		List<Qualification> qualifications = qualificationRepo.findAll();
		List<QualificationAux> toutesLesQualifications = new ArrayList<QualificationAux>();
		
		for (Qualification qualif : qualifications) {
			
			QualificationAux qual = new QualificationAux(qualif);
			toutesLesQualifications.add(qual);
			
		}
		return toutesLesQualifications;
	}

	@Override
	public List<QualificationAux> mesQualifications(Integer id) {
		
		Utilisateur createur = userService.obtenirUser(id);
		List<Qualification> qualifications = qualificationRepo.findByCreateur(createur);
		List<QualificationAux> toutesLesQualifications = new ArrayList<QualificationAux>();
		
		for (Qualification qualif : qualifications) {
			
			QualificationAux qual = new QualificationAux(qualif);
			toutesLesQualifications.add(qual);
			
		}
		return toutesLesQualifications;
	}

	public List<QualificationAux> mesQualificationsEnCours(Integer id) {
	
		
		Utilisateur createur = userService.obtenirUser(id);
		List<Qualification> qualifications = qualificationRepo.findByCreateur(createur);
		List<QualificationAux> toutesLesQualifications = new ArrayList<QualificationAux>();
		
		for (Qualification qualif : qualifications) {
			
			boolean statut = qualif.isStatut();
			if (statut) {
				
				QualificationAux qual = new QualificationAux(qualif);
				toutesLesQualifications.add(qual);
				
			}
			
		}
		return toutesLesQualifications;
	}

	public QualificationAux obtenirQualification(Integer id) {
		
		QualificationAux qualification = qualificationRepo.findByNumero(id);
		return qualification;
	}
	
	

}
