package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.EchantillonAux;
import com.michel.lab.repository.EchantillonAuxRepo;
import com.michel.lab.repository.RapportAuxRepo;
import com.michel.lab.service.IEchantillonAuxService;

@Service
public class EchantillonAuxService implements IEchantillonAuxService {
	
	@Autowired
	EchantillonAuxRepo echantillonAuxRepo;


	public void enregistrerListeEchantillonAux(List<EchantillonAux> echantillons) {
		
		for (EchantillonAux e: echantillons) {
			
			echantillonAuxRepo.save(e);
		}
		
	}


	public void enregistrerEchantillonAux(EchantillonAux ech) {
		
		echantillonAuxRepo.save(ech);
		
	}

}
