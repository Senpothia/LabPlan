package com.michel.lab.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michel.lab.model.Domaine;
import com.michel.lab.model.DomaineAux;
import com.michel.lab.model.FormProcedure;
import com.michel.lab.model.FormQualif;
import com.michel.lab.model.Procedure;
import com.michel.lab.model.ProcedureAux;
import com.michel.lab.model.Qualification;
import com.michel.lab.model.QualificationAux;
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
		qualification.setNumero(formQualif.getNumero());
		qualification.setReference(formQualif.getReference());
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
			domaine.setNom(formProcedure.getDomaine());
			procedure.setDomaine(domaine);
			domaineService.ajouterDomaine(domaine);
			procedureService.ajouterProcedure(procedure);

		} else {

			System.out.println("taille domaines: " + domaines.size());
			System.out.println("nom domaine: " + domaines.get(0).getNom());
			Domaine domaine = new Domaine();
			domaine.setNom(domaines.get(0).getNom());
			procedure.setDomaine(domaines.get(0));
			// domaineService.ajouterDomaine(domaine);
			procedureService.ajouterProcedure(procedure);

		}

	}

	@GetMapping("/private/domaines") // récupération de la liste des domaines
	public List<String> tousLesDomaines() {

		List<String> nomsDomaines = domaineService.tousLesNomsDomaines();

		return nomsDomaines;
	}

	@GetMapping("/private/qualifications") // récupération de la liste de toutes les qualifications
	public List<QualificationAux> toutesLesQualifications() {

		List<QualificationAux> qualifications = qualificationService.tousLesQualifications();

		return qualifications;
	}

	@GetMapping("/private/historique/{id}") // récupération de la liste de toutes les qualifications
	public List<QualificationAux> mesQualifications(@PathVariable(name = "id") Integer id) {

		List<QualificationAux> qualifications = qualificationService.mesQualifications(id);
		return qualifications;

	}

	@GetMapping("/private/qualifications/{id}")
	public List<QualificationAux> mesQualificationsEnCours(@PathVariable(name = "id") Integer id) {

		List<QualificationAux> qualifications = qualificationService.mesQualificationsEnCours(id);
		return qualifications;

	}

	@GetMapping("/private/qualification/{id}") // récupération de la liste de toutes les qualifications en cours par
												// utilisateur
	public QualificationAux obtenirQualification(@PathVariable(name = "id") Integer id) {

		QualificationAux qualification = qualificationService.obtenirQualification(id);

		return qualification;
	}

	@GetMapping("/private/procedures")
	public List<ProcedureAux> obtenirProcedures() {

		List<Procedure> procedures = procedureService.obtenirProcedures();
		List<ProcedureAux> listeProcedures = new ArrayList<ProcedureAux>();

		for (Procedure pro : procedures) {

			ProcedureAux procedure = new ProcedureAux(pro);
			listeProcedures.add(procedure);

		}

		return listeProcedures;
	}
	
	@GetMapping("/private/liste/domaines") 
	public List<DomaineAux> obtenirDomaines(){
		
		List<Domaine> domaines = domaineService.TousLesDomaines();
		List<DomaineAux> listeDomaines = new ArrayList<DomaineAux>();
		for(Domaine dom:domaines) {
			
			DomaineAux domaine = new DomaineAux(dom);
			listeDomaines.add(domaine);
		}
		
		return listeDomaines;
	}
	
	@GetMapping("/private/liste/domaine/{id}") 
	public List<ProcedureAux> obtenirDomainesParDomaine(@PathVariable(name = "id") Integer id){
		
		
		List<Procedure> procedures = procedureService.obtenirProceduresDuDomaine(id);
		List<ProcedureAux> listeProcedures = new ArrayList<ProcedureAux>();
		
		for (Procedure pro : procedures) {

			ProcedureAux procedure = new ProcedureAux(pro);
			listeProcedures.add(procedure);

		}
		
		
		return listeProcedures;
		
	}
}
