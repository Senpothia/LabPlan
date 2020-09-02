package com.michel.lab.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Domaine;
import com.michel.lab.model.FormProcedure;
import com.michel.lab.model.Procedure;
import com.michel.lab.model.ProcedureAux;
import com.michel.lab.repository.DomaineRepo;
import com.michel.lab.repository.ProcedureRepo;
import com.michel.lab.repository.QualificationRepo;
import com.michel.lab.service.IProcedureService;

@Service
public class ProcedureService implements IProcedureService{

	@Autowired
	ProcedureRepo procedureRepo;
	
	@Autowired
	DomaineService domaineService;
	
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

	public Procedure obtenirProcedure(Integer id) {
		
		Procedure procedure = procedureRepo.getOne(id);
		return procedure;
	}

	public List<Procedure> obtenirProceduresParQualifPourDomaine(Integer id) {
		
		
		return null;
	}

	public List<ProcedureAux> obtenirProceduresParDomaine(String domaine) {
		
		Domaine domaineReel = domaineService.obtenirDomaineParNom(domaine);
		List<Procedure> procedures = domaineReel.getProcedures();
		List<ProcedureAux> listeProcedures = new ArrayList<ProcedureAux>();
		for(Procedure p: procedures) {
			
			ProcedureAux proAux = new ProcedureAux(p);
			listeProcedures.add(proAux);
			
		}
		return listeProcedures;
	}

	public void modifierProcedure(FormProcedure formProcedure) {
		
		Procedure procedure = procedureRepo.getOne(formProcedure.getId());
		procedure.setNom(formProcedure.getNom());
		procedure.setReferentiel(formProcedure.getReferentiel());
		procedure.setVersion(formProcedure.getVersion());
		procedureRepo.save(procedure);
		
	}

}
