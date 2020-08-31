package com.michel.lab.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Note;
import com.michel.lab.repository.DomaineRepo;
import com.michel.lab.repository.NoteRepo;
import com.michel.lab.service.IDomaineService;
import com.michel.lab.service.INoteService;

@Service
public class NoteService implements INoteService{

	
	@Autowired
	NoteRepo noteRepo;
	
	@Override
	public void ajouterNote(Note note) {
		
		noteRepo.save(note);
	}

}
