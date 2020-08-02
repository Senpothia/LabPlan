package com.michel.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Procedure;

public interface ProcedureRepo extends JpaRepository<Procedure, Integer> {

	List<Procedure> findByDomaineId(Integer id);

	
}
