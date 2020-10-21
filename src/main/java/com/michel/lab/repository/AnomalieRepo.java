package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Anomalie;
import com.michel.lab.model.Defaut;

public interface AnomalieRepo extends JpaRepository<Anomalie, Integer>{

}
