package com.michel.lab.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.SequenceAux;
import com.michel.lab.repository.SequenceAuxRepo;
import com.michel.lab.service.ISequenceAuxService;

@Service
public class SequenceAuxService implements ISequenceAuxService{
	
	@Autowired
	SequenceAuxRepo sequenceAuxRepo;

	public void enregistrerSequenceAux(SequenceAux s) {

		sequenceAuxRepo.save(s);
		
	}

	public void supprimerSequenceAux(SequenceAux s) {

		sequenceAuxRepo.delete(s);
		
	}

}
