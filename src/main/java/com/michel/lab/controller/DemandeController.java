package com.michel.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michel.lab.model.Demande;
import com.michel.lab.model.FormDemande;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.service.jpa.DemandeService;
import com.michel.lab.service.jpa.UserService;

@RestController
@RequestMapping("/lab-service/private/demande")
public class DemandeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	DemandeService demandeService;
	
	@PostMapping("/enregistrer")
	public void enregistrerDemande(@RequestBody FormDemande formDemande) {
		
		Demande demande = new Demande();
		demande.setNumero(formDemande.getNumero());
	//	demande.setDate(formDemande.getDate());
		demande.setEchantillon(formDemande.getEchantillon());
		demande.setEssai(formDemande.getEssai());
		demande.setObjectif(formDemande.getObjectif());
		demande.setOrigine(formDemande.getOrigine());
		demande.setProduit(formDemande.getProduit());
		
		Integer demandeur = formDemande.getDemandeur();
		System.out.println("id demandeur: " + demandeur);
		Utilisateur utilisateur = userService.obtenirUser(demandeur);
		demande.setDemandeur(utilisateur);
		
		demandeService.enregistrerDemande(demande);
		
		
	}

}
