package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.EssaiData;
import com.michel.lab.model.SequenceData;

public interface SequenceDataRepo extends JpaRepository<SequenceData, Integer>{

}
