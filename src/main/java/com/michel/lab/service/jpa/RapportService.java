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
	RapportService rapportService;

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
		
		System.out.println("Version dans formulaire: "+ formInitRapport.getVersion());
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
		
		System.out.println("Version du rapportAux: " + rapportAux.getVersion());
		
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
		
		System.out.println("Taille liste d'essais récupérée en base: " + essaisAux.size());
		
		for (EssaiAux e : essaisAux) {
			
			EssaiAux essaiAuxRapport = e;  // copie de l'essai de qualif
			RapportAux esRapportAux = rapportAux;  
			essaiAuxRapport.setRapportAux(esRapportAux);

			essaiAuxService.enregistrerEssaiAux(essaiAuxRapport);
			
			List<SequenceAux> seqs =  e.getSequencesAux();
			
			System.out.println("Taille liste sequencesAux: " + seqs.size());
			
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
		
		System.out.println("Version rapport avant recherche en base: " + rapport.getVersion());
		RapportAux rapAux = rapportAuxService.obtenirRapportParVersion(rapport.getVersion());
		
		
		System.out.println("id rapportAux: " + rapAux.getId());
		
		
		List<EssaiAux> listeEssaisAux = rapAux.getEssaisAux();
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
	
	
	@Override
	public void enregistrerRapport2(FormInitRapport formInitRapport) {

		Rapport rapport = new Rapport();
		Integer idAuteur = formInitRapport.getAuteur();

		Utilisateur auteur = userService.obtenirUser(idAuteur);

		rapport.setAuteur(auteur);
		rapport.setDemande(formInitRapport.getDemande());
		rapport.setIdentifiant(formInitRapport.getIdentifiant());
		rapport.setObjet(formInitRapport.getObjet());
		rapport.setProjet(formInitRapport.getProjet());
		rapport.setTitre(formInitRapport.getTitre());
		
		System.out.println("Version dans formulaire: "+ formInitRapport.getVersion());
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
		
		
		//rapport.setDate(dateConvertie);

		//RapportAux rapportAux = new RapportAux(rapport);
		
		//rapportRepo.save(rapport);
		rapportAuxService.enregistrerRapportAux(rapportAux);
		
		System.out.println("Version du rapportAux: " + rapportAux.getVersion());
		
		rapport.setRapportAux(rapportAux);
		rapportRepo.save(rapport);
		
		List<EchantillonAux> echantillons = echantillonService.obtenirEchantillonParQualificationEnAux(numQualification);
		
		
		for (EchantillonAux e: echantillons) {
			
			EchantillonAux echCopie = e;
			echCopie.setRapport(rapport);
			echantillonAuxService.enregistrerEchantillonAux(echCopie);
		}
		
		
		List<EssaiAux> essais = essaiService.obtenirEssaisParQualification(numQualification);
		System.out.println("taille liste essai originel: " + essais.size());
		List<EssaiAux> listeEssaiCopie = new ArrayList<EssaiAux>();
		
		for (EssaiAux es: essais) {
			
			EssaiAux esCopie = new EssaiAux();
			esCopie = es;
			esCopie.setRapportAux(rapportAux);
			essaiAuxService.enregistrerEssaiAux(esCopie);
			listeEssaiCopie.add(esCopie);
		}
		
		System.out.println("taille de la liste copie essais: " + listeEssaiCopie.size());
		
		
		for (EssaiAux es: listeEssaiCopie) {
			
			
			Integer idEssai = es.getIdEssai();
			Essai essai = essaiService.obtenirEssaiParId(idEssai);
			System.out.println("id essai originel: " + essai.getId());
			List<Sequence> seqs = essai.getSequences();
			System.out.println("taille de la liste de sequence: " + seqs.size());
			
			
			for (Sequence s: seqs) {
				
				SequenceAux seqAux = new SequenceAux(s);
				//seqAux.setEssaiAux(es);
				System.out.println(seqAux.toString());
				sequenceAuxService.enregistrerSequenceAux(seqAux);
				
			}
			
		}
		
		
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
