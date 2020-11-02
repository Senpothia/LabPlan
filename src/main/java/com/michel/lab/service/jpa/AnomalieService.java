package com.michel.lab.service.jpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Anomalie;
import com.michel.lab.model.FormAnomalie;
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

	public void modifierAnomalie(FormAnomalie formAnomalie) {
		
		Integer id = formAnomalie.getId();
		Anomalie anomalie = anomalieRepo.getOne(id);
		anomalie.setCode(formAnomalie.getCode());
		anomalie.setDate(LocalDateTime.parse(formAnomalie.getDate()+ " " + "00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		anomalie.setDescription(formAnomalie.getDescription());
		anomalie.setNumero(formAnomalie.getNumero());
		anomalie.setProduit(formAnomalie.getProduit());
		anomalieRepo.save(anomalie);
	}

	public void supprimerAnomalie(Integer id) {
		
		Anomalie anomalie = anomalieRepo.getOne(id);
		anomalieRepo.delete(anomalie);
		
	}
	
	

}
