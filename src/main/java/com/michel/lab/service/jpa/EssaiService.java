package com.michel.lab.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Essai;
import com.michel.lab.repository.EssaiRepo;
import com.michel.lab.repository.ProcedureRepo;
import com.michel.lab.service.IEssaiService;
import com.michel.lab.service.IProcedureService;

@Service
public class EssaiService  implements IEssaiService{
	
	
	@Autowired
	EssaiRepo essaiRepo;
	
	@Autowired
	ProcedureRepo userRepo;
	
	public void ajouterEssai(Essai essai) {
		
		essaiRepo.save(essai);
	}

	@Override
	public void ajouterEssai(Integer id, Integer qualification, Integer utilisateur) {
		// TODO Auto-generated method stub
		
	}

	public Essai obtenirParId(Integer idEssai) {
		
		Essai essai = essaiRepo.getOne(idEssai);
		return essai;
	}

	

}
