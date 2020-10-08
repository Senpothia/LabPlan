package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Site;
import com.michel.lab.repository.SiteRepo;
import com.michel.lab.service.IDemandeService;
import com.michel.lab.service.ISiteService;

@Service
public class SiteService implements ISiteService{
	
	@Autowired
	SiteRepo siteRepo;

	public void enregistrerSite(Site site) {
		
		siteRepo.save(site);
		System.out.println("enregistrement site");
		
	}

	public List<Site> obtenirListeSites() {
		List<Site> sites = siteRepo.findAll();
		return sites;
	}

	

}
