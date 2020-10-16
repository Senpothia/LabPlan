package com.michel.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Demande;
import com.michel.lab.model.Site;

public interface SiteRepo extends JpaRepository<Site, Integer>{

}
