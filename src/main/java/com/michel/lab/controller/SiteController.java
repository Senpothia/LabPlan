package com.michel.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michel.lab.model.FormSite;
import com.michel.lab.model.Site;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.service.jpa.SiteService;
import com.michel.lab.service.jpa.UserService;

@RestController
@RequestMapping("/lab-service/private/activite/site")

public class SiteController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SiteService siteService;

	
	@PostMapping("/enregistrer")
	public void enregistrerSite(@RequestBody FormSite formSite) {
		
	System.out.println("Entrée enregistrement site");	
	Integer idCommercial = formSite.getCommercial();
	Utilisateur commercial = userService.obtenirUser(idCommercial);
	Site site = new Site(formSite, commercial);
	
	siteService.enregistrerSite(site);
	
		
	}
}
