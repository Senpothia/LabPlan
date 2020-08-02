package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Procedure;
import com.michel.lab.model.ProcedureAux;
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

	public List<Procedure> obtenirProcedures() {
		 
		List<Procedure> procedures =  procedureRepo.findAll();
		return procedures;
	}
	
	public List<Procedure> obtenirProceduresDuDomaine(Integer id) {
		
		List<Procedure> procedures = procedureRepo.findByDomaineId(id);
		return procedures;
	}

}
