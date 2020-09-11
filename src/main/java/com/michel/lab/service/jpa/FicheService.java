package com.michel.lab.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Fiche;
import com.michel.lab.model.FicheAux;
import com.michel.lab.repository.FicheRepo;
import com.michel.lab.service.IFicheService;

@Service
public class FicheService implements IFicheService {
	@Autowired
	UserService userService;

	@Autowired
	FicheRepo ficheRepo;

	public void enregistrerFiche(Fiche fiche) {

		ficheRepo.save(fiche);

	}

	public List<FicheAux> voirLesFiches() {
		
		System.out.println("recherche liste des fiches");
		List<Fiche> fiches = ficheRepo.findAll();
		List<FicheAux> fichesAux = new ArrayList<FicheAux>();
		
		
		for (Fiche f : fiches) {

			FicheAux fAux = new FicheAux(f);
			fichesAux.add(fAux);

		}
		
		return fichesAux;
	}

}
