package com.michel.lab.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michel.lab.model.Fiche;
import com.michel.lab.model.FicheAux;
import com.michel.lab.model.FormFiche;
import com.michel.lab.model.Qualification;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.service.jpa.DemandeService;
import com.michel.lab.service.jpa.FicheService;
import com.michel.lab.service.jpa.QualificationService;
import com.michel.lab.service.jpa.UserService;

@RestController
@RequestMapping("/lab-service/private/fiche")
public class FicheController {
	
	@Autowired
	UserService userService;

	@Autowired
	FicheService ficheService;
	
	@Autowired
	QualificationService qualificationService;
	
	@PostMapping("/enregistrer")
	public void enregistrerFiche(@RequestBody FormFiche formFiche) {
		
		Fiche fiche = new Fiche();
		Utilisateur auteur = userService.obtenirUser(formFiche.getAuteur());
		fiche.setAuteur(auteur);
		fiche.setDate(LocalDateTime.parse(formFiche.getDate()+ " " + "00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		fiche.setCirconstance(formFiche.getCirconstance());
		fiche.setService(formFiche.getService());
		fiche.setDocument(formFiche.getDocument());
		fiche.setDegre(formFiche.getDegre());
		fiche.setCode(formFiche.getCode());
		fiche.setDomaine(formFiche.getDomaine());
		fiche.setIncidence(formFiche.getIncidence());
		fiche.setNiveau(formFiche.getNiveau());
		fiche.setNumero(formFiche.getNumero());
		fiche.setDegre(formFiche.getDegre());
		fiche.setObjet(formFiche.getObjet());
		fiche.setObservation(formFiche.getObservation());
		fiche.setProjet(formFiche.getProjet());
		fiche.setProduit(formFiche.getProduit());
		fiche.setSolution(formFiche.getSolution());
		fiche.setReponse(formFiche.getReponse());
		fiche.setStatut(true); 
		Integer idQualification = formFiche.getQualification();
		if(idQualification != null) {
			
			Qualification qualification = qualificationService.obtenirQualificationParIdentifiant(idQualification);
			fiche.setQualification(qualification);
		}
			
		ficheService.enregistrerFiche(fiche);
	
	}
	
	@GetMapping("/voir")
	public List<FicheAux> voirLesFiches(){
		System.out.println("recherche fiches");
		List<FicheAux> fiches = ficheService.voirLesFiches();
		System.out.println("taille liste des fiches: " + fiches.size());
		return fiches;
	}
	
	@GetMapping("/qualification/{id}")
	public List<FicheAux> voirLesFichesParQualification(
			@PathVariable(name = "id") Integer numQualification){
		
		List<Fiche> fiches = ficheService.obtenirFicheParQualification(numQualification);
		List<FicheAux> listeFiches = new ArrayList<FicheAux>();
		for(Fiche f: fiches) {
			
			FicheAux fAux = new FicheAux(f);
			listeFiches.add(fAux);
		}
		return listeFiches;
	}
	
	@PostMapping("/qualification/ajouter")
	public void ajouterFiche(@RequestBody FormFiche formFiche) {
		
		Fiche fiche = new Fiche();
		Utilisateur auteur = userService.obtenirUser(formFiche.getAuteur());
		fiche.setAuteur(auteur);
		fiche.setCirconstance(formFiche.getCirconstance());
		fiche.setCode(formFiche.getCode());
		fiche.setDomaine(formFiche.getDomaine());
		fiche.setIncidence(formFiche.getIncidence());
		fiche.setNiveau(formFiche.getNiveau());
		fiche.setNumero(formFiche.getNumero());
		fiche.setObjet(formFiche.getObjet());
		fiche.setObservation(formFiche.getObservation());
		fiche.setProjet(formFiche.getProjet());
		fiche.setSolution(formFiche.getSolution());
		fiche.setReponse(formFiche.getReponse());
		fiche.setStatut(true); 
		Integer numQualification = formFiche.getQualification();
		if(numQualification != null) {
			
			Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
			fiche.setQualification(qualification);
		}
			
		ficheService.enregistrerFiche(fiche);

	}
	
	@GetMapping("/voir/{id}")
	public FicheAux voirLaFiches(@PathVariable(name = "id") Integer id) {
		
		Fiche fiche = ficheService.obtenirFicheParId(id);
		FicheAux ficheAux = new FicheAux(fiche);
		
		return ficheAux;
		
	}
	
	@GetMapping("/supprimer/{id}")
	public void supprimerLaFiches(@PathVariable(name = "id") Integer id) {
		
		ficheService.supprimerFiche(id);
		
	}
	
	@PostMapping("/modifier")
	public void modifierLaFiche(@RequestBody FormFiche formFiche) {
		
		Integer id = formFiche.getId();
		System.out.println("Valeur id fiche: " + id);
		Fiche fiche = ficheService.obtenirFicheParId(id);
		System.out.println("Auteur: " + formFiche.getAuteur());
		Utilisateur auteur = userService.obtenirUser(formFiche.getAuteur());
		fiche.setAuteur(auteur);
		fiche.setCirconstance(formFiche.getCirconstance());
		fiche.setCode(formFiche.getCode());
		fiche.setDomaine(formFiche.getDomaine());
		fiche.setIncidence(formFiche.getIncidence());
		fiche.setNiveau(formFiche.getNiveau());
		fiche.setNumero(formFiche.getNumero());
		fiche.setObjet(formFiche.getObjet());
		fiche.setObservation(formFiche.getObservation());
		fiche.setProjet(formFiche.getProjet());
		fiche.setSolution(formFiche.getSolution());
		fiche.setReponse(formFiche.getReponse());
		fiche.setStatut(true); 
		Integer numQualification = formFiche.getQualification();
		System.out.println("Qualification id: " + formFiche.getQualification());
		if(numQualification != null) {
			
			Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
			fiche.setQualification(qualification);
		}
			
		ficheService.enregistrerFiche(fiche);

		
	}

}
