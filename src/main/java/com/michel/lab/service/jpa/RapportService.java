package com.michel.lab.service.jpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Echantillon;
import com.michel.lab.model.EchantillonAux;
import com.michel.lab.model.EchantillonData;
import com.michel.lab.model.Essai;
import com.michel.lab.model.EssaiAux;
import com.michel.lab.model.EssaiData;
import com.michel.lab.model.FormInitRapport;
import com.michel.lab.model.Qualification;
import com.michel.lab.model.Rapport;
import com.michel.lab.model.RapportAux;
import com.michel.lab.model.Sequence;
import com.michel.lab.model.SequenceAux;
import com.michel.lab.model.SequenceData;
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
	EchantillonService echantillonService;
	
	@Autowired
	EssaiService essaiService;
	
	@Autowired
	SequenceService sequenceService;
	
	
	
	@Autowired
	RapportRepo rapportRepo;

	@Override
	public Integer enregistrerRapport(FormInitRapport formInitRapport) {
		
		System.out.println("rapportService  - Enregistrement rapport");
		Rapport rapport = new Rapport();
		Integer idAuteur = formInitRapport.getAuteur();
		System.out.println("idAuteur: " + idAuteur);
		
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
		System.out.println("Num qualification: " + numQualification);
		
		Qualification qualification = qualificationService.obtenirQualificationParNumero(numQualification);
		
		rapport.setQualification(qualification);
		String date = formInitRapport.getDate() + " " + "00:00 AM";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
		
		LocalDateTime dateConvertie = LocalDateTime.parse(date, formatter);
		
		System.out.println("date convertie: " + dateConvertie);
		rapport.setDate(dateConvertie);
		
		rapportRepo.save(rapport);
		
		Integer idRapport = rapport.getId();
		System.out.println("IdRapport enregistré: " + idRapport);
		
		List<Echantillon> echantillons = echantillonService.obtenirEchantillonParQualification(numQualification);
		System.out.println("Taille de la liste des échantillons de la qualification: " + echantillons.size());
		
		for(Echantillon e : echantillons) {
			
			EchantillonAux echAux = new EchantillonAux(e);
			EchantillonData echData = new EchantillonData(echAux);
			echData.setRapport(rapport);
			echantillonService.enregistrerEchData(echData);
			
		}
		
		
		List<Essai> essaiReel = qualification.getEssais();
		
		for(Essai ess: essaiReel) {
			
			EssaiAux esAux = new EssaiAux(ess);
			
			EssaiData esData = new EssaiData(esAux);
			esData.setRapport(rapport);
			essaiService.ajouterEssaiData(esData);
			
			List<Sequence> sequences = ess.getSequences(); 
			 
			for(Sequence s: sequences) {
				
				SequenceAux seqAux = new SequenceAux(s);
				SequenceData seqData = new SequenceData(seqAux);
				seqData.setEssaiData(esData);
				sequenceService.ajouterSequenceData(seqData);
				
			}
		}
	
		return idRapport;
		
	}

	public RapportAux obtenirRapportParId(Integer idRapport) {
		
		Rapport rap = rapportRepo.getOne(idRapport);
		RapportAux rapport = new RapportAux(rap);
		return rapport;
	}

	public Rapport obtenirRapport(Integer idRapport) {

		Rapport rapport = rapportRepo.getOne(idRapport);
		return rapport;
	}

	public void supprimerRapport(Integer idRapport) {
		
		Rapport rapport = rapportRepo.getOne(idRapport);
		List<EssaiData> essais = rapport.getEssais();
		
		for(EssaiData es: essais) {
			
			List<SequenceData> seqsData =  es.getSequences();
			for (SequenceData s: seqsData) {
				
			sequenceService.supprimerSequenceData(s);
			
			}
			
			essaiService.supprimerEssaisData(es);
			
		}
		
		List<EchantillonData> echantillons = rapport.getEchantillons();
		
		for(EchantillonData ech: echantillons) {
			
			echantillonService.supprimerEchantillonData(ech);
		}
		
		rapportRepo.delete(rapport);
		
	}

}
