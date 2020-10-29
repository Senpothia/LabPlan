package com.michel.lab.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Repetition;
import com.michel.lab.repository.RepetitionRepo;
import com.michel.lab.service.IRepetitionService;

@Service
public class RepetitionService implements IRepetitionService {
	
	@Autowired
	RepetitionRepo repetitionRepo;
	
	public void enregistrerRepetition(Repetition repetition) {
		
		repetitionRepo.save(repetition);
		
	}

}
