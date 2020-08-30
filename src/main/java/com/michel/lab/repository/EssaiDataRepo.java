package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Domaine;
import com.michel.lab.model.EssaiData;

public interface EssaiDataRepo extends JpaRepository<EssaiData, Integer> {

}
