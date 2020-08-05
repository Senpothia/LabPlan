package com.michel.lab.service.jpa;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Echantillon;
import com.michel.lab.model.FormEchantillon;
import com.michel.lab.model.Qualification;
import com.michel.lab.repository.EchantillonRepo;
import com.michel.lab.service.IEchantillonService;

@Service
public class EchantillonService implements IEchantillonService{
	
	@Autowired
	EchantillonRepo echantillonRepo;

	@Override
	public void enregistrerEchantillon(FormEchantillon formEchantillon) {
		
		Echantillon echantillon = new Echantillon();
		echantillon.setActif(true);
		echantillon.setCaracteristique(formEchantillon.getCaracteristique());
		echantillon.setDate(LocalDateTime.now());
		echantillon.setNumero(formEchantillon.getNumero());
		echantillon.setVersion(formEchantillon.getVersion());
		
		echantillonRepo.save(echantillon);
		
	}

	

}
