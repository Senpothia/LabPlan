package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Defaut;
import com.michel.lab.repository.DefautRepo;
import com.michel.lab.service.IDefautService;


@Service
public class DefautService implements IDefautService{
	
	@Autowired
	DefautRepo defautRepo;

	@Override
	public Defaut obtenirDefautParId(Integer id) {
		
		Defaut defaut = defautRepo.getOne(id);
		return defaut;
	}

	@Override
	public void enregistrerDefaut(Defaut defaut) {
		
		defautRepo.save(defaut);
	}

	public List<Defaut> obtenirListeDefauts() {
		
		List<Defaut> defauts = defautRepo.findAll();
		return defauts;
	}

	public List<Defaut> obtenirDefautParProduit(String produit) {
		
		List<Defaut> defauts = defautRepo.findByProduit(produit);
		return defauts;
	}

	
	
	
	

}
