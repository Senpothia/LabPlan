package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Qualification;
import com.michel.lab.model.SequenceAux;

public interface SequenceAuxRepo extends JpaRepository<SequenceAux, Integer>{

}
