package com.michel.lab.service.jpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.FormInitRapport;
import com.michel.lab.model.Qualification;
import com.michel.lab.model.Rapport;
import com.michel.lab.model.RapportAux;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.repository.RapportRepo;
import com.michel.lab.service.IDomaineService;
import com.michel.lab.service.IRapportService;

@Service
public class RapportService implements IRapportService {
	
	@Autowired
	UserService userService;
	
	@Autowired
	QualificationService qualificationService;
	
	@Autowired
	RapportRepo rapportRepo;

	@Override
	public void enregistrerRapport(FormInitRapport formInitRapport) {
		
		Rapport rapport = new Rapport();
		Integer idAuteur = formInitRapport.getAuteur();
		
		Utilisateur auteur = userService.obtenirUser(idAuteur);
		
		rapport.setAuteur(auteur);
		rapport.setDemande(formInitRapport.getDemande());
		rapport.setIdentifiant(formInitRapport.getIdentifiant());
		rapport.setObjet(formInitRapport.getObjet());
		rapport.setProjet(formInitRapport.getProjet());
		rapport.setTitre(formInitRapport.getTitre());
		rapport.setVersion(formInitRapport.getVersion());
		
		Integer numQualification = formInitRapport.getQualification();
		Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
		
		rapport.setQualification(qualification);
		String date = formInitRapport.getDate() + " " + "00:00 AM";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
		
		LocalDateTime dateConvertie = LocalDateTime.parse(date, formatter);
		
		System.out.println("date convertie: " + dateConvertie);
		rapport.setDate(dateConvertie);
		
		rapportRepo.save(rapport);
		
	}

	public RapportAux obtenirRapportParId(Integer idRapport) {
		
		Rapport rap = rapportRepo.getOne(idRapport);
		RapportAux rapport = new RapportAux(rap);
		return rapport;
	}

}
