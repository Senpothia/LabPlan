package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Sequence;

public interface SequenceRepo extends JpaRepository<Sequence, Integer> {

}
