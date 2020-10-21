package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Defaut;
import com.michel.lab.model.Repetition;

public interface RepetitionRepo extends JpaRepository<Repetition, Integer> {

}
