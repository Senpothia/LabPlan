package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.EssaiAux;
import com.michel.lab.model.Rapport;
import com.michel.lab.model.RapportAux;
import com.michel.lab.repository.EssaiAuxRepo;
import com.michel.lab.repository.RapportRepo;
import com.michel.lab.service.IEssaiAuxService;
import com.michel.lab.service.IEssaiService;

@Service
public class EssaiAuxService implements IEssaiAuxService{
	
	@Autowired
	EssaiAuxRepo essaiAuxRepo;

	public void enregistrerEssaiAux(EssaiAux e) {

		essaiAuxRepo.save(e);
		
	}

	public void supprimerEssaiAux(EssaiAux e) {

		essaiAuxRepo.delete(e);
		
	}

	public List<EssaiAux> obtenirEssaisParIndex(Integer index) {
		 List<EssaiAux> essais = essaiAuxRepo.findByIndex(index);
		
		return essais;
	}

	

}
