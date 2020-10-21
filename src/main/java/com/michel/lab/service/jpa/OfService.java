package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.FormOf;
import com.michel.lab.model.Of;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.repository.OfRepo;
import com.michel.lab.service.IOfService;

@Service
public class OfService  implements IOfService{
	
	@Autowired
	OfRepo ofRepo;
	
	@Autowired
	UserService userService;

	public void enregistrerOf(FormOf formOf) {
		
		Integer idUser = formOf.getCreateur();
		Utilisateur createur = userService.obtenirUser(idUser);
		Of of = new Of(formOf, createur);
		ofRepo.save(of);
		
	}

	public List<Of> listeDesOfs() {
		
		List<Of> ofs = ofRepo.findAll();
		
		return ofs;
	}

	public Of obtenirOfParId(Integer id) {
		
		Of of = ofRepo.getOne(id);
		return of;
	}

}
