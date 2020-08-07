package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Essai;
import com.michel.lab.model.FormSequence;
import com.michel.lab.model.Sequence;
import com.michel.lab.repository.EchantillonRepo;
import com.michel.lab.repository.EssaiRepo;
import com.michel.lab.repository.QualificationRepo;
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

	
	public List<Sequence> obtenirSequencesParEssai(Integer num) {
		
		Essai essai = essaiService.obtenirEssaiParId(num);
		List<Sequence> sequences = essai.getSequences();
		return sequences;
	}

	public void enregistrerSequence(FormSequence formSequence) {
		
		
		System.out.println("méthode enregistrerSequence dans le service");
		System.out.println(formSequence.toString());
		
		
		Sequence sequence = new Sequence();
		sequence.setNumero(formSequence.getNumero());
		sequence.setNom(formSequence.getNom());
		sequence.setNiveau(formSequence.getNiveau());
		sequence.setDebut(formSequence.getDebut());
		sequence.setFin(formSequence.getFin());
		sequence.setProfil(formSequence.getProfil());
		sequence.setCommentaire(formSequence.getCommentaire());
		
		Essai essai = essaiService.obtenirEssaiParId(formSequence.getEssai());
		sequence.setEssai(essai);
		
		sequenceRepo.save(sequence);
		
	}
	
	

}
