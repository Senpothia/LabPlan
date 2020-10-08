package com.michel.lab.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.michel.lab.model.Site2;

import com.michel.lab.repository.SiteRepo2;
import com.michel.lab.service.IDemandeService;

import com.michel.lab.service.ISiteService2;

@Service
public class SiteService2 implements ISiteService2{
	
	@Autowired
	SiteRepo2 siteRepo2;

	public void enregistrerSite(Site2 site) {
		
		siteRepo2.save(site);
		System.out.println("enregistrement site");
		
	}

	public List<Site2> obtenirListeSites() {
		List<Site2> sites = siteRepo2.findAll();
		return sites;
	}

	

}
