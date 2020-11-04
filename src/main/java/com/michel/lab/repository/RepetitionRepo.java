package com.michel.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Defaut;
import com.michel.lab.model.Of;
import com.michel.lab.model.Repetition;

public interface RepetitionRepo extends JpaRepository<Repetition, Integer> {

	List<Repetition> findByOf(Of o);

}
