package com.michel.lab.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.RapportAux;
import com.michel.lab.repository.RapportAuxRepo;
import com.michel.lab.service.IRapportAuxService;

@Service
public class RapportAuxService implements IRapportAuxService{
	
	@Autowired
	RapportAuxRepo rapportAuxRepo;


	public void enregistrerRapportAux(RapportAux rapportAux) {
		
		rapportAuxRepo.save(rapportAux);
		
		
	}

}
