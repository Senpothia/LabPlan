package com.michel.lab.service.jpa;

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
	
	

}
