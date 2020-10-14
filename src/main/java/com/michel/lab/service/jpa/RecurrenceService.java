package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Recurrence;
import com.michel.lab.repository.RecurrenceRepo;
import com.michel.lab.service.IRecurrenceService;


@Service
public class RecurrenceService implements IRecurrenceService{
	
	@Autowired
	RecurrenceRepo recurrenceRepo;

	public void ajouterRecurrence(Recurrence recurrence) {
		
		recurrenceRepo.save(recurrence);
		
	}

	
	
}
