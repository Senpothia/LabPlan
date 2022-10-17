package com.michel.lab.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michel.lab.model.Demande;
import com.michel.lab.model.DemandeAux;
import com.michel.lab.model.FormDemande;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.service.jpa.DemandeService;
import com.michel.lab.service.jpa.UserService;
import com.zaxxer.hikari.metrics.micrometer.MicrometerMetricsTracker;

@RestController
@RequestMapping("/private/demande")
public class DemandeController {

	@Autowired
	UserService userService;

	@Autowired
	DemandeService demandeService;

	@PostMapping("/enregistrer")
	public void enregistrerDemande(@RequestBody FormDemande formDemande) {

		Demande demande = new Demande();
		demande.setNumero(formDemande.getNumero());
		demande.setDate(LocalDateTime.parse(formDemande.getDate()+ " " + "00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		demande.setEchantillon(formDemande.getEchantillon());
		demande.setEssai(formDemande.getEssai());
		demande.setObjectif(formDemande.getObjectif());
		demande.setOrigine(formDemande.getOrigine());
		demande.setProduit(formDemande.getProduit());
		demande.setUrgence(formDemande.getUrgence());
		demande.setCode(formDemande.getCode());
		demande.setAuxiliaire(formDemande.getAuxiliaire());
		demande.setStatut(false);  // demande est ouverte
		demande.setAttente(true);  // demande en attente de traitement

		Integer demandeur = formDemande.getDemandeur();

		Utilisateur utilisateur = userService.obtenirUser(demandeur);
		demande.setDemandeur(utilisateur);
		
		demandeService.enregistrerDemande(demande);

	}

	@GetMapping("/liste")
	public List<DemandeAux> listeDemandes() {

		List<Demande> demandes = demandeService.obtenirListeDemandes();
		List<DemandeAux> demandesAux = new ArrayList<DemandeAux>();
		for (Demande d : demandes) {

			DemandeAux demAux = new DemandeAux(d);
			demandesAux.add(demAux);
		}
		return demandesAux;
	}

	@GetMapping("/voir/{id}")
	public DemandeAux voirDemande(@PathVariable(name = "id") Integer id) {

		Demande demande = demandeService.obtenirDemandeParId(id);
		DemandeAux demAux = new DemandeAux(demande);
		
		return demAux;

	}

	@GetMapping("/supprimer/{id}")
	public void supprimerDemande(@PathVariable(name = "id") Integer id) {

		demandeService.supprimerDemande(id);
	}

	@PostMapping("/modifier")
	public void modifierDemande(@RequestBody FormDemande formDemande) {

		Integer id = formDemande.getId();
		
		
		Demande demande = demandeService.obtenirDemandeParId(id);

		demande.setNumero(formDemande.getNumero());
		// demande.setDate(formDemande.getDate());
		demande.setEchantillon(formDemande.getEchantillon());
		demande.setEssai(formDemande.getEssai());
		demande.setObjectif(formDemande.getObjectif());
		demande.setOrigine(formDemande.getOrigine());
		demande.setProduit(formDemande.getProduit());
		
		demande.setCode(formDemande.getCode());
		demande.setAuxiliaire(formDemande.getAuxiliaire());
		demande.setUrgence(formDemande.getUrgence());

		Integer demandeur = formDemande.getDemandeur();

		Utilisateur utilisateur = userService.obtenirUser(demandeur);
		demande.setDemandeur(utilisateur);

		demandeService.enregistrerDemande(demande);

	}
	
	@PostMapping("/reponse/enregistrer")
	public void enregistrerReponse(@RequestBody FormDemande formDemande) {
		
		Integer id = formDemande.getId();
	
		
		Demande demande = demandeService.obtenirDemandeParId(id);
		demande.setAvis(formDemande.getAvis());
		demande.setObservation(formDemande.getObservation());
		demande.setReponse(LocalDateTime.parse(formDemande.getDateReponse()+ " " + "00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		Utilisateur technicien = userService.obtenirUser(formDemande.getTechnicien());
		demande.setTechnicien(technicien);
		demande.setStatut(true);
		demande.setRapport(formDemande.getRapport());
		demande.setAttente(false);
		demandeService.enregistrerDemande(demande);
		
	}
	
	@GetMapping("/traiter/{id}")
	public void traiterDemande(@PathVariable(name = "id") Integer id) {
		
		Demande demande = demandeService.obtenirDemandeParId(id);
		demande.setAttente(false);
		
		demandeService.enregistrerDemande(demande);
		
	}
	
	

}
