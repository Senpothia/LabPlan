package com.michel.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michel.lab.model.Defaut;
import com.michel.lab.model.Recurrence;
import com.michel.lab.model.Site;


public interface RecurrenceRepo extends JpaRepository<Recurrence, Integer> {

	List<Recurrence> findByDefaut(Defaut defaut);

	List<Recurrence> findBySite(Site site);

	Recurrence findByDefautAndSite(Defaut defaut, Site site);

	
 


}
