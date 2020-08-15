package com.michel.lab.controller;

import java.time.Duration;
import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michel.lab.model.Domaine;
import com.michel.lab.model.DomaineAux;
import com.michel.lab.model.Echantillon;
import com.michel.lab.model.EchantillonAux;
import com.michel.lab.model.Essai;
import com.michel.lab.model.EssaiAux;
import com.michel.lab.model.FormEchantillon;
import com.michel.lab.model.FormEssai;
import com.michel.lab.model.FormProcedure;
import com.michel.lab.model.FormQualif;
import com.michel.lab.model.FormSequence;
import com.michel.lab.model.Groupe;
import com.michel.lab.model.Procedure;
import com.michel.lab.model.ProcedureAux;
import com.michel.lab.model.Qualification;
import com.michel.lab.model.QualificationAux;
import com.michel.lab.model.Sequence;
import com.michel.lab.model.SequenceAux;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.repository.ProcedureRepo;
import com.michel.lab.service.jpa.DomaineService;
import com.michel.lab.service.jpa.EchantillonService;
import com.michel.lab.service.jpa.EssaiService;
import com.michel.lab.service.jpa.ProcedureService;
import com.michel.lab.service.jpa.QualificationService;
import com.michel.lab.service.jpa.SequenceService;
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

	@Autowired
	EssaiService essaiService;

	@Autowired
	EchantillonService echantillonService;

	@Autowired
	SequenceService sequenceService;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM");

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

		Qualification qualification = qualificationService.obtenirQualification(id);
		QualificationAux qualifAux = new QualificationAux(qualification);

		return qualifAux;
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
	public List<DomaineAux> obtenirDomaines() {

		List<Domaine> domaines = domaineService.TousLesDomaines();
		List<DomaineAux> listeDomaines = new ArrayList<DomaineAux>();
		for (Domaine dom : domaines) {

			DomaineAux domaine = new DomaineAux(dom);
			listeDomaines.add(domaine);
		}

		return listeDomaines;
	}

	@GetMapping("/private/liste/domaine/{id}")
	public List<ProcedureAux> obtenirDomainesParDomaine(@PathVariable(name = "id") Integer id) {

		List<Procedure> procedures = procedureService.obtenirProceduresDuDomaine(id);
		List<ProcedureAux> listeProcedures = new ArrayList<ProcedureAux>();

		for (Procedure pro : procedures) {

			ProcedureAux procedure = new ProcedureAux(pro);
			listeProcedures.add(procedure);

		}

		return listeProcedures;

	}

	@PostMapping("/essai/ajouter/procedure/{id}/{qualification}/{idUser}")
	public void ajouterProcedure(@PathVariable(name = "id") Integer id,
			@PathVariable(name = "qualification") Integer qualification,
			@PathVariable(name = "idUser") Integer idUser) {

		Utilisateur technicien = userService.obtenirUser(idUser);
		Qualification qualif = qualificationService.obtenirQualificationParNumero(qualification);
		Procedure procedure = procedureService.obtenirProcedure(id);
		Essai essai = new Essai();
		essai.setQualification(qualif);
		essai.setTechnicien(technicien);
		essai.setResultat(false); // En cours ou non conforme
		essai.setStatut(true); // l'essai est en cours
		essai.setProcedure(procedure);
		essai.setDate(LocalDateTime.now());

		essaiService.ajouterEssai(essai);

	}

	@PostMapping("/private/liste/procedure/selection")
	public List<Integer> obtenirSelectionProcedure(@RequestBody Groupe groupe) { // id = identifiant du domaine

		Integer idDomaine = groupe.getDomaine();
		Integer numero = groupe.getQualification();

		System.out.println("***  Méthode obtenirSelectionProcedure ***");
		System.out.println("Domaine: " + idDomaine);
		System.out.println("Qualification: " + numero);

		Qualification qualification = qualificationService.obtenirQualificationParNumero(numero);
		List<Essai> essais = qualification.getEssais();
		List<Integer> idEssais = new ArrayList<Integer>();

		for (Essai es : essais) {

			Integer id = es.getId();
			Procedure procedure = es.getProcedure();
			Domaine domaine = procedure.getDomaine();
			Integer idDom = domaine.getId();

			if (idDom == idDomaine) {

				idEssais.add(id);

			}
		}

		List<Integer> idProcedures = new ArrayList<Integer>();
		for (Integer idEssai : idEssais) {

			Essai ess = essaiService.obtenirParId(idEssai);
			Procedure procedure = ess.getProcedure();
			Integer idProcedure = procedure.getId();
			idProcedures.add(idProcedure);
		}

		return idProcedures;
	}

	@GetMapping("/private/liste/essais/{id}")
	public List<EssaiAux> obtenirEssaisParQualification(@PathVariable(name = "id") Integer id) {

		System.out.println("*** Entrée méthode obtenirEssaisParQualification - service");
		System.out.println("Numéro qualif reçu: " + id);

		List<EssaiAux> essais = essaiService.obtenirEssaisParQualification(id);

		return essais;

	}

	@PostMapping("private/echantillon/save") // Enregistrement d'une procédure
	public void saveEchantillon(@RequestBody FormEchantillon formEchantillon) {

		echantillonService.enregistrerEchantillon(formEchantillon);

	}

	@GetMapping("/private/echantillon/voir/{id}")
	public List<EchantillonAux> obtenirEchantillonsParQualification(@PathVariable(name = "id") Integer id) {

		List<Echantillon> echantillons = echantillonService.obtenirEchantillonParQualification(id);
		List<EchantillonAux> echantillonsAux = new ArrayList<EchantillonAux>();

		for (Echantillon ech : echantillons) {

			EchantillonAux echantillonAux = new EchantillonAux(ech);
			echantillonsAux.add(echantillonAux);
		}
		return echantillonsAux;
	}

	@GetMapping("/private/echantillon/voir")
	public List<EchantillonAux> obtenirEchantillonsParQualification2(@RequestParam(name = "id") Integer id) {

		List<Echantillon> echantillons = echantillonService.obtenirEchantillonParQualification(id);
		List<EchantillonAux> echantillonsAux = new ArrayList<EchantillonAux>();

		for (Echantillon ech : echantillons) {

			EchantillonAux echantillonAux = new EchantillonAux(ech);
			echantillonsAux.add(echantillonAux);
		}
		return echantillonsAux;

	}

	@GetMapping("/private/echantillon/activer/{id}/{qualification}")
	public void activerEchantillon(@PathVariable(name = "id") Integer id,
			@PathVariable(name = "qualification") Integer qualification) {

		echantillonService.setActif(id, true);
	}

	@GetMapping("/private/echantillon/desactiver/{id}/{qualification}")
	public void desactiverEchantillon(@PathVariable(name = "id") Integer id,
			@PathVariable(name = "qualification") Integer qualification) {

		echantillonService.setActif(id, false);

	}

