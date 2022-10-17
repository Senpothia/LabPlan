package com.michel.lab.service.jpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Echantillon;
import com.michel.lab.model.Essai;
import com.michel.lab.model.FormSequence;
import com.michel.lab.model.Sequence;
import com.michel.lab.model.SequenceData;
import com.michel.lab.repository.EchantillonRepo;
import com.michel.lab.repository.EssaiRepo;
import com.michel.lab.repository.QualificationRepo;
import com.michel.lab.repository.SequenceDataRepo;
import com.michel.lab.repository.SequenceRepo;

@Service
public class SequenceService {

	@Autowired
	EchantillonRepo echantillonRepo;

	@Autowired
	QualificationRepo qualificationRepo;

	@Autowired
	EssaiService essaiService;

	@Autowired
	SequenceRepo sequenceRepo;

	@Autowired
	SequenceDataRepo sequenceDataRepo;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");

	// LocalDateTime.parse(finText, DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm
	// a"));
	public List<Sequence> obtenirSequencesParEssai(Integer num) {

		Essai essai = essaiService.obtenirEssaiParId(num);
		List<Sequence> sequences = essai.getSequences();
		return sequences;
	}

	public void enregistrerSequence(FormSequence formSequence) {

		
		Sequence sequence = new Sequence();
		sequence.setNumero(formSequence.getNumero());
		sequence.setNom(formSequence.getNom());
		sequence.setNiveau(formSequence.getNiveau());
		sequence.setDebut(formSequence.getDebut()); // à modifier
		sequence.setFin(formSequence.getFin()); // à modifier

		// sequence.setDebut(LocalDateTime.parse(formSequence.getDebutText(),
		// formatter)); // ajouter
		// sequence.setFin(LocalDateTime.parse(formSequence.getFinText(), formatter));
		// // ajouter

		sequence.setProfil(formSequence.getProfil());
		sequence.setStatut(true);
		sequence.setResultat(false);
		sequence.setCommentaire(formSequence.getCommentaire());

		Essai essai = essaiService.obtenirEssaiParId(formSequence.getEssai());
		sequence.setEssai(essai);

		sequenceRepo.save(sequence);

	}

	public Sequence obtenirSequenceParId(Integer id) {

		Sequence sequence = sequenceRepo.getOne(id);

		return sequence;
	}

	public void modifierSequence(FormSequence formSequence) {

		Integer id = formSequence.getId();
		Sequence sequence = sequenceRepo.getOne(id);

		sequence.setNumero(formSequence.getNumero());
		sequence.setNom(formSequence.getNom());
		sequence.setNiveau(formSequence.getNiveau());
		sequence.setDebut(formSequence.getDebut());
		sequence.setFin(formSequence.getFin());
		sequence.setProfil(formSequence.getProfil());
		sequence.setCommentaire(formSequence.getCommentaire());
		
		String actif = formSequence.getActif();
	
		if (actif.equals("Ouverte")) {

			sequence.setStatut(true);
			
		}
		
		if (actif.equals("Clôturée")) {

			sequence.setStatut(false);
			
		}
		
		String avis = formSequence.getAvis();
		if (avis.equals("Active")) {

			//sequence.setStatut(true);
			sequence.setResultat(false);
		}

		if (avis.equals("Conforme")) {

			sequence.setStatut(false);
			sequence.setResultat(true);
		}
		
		if (avis.equals("Non-conforme")) {

			sequence.setStatut(false);
			sequence.setResultat(false);
		}
		

		sequenceRepo.save(sequence);

	}

	public void ajouterEchantillon(Sequence seq) {

		sequenceRepo.save(seq);

	}

	public void retirerEchantillon(Sequence seq) {

		sequenceRepo.save(seq);

	}

	public List<Echantillon> obtenirSelectionEchantillon(Integer idSequence) {

		Sequence sequence = sequenceRepo.getOne(idSequence);
		List<Echantillon> echantillons = sequence.getEchantillons();

		return echantillons;
	}

	public void supprimerSequence(Sequence sequence) {

		sequenceRepo.delete(sequence);
	}

	public void ajouterSequence(Sequence seq) {

		sequenceRepo.save(seq);

	}

	public void ajouterSequenceData(SequenceData seqData) {

		sequenceDataRepo.save(seqData);

	}

	public void supprimerSequenceData(SequenceData s) {

		sequenceDataRepo.delete(s);

	}

}
