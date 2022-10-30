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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michel.lab.model.Domaine;
import com.michel.lab.model.DomaineAux;
import com.michel.lab.model.Echantillon;
import com.michel.lab.model.EchantillonAux;
import com.michel.lab.model.EchantillonData;
import com.michel.lab.model.Essai;
import com.michel.lab.model.EssaiAux;
import com.michel.lab.model.EssaiData;
import com.michel.lab.model.FormEchantillon;
import com.michel.lab.model.FormEssai;
import com.michel.lab.model.FormInitRapport;
import com.michel.lab.model.FormNote;
import com.michel.lab.model.FormProcedure;
import com.michel.lab.model.FormQualif;
import com.michel.lab.model.FormSequence;
import com.michel.lab.model.Groupe;
import com.michel.lab.model.Note;
import com.michel.lab.model.NoteAux;
import com.michel.lab.model.Procedure;
import com.michel.lab.model.ProcedureAux;
import com.michel.lab.model.Qualification;
import com.michel.lab.model.QualificationAux;
import com.michel.lab.model.Rapport;
import com.michel.lab.model.RapportAux;
import com.michel.lab.model.Sequence;
import com.michel.lab.model.SequenceAux;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.repository.ProcedureRepo;
import com.michel.lab.service.jpa.DomaineService;
import com.michel.lab.service.jpa.EchantillonService;
import com.michel.lab.service.jpa.EssaiService;
import com.michel.lab.service.jpa.NoteService;
import com.michel.lab.service.jpa.ProcedureService;
import com.michel.lab.service.jpa.QualificationService;
import com.michel.lab.service.jpa.RapportService;
import com.michel.lab.service.jpa.SequenceService;
import com.michel.lab.service.jpa.UserService;

