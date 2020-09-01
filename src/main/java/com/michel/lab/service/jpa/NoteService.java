package com.michel.lab.service.jpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Note;
import com.michel.lab.model.NoteAux;
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

	public NoteAux obtenirNoteParId(Integer idNote) {

		Note note = noteRepo.getOne(idNote);
		NoteAux noteAux = new NoteAux(note);
		
		return noteAux;
	}

	public void supprimerNote(Integer idNote) {
		
		Note note = noteRepo.getOne(idNote);
		noteRepo.delete(note);
	}

	public Note obtenirNoteReelleParId(Integer idNote) {
		
		Note note = noteRepo.getOne(idNote);
		return note;
	}

}
