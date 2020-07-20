package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Procedure;

public interface ProcedureRepo extends JpaRepository<Procedure, Integer> {

}