//	@GetMapping("/private/sequences/voir/{id}/{num}/{domaine}")
	@GetMapping("/private/sequences/voir/{id}/{num}")
	public List<SequenceAux> obtenirSequencesParEssai(@PathVariable(name = "id") Integer id,
			@PathVariable(name = "num") Integer num) {
		// @PathVariable(name="domaine")String domaine){

		List<Sequence> sequences = sequenceService.obtenirSequencesParEssai(num);
		List<SequenceAux> listeSequences = new ArrayList<SequenceAux>();

		for (Sequence seq : sequences) {

			SequenceAux s = new SequenceAux(seq);
			String dateDebut = "";
			String dateFin = "";

			try {

				dateDebut = seq.getDebut().format(formatter);
			}

			catch (Exception e) {

				dateDebut = "";
			}

			s.setDebutText(dateDebut);

			try {
				dateFin = seq.getFin().format(formatter);
			} catch (Exception e) {

				dateFin = "";
			}

			s.setFinText(dateFin);

			try {

				Duration duration = Duration.between(s.getDebut(), s.getFin());
				System.out.println("durée: " + duration.toHours() + " hours");
				long duree = duration.toHours();
				s.setDuree(duree);

			} catch (Exception e) {

				s.setDuree(0);
			}

			listeSequences.add(s);

		}
		return listeSequences;
	}

	@GetMapping("/private/essai/{num}")
	public EssaiAux obtenirEssaiParNumero(@PathVariable(name = "num") Integer num) {

		Essai es = essaiService.obtenirEssaiParNum(num);
		EssaiAux essai = new EssaiAux(es);
		return essai;
	}

	@GetMapping("/private/qualification/numero/{id}")
	public QualificationAux obtenirQualificationParNumero(@PathVariable(name = "id") Integer id) {

		Qualification qual = qualificationService.obtenirQualificationParNumero(id);
		QualificationAux qualification = new QualificationAux(qual);

		return qualification;

	}

	@PostMapping("private/sequence/save")
	public void enregistrerSequence(@RequestBody FormSequence formSequence) {

		System.out.println("méthode enregistrerSequence ");
		System.out.println(formSequence.toString());
		sequenceService.enregistrerSequence(formSequence);

	}

	@GetMapping("private/sequence/{id}")
	public SequenceAux obtenirSequenceParId(@PathVariable(name = "id") Integer id) {

		Sequence seq = sequenceService.obtenirSequenceParId(id);
		SequenceAux sequence = new SequenceAux(seq);
		
		String dateDebut = "";
		String dateFin = "";
				
		try {
			
		dateDebut =  sequence.getDebut().format(formatter);
			}
		
		catch (Exception e) {

			dateDebut = "";
			
		}
		
		sequence.setDebutText(dateDebut);
		
		try {
			
		dateFin =  sequence.getFin().format(formatter);
		
		}catch (Exception e) {
			
			dateFin = "";
		}
		sequence.setFinText(dateFin);
		
		long duree =0;
		
	    System.out.println("Valeur debut: " + sequence.getDebut());	
	    System.out.println("Valeur fin: " + sequence.getFin());	
	    
	    if (sequence.getDebut() != null && sequence.getFin() != null ) {
		Duration duration = Duration.between(sequence.getDebut(), sequence.getFin());
		System.out.println("durée: "  + duration.toHours() + " hours");
	
		duree = duration.toHours(); 
		
	    	
	    } 
	
	    sequence.setDuree(duree);
	   
		return sequence;

	}

	@PostMapping("private/sequence/modifier")
	public void modifierSequence(@RequestBody FormSequence formSequence) {

		System.out.println("méthode enregistrerSequence ");
		System.out.println(formSequence.toString());
		sequenceService.modifierSequence(formSequence);

	}

	@PostMapping("private/echantillon/ajouter/{echantillon}/{qualification}/{sequence}")
	public void ajouterEchantillon(@PathVariable(name = "echantillon") Integer idEchantillon,
			@PathVariable(name = "qualification") Integer numQualification,
			@PathVariable(name = "sequence") Integer idSequence) {

		Sequence seq = sequenceService.obtenirSequenceParId(idSequence);
		List<Echantillon> echantillons = seq.getEchantillons();
		if (echantillons == null) {

			echantillons = new ArrayList<Echantillon>();

		}

		Echantillon ech = new Echantillon();
		ech.setId(idEchantillon);
		echantillons.add(ech);

		sequenceService.ajouterEchantillon(seq);

	}

	@PostMapping("private/echantillon/retirer/{echantillon}/{qualification}/{sequence}")
	public void retirerEchantillon(@PathVariable(name = "echantillon") Integer idEchantillon,
			@PathVariable(name = "qualification") Integer numQualification,
			@PathVariable(name = "sequence") Integer idSequence) {

		Sequence seq = sequenceService.obtenirSequenceParId(idSequence);
		List<Echantillon> echantillons = seq.getEchantillons();
		System.out.println("taille liste echantillons avant:  " + echantillons.size());
		System.out.println("id de ech: " + idEchantillon);

		boolean ok = false;

		int i = 0;
		while (!ok && i < echantillons.size()) {

			Echantillon ech = echantillons.get(i);
			Integer idEch = ech.getId();
			if (idEchantillon == idEch) {

				ok = true;

			}

			System.out.println("indice i avant sortie" + i);
			i++;
		}

		System.out.println("indice i après sortie" + i);
		int j;
		Echantillon ech = echantillons.get(j = i < 0 ? i - 1 : 0);
		// ech.setId(idEchantillon);
		echantillons.remove(ech);

		System.out.println("taille liste echantillons après:  " + echantillons.size());
		seq.setEchantillons(echantillons);

		sequenceService.retirerEchantillon(seq);

	}

	@GetMapping("/private/echantillon/sequence/selection/{qualification}/{sequence}")
	public List<EchantillonAux> obtenirEchantillonSelectionParSequence(
			@PathVariable(name = "qualification") Integer num, @PathVariable(name = "sequence") Integer idSequence) {

		List<Echantillon> echsSelection = sequenceService.obtenirSelectionEchantillon(idSequence);
		List<Echantillon> echsQualification = echantillonService.obtenirEchantillonParQualification(num);

		List<EchantillonAux> echantillonsAux = new ArrayList<EchantillonAux>();

		for (Echantillon ech : echsQualification) { // conversion de tous les échantillons de la sélection

			EchantillonAux ech1 = new EchantillonAux(ech);
			echantillonsAux.add(ech1);

		}

		for (EchantillonAux ech : echantillonsAux) {

			ech.setSelection(echsSelection);
			System.out.println("statut de l'échantillon: " + ech.isSelection() + " - " + ech.getId());
		}

		return echantillonsAux;
	}

	@GetMapping("/private/echantillon/modifier/{id}")
	public EchantillonAux obtenirEchantillon(@PathVariable(name = "id") Integer id) {

		Echantillon ech = echantillonService.obtenirEchantillonParId(id);
		EchantillonAux echantillon = new EchantillonAux(ech);

		return echantillon;

	}

	@PostMapping("/private/echantillon/modifier")
	public void modifierEchantillon(

			@RequestBody FormEchantillon formEchantillon) {

		Integer id = formEchantillon.getId();
		Echantillon echantillon = echantillonService.obtenirEchantillonParId(id);

		echantillon.setCaracteristique(formEchantillon.getCaracteristique());
		echantillon.setNumero(formEchantillon.getNumero());
		echantillon.setVersion(formEchantillon.getVersion());

		echantillonService.modifierEchantillon(echantillon);

	}

	@GetMapping("private/qualification/modifier/statut/{id}")
	public void modifierStatutQualification(@PathVariable(name = "id") Integer numQualification) {

		Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
		qualificationService.modifierStatutQualification(qualification);

	}

	@GetMapping("private/qualification/modifier/resultat/{id}")
	public void modifierResultatQualification(@PathVariable(name = "id") Integer numQualification) {

		Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
		qualificationService.modifierResultatQualification(qualification);

	}

	@PostMapping("/private/qualification/modifier")
	public void modifierQualification(@RequestBody FormQualif formQualif) {

		Integer numQualification = formQualif.getNumero();
		Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
		qualification.setNumero(formQualif.getNumero());
		qualification.setReference(formQualif.getReference());
		qualification.setProduit(formQualif.getProduit());
		qualification.setProjet(formQualif.getProjet());
		qualification.setObjet(formQualif.getObjet());
		String statut = formQualif.getStatut();
		String resultat = formQualif.getResultat();
		System.out.println("statut récupéré formulaire modif qualif: " + statut);
		System.out.println("resultat récupéré formulaire modif qualif: " + resultat);

		if (statut.equals("Clôturée")) {

			qualification.setStatut(false);

		} else {

			qualification.setStatut(true);
		}

		if (resultat.equals("Active") || resultat.equals("Non-conforme")) {

			qualification.setResultat(false); // valeur par défaut tant en attente résultat d'un définitif
		}

		if (resultat.equals("Conforme")) {

			qualification.setResultat(true);
		}

		qualificationService.ajouterQualification(qualification);

	}

	@PostMapping("/private/sequence/supprimer/{id}")
	public void supprimerSequence(@PathVariable(name = "id") Integer idSequence) {

		Sequence sequence = sequenceService.obtenirSequenceParId(idSequence);
		sequenceService.supprimerSequence(sequence);

	}

	@PostMapping("/private/essai/modifier")
	public void modifierEssai(@RequestBody FormEssai formEssai) {

		essaiService.modifierEssai(formEssai);

	}

	@GetMapping("/private/sequence/recuperation/{id}") // Utiliser pour réparer les enregistrements défectueux de
														// séquences
	public void recupererSequence(@PathVariable("id") Integer id) {

		Sequence seq = sequenceService.obtenirSequenceParId(id);
		seq.setDebut(LocalDateTime.now());
		seq.setFin(LocalDateTime.now());
		sequenceService.ajouterSequence(seq);
		System.out.println("Enregistrement sequence id=" + id);
	}

}
