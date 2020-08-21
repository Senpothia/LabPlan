package com.michel.lab.service.jpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Echantillon;
import com.michel.lab.model.EchantillonAux;
import com.michel.lab.model.Essai;
import com.michel.lab.model.EssaiAux;
import com.michel.lab.model.FormInitRapport;
import com.michel.lab.model.Qualification;
import com.michel.lab.model.Rapport;
import com.michel.lab.model.RapportAux;
import com.michel.lab.model.Sequence;
import com.michel.lab.model.SequenceAux;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.repository.RapportAuxRepo;
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

	@Autowired
	RapportAuxService rapportAuxService;

	@Autowired
	EchantillonService echantillonService;

	@Autowired
	EchantillonAuxService echantillonAuxService;

	@Autowired
	SequenceAuxService sequenceAuxService;

	@Autowired
	EssaiAuxService essaiAuxService;

	@Autowired
	EssaiService essaiService;
	
	///////////////////////////////////////////////////////////////////
	
	
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
		rapport.setAvis(formInitRapport.getAvis());

		Integer numQualification = formInitRapport.getQualification();
		Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);

		rapport.setQualification(qualification);
		String date = formInitRapport.getDate() + " " + "00:00 AM";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

		LocalDateTime dateConvertie = LocalDateTime.parse(date, formatter);

		System.out.println("date convertie: " + dateConvertie);
		rapport.setDate(dateConvertie);

		RapportAux rapportAux = new RapportAux(rapport);
		
		rapportRepo.save(rapport);
		rapportAuxService.enregistrerRapportAux(rapportAux);

		rapport.setRapportAux(rapportAux);
		rapportRepo.save(rapport);

		List<Echantillon> echantillons = echantillonService.obtenirEchantillonParQualification(numQualification);

		for (Echantillon e : echantillons) {

			EchantillonAux ech = new EchantillonAux(e);
			ech.setRapport(rapport);

			echantillonAuxService.enregistrerEchantillonAux(ech);

		}

		// rapport.setEchantillonsAux(listeEchantillonsAux);

		List<EssaiAux> essaisAux = essaiService.obtenirEssaisParQualification(numQualification);

		for (EssaiAux e : essaisAux) {

			e.setRapportAux(rapportAux);

			essaiAuxService.enregistrerEssaiAux(e);
			/*
			 * 
			 * Integer id = e.getId(); Essai essai = essaiService.obtenirEssaiParId(id);
			 * 
			 * List<Sequence> seqs = essai.getSequences();
			 * 
			 * 
			 * for (Sequence s: seqs) {
			 * 
			 * SequenceAux sAux = new SequenceAux(s); sAux.setEssaiAux(e);
			 * sequenceAuxService.enregistrerSequenceAux(sAux);
			 * 
			 * }
			 * 
			 */
		}
		
		System.out.println("id rapportAux: " + rapportAux.getId());
		List<EssaiAux> listeEssaisAux = rapportAux.getEssaisAux();
		System.out.println("taille liste d'essai dans rapport: " + listeEssaisAux.size());
		/*
		int i = 0;
		for (EssaiAux es : essaisAux) {
			
			i = 0;
			Integer id = es.getId();
			Essai essai = essaiService.obtenirEssaiParId(id);

			List<Sequence> seqs = essai.getSequences();
			
			for (Sequence s : seqs) {
				
				SequenceAux sAux = new SequenceAux(s);
				EssaiAux essAux = listeEssaisAux.get(i);
				sAux.setEssaiAux(essAux);
				sequenceAuxService.enregistrerSequenceAux(sAux);
			}
			
			i++;
		}
		*/
	}

	
	////////////////////////////////////////////////////////////
	
	
	public RapportAux obtenirRapportParId(Integer idRapport) {

		Rapport rap = rapportRepo.getOne(idRapport);
		RapportAux rapport = new RapportAux(rap);
		return rapport;
	}

	public Rapport rapportParId(Integer idRapport) {

		Rapport rapport = rapportRepo.getOne(idRapport);
		return rapport;
	}

	public void enregistrerDataRapport(Rapport rapport) {

		rapportRepo.save(rapport);

	}

}
