package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Qualification;

public interface QualificationRepo extends JpaRepository<Qualification, Integer> {

}
