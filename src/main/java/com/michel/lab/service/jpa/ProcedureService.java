package com.michel.lab.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Procedure;
import com.michel.lab.repository.ProcedureRepo;
import com.michel.lab.repository.QualificationRepo;
import com.michel.lab.service.IProcedureService;

@Service
public class ProcedureService implements IProcedureService{

	@Autowired
	ProcedureRepo procedureRepo;
	
	@Override
	public void ajouterProcedure(Procedure procedure) {
		
		procedureRepo.save(procedure);
		
	}

	@Override
	public void modifierProcedure(Procedure procedure) {
		// TODO Auto-generated method stub
		
	}

}
