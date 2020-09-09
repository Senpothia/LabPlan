package com.michel.lab.service.jpa;

import java.util.List;

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
		
		Demande demande = demandeRepo.getOne(id);
		return demande;
	}

	public void enregistrerDemande(Demande demande) {
		
		demandeRepo.save(demande);
		
	}

	public List<Demande> obtenirListeDemandes() {
		
		List<Demande> demandes = demandeRepo.findAll();
		return demandes;
		
	}

	public void supprimerDemande(Integer id) {
		Demande demande = demandeRepo.getOne(id);
		demandeRepo.delete(demande);
		
	}
	
	

}
