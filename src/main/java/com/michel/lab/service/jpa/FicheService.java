package com.michel.lab.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Fiche;
import com.michel.lab.repository.FicheRepo;
import com.michel.lab.service.IFicheService;

@Service
public class FicheService  implements IFicheService{@Autowired
	UserService userService;

	@Autowired
	FicheRepo ficheRepo;
	
	

	public void enregistrerFiche(Fiche fiche) {
		
		ficheRepo.save(fiche);
		
	}

}
