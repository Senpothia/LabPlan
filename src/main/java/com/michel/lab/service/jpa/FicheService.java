package com.michel.lab.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Fiche;
import com.michel.lab.model.FicheAux;
import com.michel.lab.model.Qualification;
import com.michel.lab.repository.FicheRepo;
import com.michel.lab.service.IFicheService;

@Service
public class FicheService implements IFicheService {
	@Autowired
	UserService userService;

	@Autowired
	FicheRepo ficheRepo;
	
	@Autowired
	QualificationService qualificationService;

	public void enregistrerFiche(Fiche fiche) {

		ficheRepo.save(fiche);

	}

	public List<FicheAux> voirLesFiches() {
		
	
		List<Fiche> fiches = ficheRepo.findAll();
		List<FicheAux> fichesAux = new ArrayList<FicheAux>();
		
		
		for (Fiche f : fiches) {

			FicheAux fAux = new FicheAux(f);
			fichesAux.add(fAux);

		}
		
		return fichesAux;
	}

	public List<Fiche> obtenirFicheParQualification(Integer numQualification) {
		
		Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
		List<Fiche> fiches = qualification.getFiches();
		return fiches;
	}

	public Fiche obtenirFicheParId(Integer id) {
		
		Fiche fiche = ficheRepo.getOne(id);
		
		return fiche;
	}

	public void supprimerFiche(Integer id) {
		
		Fiche fiche = ficheRepo.getOne(id);
		ficheRepo.delete(fiche);
		
	}

}
