package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Defaut;
import com.michel.lab.model.Recurrence;
import com.michel.lab.model.Site;
import com.michel.lab.repository.RecurrenceRepo;
import com.michel.lab.service.IRecurrenceService;


@Service
public class RecurrenceService implements IRecurrenceService{
	
	@Autowired
	RecurrenceRepo recurrenceRepo;

	public void ajouterRecurrence(Recurrence recurrence) {
		
		recurrenceRepo.save(recurrence);
		
	}

	public List<Recurrence> obtenirSites(Defaut defaut) {
		
		List<Recurrence> recurrences = recurrenceRepo.findByDefaut(defaut);
		return recurrences;
	}

	public List<Recurrence> obtenirDefautParSite(Site site) {
		List<Recurrence> recurrences = recurrenceRepo.findBySite(site);
		return recurrences;
	}

	
	
}
