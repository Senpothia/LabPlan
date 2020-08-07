package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Essai;

public interface EssaiRepo extends JpaRepository<Essai, Integer> {

	Essai findByNumero(Integer num);

}
