package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Domaine;
import com.michel.lab.repository.DomaineRepo;
import com.michel.lab.repository.QualificationRepo;
import com.michel.lab.service.IDomaineService;
import com.michel.lab.service.IQualificationService;

@Service
public class DomaineService implements IDomaineService{

	@Autowired
	DomaineRepo domaineRepo;
	
	@Override
	public void ajouterDomaine(Domaine domaine) {
		
		List<Domaine> domaines = domaineRepo.findAll();
		for (Domaine dom : domaines) {
			
			if (dom.getNom().equals(domaine.getNom())) {
				
				System.out.println("Le domaine existe déjà");
				
			} else {
				
				domaineRepo.save(domaine);
			}
		}
		
	}

	@Override
	public void modifierDomaine(Domaine domaine) {
		
		domaineRepo.save(domaine);
		
	}

	public List<Domaine> obtenirDomaine(String nomDomaine) {
		
		List<Domaine> domaines = domaineRepo.findByNom(nomDomaine);
		return domaines;
	}

}
