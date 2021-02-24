package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Of;
import com.michel.lab.model.Repetition;
import com.michel.lab.repository.RepetitionRepo;
import com.michel.lab.service.IRepetitionService;

@Service
public class RepetitionService implements IRepetitionService {
	
	@Autowired
	RepetitionRepo repetitionRepo;
	
	@Autowired
	OfService ofService;
	
	public void enregistrerRepetition(Repetition repetition) {
		
		repetitionRepo.save(repetition);
		
	}

	public List<Repetition> obtenirRepetitionsParOf(Integer of) {
		
		Of o = ofService.obtenirOfParId(of);
		List<Repetition> repetitions = repetitionRepo.findByOf(o);
		return repetitions;
	}

}