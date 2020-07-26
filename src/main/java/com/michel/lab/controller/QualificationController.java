package com.michel.lab.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michel.lab.model.FormQualif;
import com.michel.lab.model.Qualification;
import com.michel.lab.service.jpa.QualificationService;
import com.michel.lab.service.jpa.UserService;

@RestController
@RequestMapping("/lab-service")
public class QualificationController {
	
	@Autowired
	QualificationService qualificationService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/save/qualification")
	public void saveQualification(@RequestBody FormQualif formQualif) {
		
		//System.out.println("entrée: /save/qualification");
		//System.out.println(formQualif.toString());
		
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

}
