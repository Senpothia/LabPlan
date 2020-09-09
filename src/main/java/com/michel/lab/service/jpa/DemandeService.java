package com.michel.lab.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Demande;
import com.michel.lab.repository.DemandeRepo;
import com.michel.lab.service.IDemandeService;

@Service
public class DemandeService implements IDemandeService{
	
	@Autowired
	DemandeRepo demandeRepo;
	
	@Override
	public Demande obtenirDemandeParId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void enregistrerDemande(Demande demande) {
		
		demandeRepo.save(demande);
		
	}
	
	

}
