package com.michel.lab.service.jpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Echantillon;
import com.michel.lab.model.FormEchantillon;
import com.michel.lab.model.Qualification;
import com.michel.lab.repository.EchantillonRepo;
import com.michel.lab.repository.QualificationRepo;
import com.michel.lab.service.IEchantillonService;

@Service
public class EchantillonService implements IEchantillonService{
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Autowired
	EchantillonRepo echantillonRepo;
	
	@Autowired
	QualificationRepo qualificationRepo;

	@Override
	public void enregistrerEchantillon(FormEchantillon formEchantillon) {
		
		Qualification qualification = qualificationRepo.findByNumero(formEchantillon.getQualification());
	    System.out.println("numero qualification enregistrement ech: " + qualification.getId());
		Echantillon echantillon = new Echantillon();
		echantillon.setActif(true);
		echantillon.setCaracteristique(formEchantillon.getCaracteristique());
		echantillon.setDate(LocalDateTime.now());
		echantillon.setNumero(formEchantillon.getNumero());
		echantillon.setVersion(formEchantillon.getVersion());
		echantillon.setQualification(qualification);
	
		echantillonRepo.save(echantillon);
		
	}

	public List<Echantillon> obtenirEchantillonParQualification(Integer id) {
		
		Qualification qualification = qualificationRepo.findByNumero(id);
		List<Echantillon> echantillons = qualification.getEchantillons();
		return echantillons;
		
	}

	public void setActif(Integer id, boolean actif) {
		
		Echantillon echantillon = echantillonRepo.getOne(id);
		echantillon.setActif(actif);
		echantillonRepo.save(echantillon);
		
	}

	public Echantillon obtenirEchantillonParId(Integer id) {
		
		Echantillon echantillon = echantillonRepo.getOne(id);
		
		return echantillon;
	}

	public void modifierEchantillon(Echantillon echantillon) {
		
		echantillonRepo.save(echantillon);
		
	}

	

}
