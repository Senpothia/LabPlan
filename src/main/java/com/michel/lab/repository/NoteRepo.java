package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Essai;
import com.michel.lab.model.Note;

public interface NoteRepo extends JpaRepository<Note, Integer>{

}
