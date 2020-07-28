package com.michel.lab.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Qualification;
import com.michel.lab.repository.QualificationRepo;
import com.michel.lab.service.IQualificationService;

@Service
public class QualificationService implements IQualificationService{
	
	@Autowired
	QualificationRepo qualificationRepo;
	
	@Override
	public void ajouterQualification(Qualification qualification) {
		 
		qualificationRepo.save(qualification);
		
	}

	@Override
	public void modifierQualification(Qualification qualification) {
		
		qualificationRepo.save(qualification);
		
	}
	
	

}
