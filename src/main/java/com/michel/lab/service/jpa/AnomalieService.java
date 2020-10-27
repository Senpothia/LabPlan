package com.michel.lab.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Anomalie;
import com.michel.lab.repository.AnomalieRepo;
import com.michel.lab.service.IAnomalieService;

@Service
public class AnomalieService implements IAnomalieService {
	
	@Autowired
	AnomalieRepo anomalieRepo;

	public void enregistrerAnomalie(Anomalie anomalie) {
		
		anomalieRepo.save(anomalie);
		
	}

	public List<Anomalie> obtenirListeAnomalies() {
		
		List<Anomalie> anomalies = anomalieRepo.findAll();
		
		return anomalies;
	}

	public Anomalie obtenirAnomalieParId(Integer id) {
		
		Anomalie anomalie = anomalieRepo.getOne(id);
		return anomalie;
	}

	public List<String> obtenirListeProduits() {
		List<Anomalie> anomalies = anomalieRepo.findAll();
		
		List<String> produits = new ArrayList<String>();
		for(Anomalie a : anomalies) {
			
			String p = a.getProduit();
			produits.add(p);
			
		}
		return produits;
	}

	public List<Anomalie> obtenirListeAnomalieProduit(String produit) {
		
		List<Anomalie> anomalies = anomalieRepo.findByProduit(produit);
		return anomalies;
	}
	
	

}
