package com.michel.lab.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michel.lab.model.Domaine;
import com.michel.lab.model.FormProcedure;
import com.michel.lab.model.FormQualif;
import com.michel.lab.model.Procedure;
import com.michel.lab.model.Qualification;
import com.michel.lab.repository.ProcedureRepo;
import com.michel.lab.service.jpa.DomaineService;
import com.michel.lab.service.jpa.ProcedureService;
import com.michel.lab.service.jpa.QualificationService;
import com.michel.lab.service.jpa.UserService;

@RestController
@RequestMapping("/lab-service")
public class QualificationController {
	
	@Autowired
	QualificationService qualificationService;
	
	@Autowired
	ProcedureService procedureService;
	
	@Autowired
	DomaineService domaineService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/save/qualification")
	public void saveQualification(@RequestBody FormQualif formQualif) {
		
		Qualification qualification = new Qualification();
		qualification.setProjet(formQualif.getProjet());
		qualification.setProduit(formQualif.getProduit());
		qualification.setObjet(formQualif.getObjet());
		qualification.setStatut(true);
		qualification.setResultat(false);
		qualification.setDate(LocalDateTime.now());
		qualification.setCreateur(userService.obtenirUser(formQualif.getCreateurId()));
		qualificationService.ajouterQualification(qualification);
		
	}
	
	@PostMapping("/save/procedure")
	public void saveProcedure(@RequestBody FormProcedure formProcedure) {
		
		Procedure procedure = new Procedure();
		procedure.setNom(formProcedure.getNom());
		procedure.setReferentiel(formProcedure.getReferentiel());
		procedure.setVersion(formProcedure.getVersion());
		
		String nomDomaine = formProcedure.getDomaine();
		
		System.out.println("nom du domaine récupéré: " + nomDomaine);
		
		
		List<Domaine> domaines = domaineService.obtenirDomaine(nomDomaine);
		if (domaines.isEmpty()) {
			
			System.out.println("Liste domaines vides");
			Domaine domaine = new Domaine();
			domaine.setNom(formProcedure.getNom());
			procedure.setDomaine(domaine);
			domaineService.ajouterDomaine(domaine);
			procedureService.ajouterProcedure(procedure);
			
			
		}else {
			
			System.out.println("taille domaines: " + domaines.size());
			System.out.println("nom domaine: " + domaines.get(0).getNom());
			Domaine domaine = new Domaine();
			domaine.setNom(domaines.get(0).getNom());
			procedure.setDomaine(domaines.get(0));
			//domaineService.ajouterDomaine(domaine);
			procedureService.ajouterProcedure(procedure);
			
		}
		
	}
	
	@GetMapping("/private/domaines")       // récupération de la liste des domaines
	public List<String> tousLesDomaines(){
		
		List<String> nomsDomaines = domaineService.tousLesNomsDomaines();
		
		return nomsDomaines;
	}

}
