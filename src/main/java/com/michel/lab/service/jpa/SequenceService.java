package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Essai;
import com.michel.lab.model.Sequence;
import com.michel.lab.repository.EchantillonRepo;
import com.michel.lab.repository.EssaiRepo;
import com.michel.lab.repository.QualificationRepo;

@Service
public class SequenceService {
	
	@Autowired
	EchantillonRepo echantillonRepo;
	
	@Autowired
	QualificationRepo qualificationRepo;
	

	@Autowired
	EssaiService essaiService;

	public List<Sequence> obtenirSequencesParEssai(Integer num) {
		
		Essai essai = essaiService.obtenirEssaiParId(num);
		List<Sequence> sequences = essai.getSequences();
		return sequences;
	}
	
	

}