@RestController
//@RequestMapping("/lab-service")
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

	@Autowired
	RapportService rapportService;

	@Autowired
	NoteService noteService;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM");

	@PostMapping("/save/qualification")
	public void saveQualification(@RequestHeader("Authorization") String token, @RequestBody FormQualif formQualif) {

		Qualification qualification = new Qualification();

		List<QualificationAux> qualifications = qualificationService.tousLesQualifications();

		int nombreQualifications = 0;

		if (qualifications.isEmpty()) {

			nombreQualifications = 0;
		} else {

			nombreQualifications = qualifications.size();
		}

		qualification.setNumero(nombreQualifications + 1);
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
	public void saveProcedure(@RequestHeader("Authorization") String token, @RequestBody FormProcedure formProcedure) {

		Procedure procedure = new Procedure();
		procedure.setNom(formProcedure.getNom());
		procedure.setReferentiel(formProcedure.getReferentiel());
		procedure.setVersion(formProcedure.getVersion());

		String nomDomaine = formProcedure.getDomaine();

		List<Domaine> domaines = domaineService.obtenirDomaine(nomDomaine);

		if (domaines.isEmpty() || domaines == null) {

			Domaine domaine = new Domaine();
			domaine.setNom(formProcedure.getDomaine());
			domaineService.ajouterDomaine(domaine);
			procedure.setDomaine(domaine);
			domaineService.ajouterDomaine(domaine);
			procedureService.ajouterProcedure(procedure);

		} else {

			Domaine domaine = new Domaine();
			domaine.setNom(domaines.get(0).getNom());
			procedure.setDomaine(domaines.get(0));
			procedureService.ajouterProcedure(procedure);

		}

	}

	@GetMapping("/private/domaines") // récupération de la liste des domaines
	public List<String> tousLesDomaines(@RequestHeader("Authorization") String token) {

		List<String> nomsDomaines = domaineService.tousLesNomsDomaines();

		return nomsDomaines;
	}

	@GetMapping("/private/qualifications") // récupération de la liste de toutes les qualifications
	public List<QualificationAux> toutesLesQualifications(@RequestHeader("Authorization") String token) {

		List<QualificationAux> qualifications = qualificationService.tousLesQualifications();

		return qualifications;
	}

	@GetMapping("/private/historique/{id}") // récupération de la liste de toutes les qualifications
	public List<QualificationAux> mesQualifications(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id) {

		List<QualificationAux> qualifications = qualificationService.mesQualifications(id);
		return qualifications;

	}

	@GetMapping("/private/qualifications/{id}")
	public List<QualificationAux> mesQualificationsEnCours(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id) {

		List<QualificationAux> qualifications = qualificationService.mesQualificationsEnCours(id);
		return qualifications;

	}

	@GetMapping("/private/qualification/{id}") // récupération de la liste de toutes les qualifications en cours par
												// utilisateur
	public QualificationAux obtenirQualification(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id) {

		Qualification qualification = qualificationService.obtenirQualification(id);
		QualificationAux qualifAux = new QualificationAux(qualification);

		return qualifAux;
	}

	@GetMapping("/private/qualification/identifiant/{id}")
	public QualificationAux obtenirQualificationParId(@RequestHeader("Authorization") String token,
			Integer idQualification) {

		Qualification qualification = qualificationService.obtenirQualificationParIdentifiant(idQualification);
		QualificationAux qualifAux = new QualificationAux(qualification);

		return qualifAux;

	}

	@GetMapping("/private/procedures")
	public List<ProcedureAux> obtenirProcedures(@RequestHeader("Authorization") String token) {

		List<Procedure> procedures = procedureService.obtenirProcedures();
		List<ProcedureAux> listeProcedures = new ArrayList<ProcedureAux>();

		for (Procedure pro : procedures) {

			ProcedureAux procedure = new ProcedureAux(pro);
			listeProcedures.add(procedure);

		}

		return listeProcedures;
	}

	@GetMapping("/private/liste/domaines")
	public List<DomaineAux> obtenirDomaines(@RequestHeader("Authorization") String token) {

		List<Domaine> domaines = domaineService.TousLesDomaines();
		List<DomaineAux> listeDomaines = new ArrayList<DomaineAux>();
		for (Domaine dom : domaines) {

			DomaineAux domaine = new DomaineAux(dom);
			listeDomaines.add(domaine);
		}

		return listeDomaines;
	}

	@GetMapping("/private/liste/domaine/{id}")
	public List<ProcedureAux> obtenirDomainesParDomaine(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id) {

		List<Procedure> procedures = procedureService.obtenirProceduresDuDomaine(id);
		List<ProcedureAux> listeProcedures = new ArrayList<ProcedureAux>();

		for (Procedure pro : procedures) {

			ProcedureAux procedure = new ProcedureAux(pro);
			listeProcedures.add(procedure);

		}

		return listeProcedures;

	}

	@PostMapping("/essai/ajouter/procedure/{id}/{qualification}/{idUser}")
	public void ajouterProcedure(@RequestHeader("Authorization") String token, @PathVariable(name = "id") Integer id,
			@PathVariable(name = "qualification") Integer qualification,
			@PathVariable(name = "idUser") Integer idUser) {

		Utilisateur technicien = userService.obtenirUser(idUser);
		Qualification qualif = qualificationService.obtenirQualificationParNumero(qualification);
		Procedure procedure = procedureService.obtenirProcedure(id);

		List<Essai> listeEssais = qualif.getEssais();
		int nombreEssais = 0;
		if (listeEssais.isEmpty()) {

			nombreEssais = 0;
		} else {

			nombreEssais = listeEssais.size();
		}

		Essai essai = new Essai();
		essai.setNumero(nombreEssais + 1);
		essai.setQualification(qualif);
		essai.setTechnicien(technicien);
		essai.setResultat(false); // En cours ou non conforme
		essai.setStatut(true); // l'essai est en cours
		essai.setProcedure(procedure);
		essai.setDate(LocalDateTime.now());

		essaiService.ajouterEssai(essai);

	}

	
	@PostMapping("/private/liste/procedure/selection")
	public List<Integer> obtenirSelectionProcedure(@RequestHeader("Authorization") String token,
			@RequestBody Groupe groupe) { // id = identifiant du domaine

		Integer idDomaine = groupe.getDomaine();
		Integer numero = groupe.getQualification();

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
	public List<EssaiAux> obtenirEssaisParQualification(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id) {

		List<EssaiAux> essais = essaiService.obtenirEssaisParQualification(id);

		return essais;

	}

	@PostMapping("private/echantillon/save") // Enregistrement d'une procédure
	public void saveEchantillon(@RequestHeader("Authorization") String token,
			@RequestBody FormEchantillon formEchantillon) {

		echantillonService.enregistrerEchantillon(formEchantillon);

	}

	@GetMapping("/private/echantillon/voir/{id}")
	public List<EchantillonAux> obtenirEchantillonsParQualification(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id) {

		List<Echantillon> echantillons = echantillonService.obtenirEchantillonParQualification(id);
		List<EchantillonAux> echantillonsAux = new ArrayList<EchantillonAux>();

		for (Echantillon ech : echantillons) {

			EchantillonAux echantillonAux = new EchantillonAux(ech);
			echantillonsAux.add(echantillonAux);
		}
		return echantillonsAux;
	}

	@GetMapping("/private/echantillon/voir")
	public List<EchantillonAux> obtenirEchantillonsParQualification2(@RequestHeader("Authorization") String token,
			@RequestParam(name = "id") Integer id) {

		List<Echantillon> echantillons = echantillonService.obtenirEchantillonParQualification(id);
		List<EchantillonAux> echantillonsAux = new ArrayList<EchantillonAux>();

		for (Echantillon ech : echantillons) {

			EchantillonAux echantillonAux = new EchantillonAux(ech);
			echantillonsAux.add(echantillonAux);
		}
		return echantillonsAux;

	}

	@GetMapping("/private/echantillon/activer/{id}/{qualification}")
	public void activerEchantillon(@RequestHeader("Authorization") String token, @PathVariable(name = "id") Integer id,
			@PathVariable(name = "qualification") Integer qualification) {

		echantillonService.setActif(id, true);
	}

	@GetMapping("/private/echantillon/desactiver/{id}/{qualification}")
	public void desactiverEchantillon(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id, @PathVariable(name = "qualification") Integer qualification) {

		echantillonService.setActif(id, false);

	}

	@GetMapping("/private/sequences/voir/{id}/{num}")
	public List<SequenceAux> obtenirSequencesParEssai(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id, @PathVariable(name = "num") Integer num) {

		List<Sequence> sequences = sequenceService.obtenirSequencesParEssai(num);
		List<SequenceAux> listeSequences = new ArrayList<SequenceAux>();

		for (Sequence seq : sequences) {

			SequenceAux s = new SequenceAux(seq);
			
			listeSequences.add(s);
		}
		return listeSequences;
	}

	@GetMapping("/private/essai/{num}")
	public EssaiAux obtenirEssaiParNumero(@RequestHeader("Authorization") String token,
			@PathVariable(name = "num") Integer num) {

		Essai es = essaiService.obtenirEssaiParNum(num);
		EssaiAux essai = new EssaiAux(es);
		return essai;
	}

	@GetMapping("/private/qualification/numero/{id}")
	public QualificationAux obtenirQualificationParNumero(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id) {

		Qualification qual = qualificationService.obtenirQualificationParNumero(id);
		QualificationAux qualification = new QualificationAux(qual);

		return qualification;

	}

	@PostMapping("private/sequence/save")
	public void enregistrerSequence(@RequestHeader("Authorization") String token,
			@RequestBody FormSequence formSequence) {

		sequenceService.enregistrerSequence(formSequence);

	}

	@GetMapping("private/sequence/{id}")
	public SequenceAux obtenirSequenceParId(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id) {

		Sequence seq = sequenceService.obtenirSequenceParId(id);
		SequenceAux sequence = new SequenceAux(seq);
		
		return sequence;

	}

	@PostMapping("private/sequence/modifier")
	public void modifierSequence(@RequestHeader("Authorization") String token, @RequestBody FormSequence formSequence) {

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
	public void retirerEchantillon(@RequestHeader("Authorization") String token,
			@PathVariable(name = "echantillon") Integer idEchantillon,
			@PathVariable(name = "qualification") Integer numQualification,
			@PathVariable(name = "sequence") Integer idSequence) {

		Sequence seq = sequenceService.obtenirSequenceParId(idSequence);
		List<Echantillon> echantillons = seq.getEchantillons();

		boolean ok = false;

		int i = 0;
		while (!ok && i < echantillons.size()) {

			Echantillon ech = echantillons.get(i);
			Integer idEch = ech.getId();
			if (idEchantillon == idEch) {

				ok = true;

			}

			i++;
		}

		int j;
		Echantillon ech = echantillons.get(j = i < 0 ? i - 1 : 0);
		// ech.setId(idEchantillon);
		echantillons.remove(ech);

		seq.setEchantillons(echantillons);

		sequenceService.retirerEchantillon(seq);

	}

	@GetMapping("/private/echantillon/sequence/selection/{qualification}/{sequence}")
	public List<EchantillonAux> obtenirEchantillonSelectionParSequence(@RequestHeader("Authorization") String token,
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

		}

		return echantillonsAux;
	}

	@GetMapping("/private/echantillon/modifier/{id}")
	public EchantillonAux obtenirEchantillon(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id) {

		Echantillon ech = echantillonService.obtenirEchantillonParId(id);
		EchantillonAux echantillon = new EchantillonAux(ech);

		return echantillon;

	}

	@PostMapping("/private/echantillon/modifier")
	public void modifierEchantillon(@RequestHeader("Authorization") String token,
			@RequestBody FormEchantillon formEchantillon) {

		Integer id = formEchantillon.getId();
		Echantillon echantillon = echantillonService.obtenirEchantillonParId(id);

		echantillon.setCaracteristique(formEchantillon.getCaracteristique());
		echantillon.setNumero(formEchantillon.getNumero());
		echantillon.setVersion(formEchantillon.getVersion());
		String date = formEchantillon.getDate();

		echantillon.setDate(
				LocalDateTime.parse(date + " " + "00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		echantillonService.modifierEchantillon(echantillon);

	}

	@GetMapping("private/qualification/modifier/statut/{id}")
	public void modifierStatutQualification(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer numQualification) {

		Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
		qualificationService.modifierStatutQualification(qualification);

	}

	@GetMapping("private/qualification/modifier/resultat/{id}")
	public void modifierResultatQualification(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer numQualification) {

		Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
		qualificationService.modifierResultatQualification(qualification);

	}

	@PostMapping("/private/qualification/modifier")
	public void modifierQualification(@RequestHeader("Authorization") String token,
			@RequestBody FormQualif formQualif) {

		Integer numQualification = formQualif.getNumero();
		Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
		qualification.setNumero(formQualif.getNumero());
		qualification.setReference(formQualif.getReference());
		qualification.setProduit(formQualif.getProduit());
		qualification.setProjet(formQualif.getProjet());
		qualification.setObjet(formQualif.getObjet());
		String statut = formQualif.getStatut();
		String resultat = formQualif.getResultat();

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
	public void supprimerSequence(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer idSequence) {

		Sequence sequence = sequenceService.obtenirSequenceParId(idSequence);
		sequenceService.supprimerSequence(sequence);

	}

	@PostMapping("/private/essai/modifier")
	public void modifierEssai(@RequestHeader("Authorization") String token, @RequestBody FormEssai formEssai) {

		essaiService.modifierEssai(formEssai);

	}

	@GetMapping("/private/sequence/recuperation/{id}") // Utiliser pour réparer les enregistrements défectueux de
														// séquences
	public void recupererSequence(@RequestHeader("Authorization") String token, @PathVariable("id") Integer id) { // id
																													// =
																													// id
																													// de
																													// la
																													// séquence
																													// déféctueuse

		Sequence seq = sequenceService.obtenirSequenceParId(id);
		seq.setDebut(LocalDateTime.now());
		seq.setFin(LocalDateTime.now());
		sequenceService.ajouterSequence(seq);

	}

	@GetMapping("/private/rapport/liste/{num}")
	public List<RapportAux> obtenirRapportsParQualification(@RequestHeader("Authorization") String token,
			@PathVariable(name = "num") Integer numQualification) {

		Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
		List<Rapport> rapports = qualification.getRapports();
		List<RapportAux> listeRapports = new ArrayList<RapportAux>();

		for (Rapport r : rapports) {

			RapportAux rap = new RapportAux(r);
			listeRapports.add(rap);

		}

		return listeRapports;
	}

	@GetMapping("/private/rapport/{id}")
	public RapportAux obtenirRapportsParId(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer idRapport) {

		RapportAux rapport = rapportService.obtenirRapportParId(idRapport);

		return rapport;

	}

	@GetMapping("/private/qualification/id/{id}")
	public List<EssaiAux> obtenirEssaisParQualificationId(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer qualification) {

		Qualification qual = qualificationService.obtenirQualificationParIdentifiant(qualification);
		List<Essai> essais = qual.getEssais();
		List<EssaiAux> listeEssais = new ArrayList<EssaiAux>();

		for (Essai es : essais) {

			EssaiAux essaiAux = new EssaiAux(es);
			listeEssais.add(essaiAux);
		}

		return listeEssais;
	}

	@GetMapping("/private/echantillons/qualification/id/{qualification}")
	public List<EchantillonAux> obtenirEchantillonParIdQualification(@RequestHeader("Authorization") String token,
			@PathVariable(name = "qualification") Integer qualification) {

		List<EchantillonAux> echantillons = echantillonService.obtenirEchantillonParQualificationId(qualification);

		return echantillons;

	}

	@PostMapping("/private/rapport/enregistrer") // ajout en version pour test!
	public Integer enregistrerInitRapport2(@RequestHeader("Authorization") String token,
			@RequestBody FormInitRapport formInitRapport) {

		Integer idRapport = rapportService.enregistrerRapport(formInitRapport);
		return idRapport;
	}

	@GetMapping("/private/rapport/echantillons/{id}")
	public List<EchantillonAux> obtenirEchantillonsParRapportId(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer idRapport) {

		Rapport rapport = rapportService.obtenirRapport(idRapport);
		List<EchantillonData> echantillons = rapport.getEchantillons();
		List<EchantillonAux> listeEchantillons = new ArrayList<EchantillonAux>();

		for (EchantillonData e : echantillons) {

			EchantillonAux echAux = new EchantillonAux(e);
			listeEchantillons.add(echAux);
		}

		return listeEchantillons;

	}

	@GetMapping("/private/rapport/essais/{id}")
	public List<EssaiAux> obtenirEssaisParRapportId(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer idRapport) {

		Rapport rapport = rapportService.obtenirRapport(idRapport);
		List<EssaiData> essais = rapport.getEssais();

		List<EssaiAux> listeEssais = new ArrayList<EssaiAux>();

		for (EssaiData es : essais) {

			EssaiAux esAux = new EssaiAux(es);
			listeEssais.add(esAux);

		}

		return listeEssais;

	}

	@GetMapping("/private/rapport/supprimer/{id}")
	public void supprimerRapportsParId(@RequestHeader("Authorization") String token,
			@PathVariable("id") Integer idRapport) {

		rapportService.supprimerRapport(idRapport);

	}

	@GetMapping("/private/note/liste/{id}")
	public List<NoteAux> obtenirListeNotesParQualification(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer numQualification) {

		Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
		List<Note> notes = qualification.getNotes();
		List<NoteAux> listeNotes = new ArrayList<NoteAux>();

		for (Note n : notes) {

			NoteAux noteAux = new NoteAux(n);
			listeNotes.add(noteAux);

		}

		return listeNotes;
	}

	@PostMapping("/private/note/enregistrer")
	public void ajouterNote(@RequestHeader("Authorization") String token, @RequestBody FormNote formNote) {

		Note note = new Note();
		note.setActive(true);
		Utilisateur auteur = userService.obtenirUser(formNote.getAuteur());
		note.setAuteur(auteur);

		Qualification qualification = qualificationService.obtenirQualification(formNote.getQualification());
		note.setQualification(qualification);

		int nbreDeNotes = qualification.getNotes().size();

		if (qualification.getNotes().isEmpty()) {

			nbreDeNotes = 0;
		}

		nbreDeNotes++;
		note.setNumero(nbreDeNotes);

		note.setTexte(formNote.getTexte());

		String date = formNote.getDate();

		note.setDate(LocalDateTime.parse(date + " " + "00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

		noteService.ajouterNote(note);

	}

	@GetMapping("/private/note/voir/{id}")
	public NoteAux obtenirNote(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer idNote) {

		NoteAux note = noteService.obtenirNoteParId(idNote);

		return note;
	}

	@GetMapping("/private/note/supprimer/{id}")
	public void supprimerNote(@RequestHeader("Authorization") String token, @PathVariable(name = "id") Integer idNote) {

		noteService.supprimerNote(idNote);

	}

	@PostMapping("/private/note/modifier")
	public void modifierNote(@RequestHeader("Authorization") String token, @RequestBody FormNote formNote) {

		Integer idNote = formNote.getId();
		Note note = noteService.obtenirNoteReelleParId(idNote);
		note.setTexte(formNote.getTexte());
		noteService.ajouterNote(note);
	}

	@GetMapping("/private/procedure/liste/domaine/{domaine}")
	public List<ProcedureAux> obtenirProceduresParDomaine(@RequestHeader("Authorization") String token,
			@PathVariable(name = "domaine") String domaine) {

		List<ProcedureAux> procedures = procedureService.obtenirProceduresParDomaine(domaine);
		return procedures;
	}

	@GetMapping("/private/procedure/obtenir/{id}")
	public ProcedureAux obtenirUneProcedure(@RequestHeader("Authorization") String token,
			@PathVariable(name = "id") Integer id) {

		Procedure procedure = procedureService.obtenirProcedure(id);
		ProcedureAux proAux = new ProcedureAux(procedure);

		return proAux;
	}

	@PostMapping("/private/procedure/modifier")
	public void modifierProcedure(@RequestHeader("Authorization") String token,
			@RequestBody FormProcedure formProcedure) {

		procedureService.modifierProcedure(formProcedure);

	}

}
