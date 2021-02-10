package com.michel.lab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michel.lab.model.Defaut;
import com.michel.lab.model.FormIncident;
import com.michel.lab.model.FormSite;
import com.michel.lab.model.Recurrence;
import com.michel.lab.model.RecurrenceAux;
import com.michel.lab.model.Site;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.service.jpa.DefautService;
import com.michel.lab.service.jpa.RecurrenceService;
import com.michel.lab.service.jpa.SiteService;
import com.michel.lab.service.jpa.UserService;

@RestController
@RequestMapping("/private/activite/site")

public class SiteController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SiteService siteService;

	@Autowired
	DefautService defautService;
	
	@Autowired
	RecurrenceService recurrenceService;
	
	@PostMapping("/enregistrer")
	public void enregistrerSite(@RequestBody FormSite formSite) {
		
	System.out.println("Entrée enregistrement site");	
	Integer idCommercial = formSite.getCommercial();
	Utilisateur commercial = userService.obtenirUser(idCommercial);
	Site site = new Site(formSite, commercial);
	
	siteService.enregistrerSite(site);
	
		
	}
	
	@GetMapping("/liste")
	public List<FormSite> obtenirListeSites(){
		
		List<Site> sites = siteService.obtenirListeSites();
		List<FormSite> listeSites = new ArrayList<FormSite>();
		for(Site s: sites) {
			
			FormSite f = new FormSite(s);
			listeSites.add(f);
		}
		
		return listeSites;
	}
	
	
	@PostMapping("/defaut/enregistrer")
	public void enregistrerIncident(@RequestBody FormIncident formIncident)
	{
		Integer idCommercial = formIncident.getCommercial();
		Utilisateur commercial = userService.obtenirUser(idCommercial);
		Defaut defaut = new Defaut(formIncident, commercial);
		defautService.enregistrerDefaut(defaut);
		
		
	}
	
	@GetMapping("/defaut/liste")
	public List<FormIncident> obtenirListeIncident() {
		
		List<Defaut> defauts = defautService.obtenirListeDefauts();
		List<FormIncident> listeDefauts = new ArrayList<FormIncident>();
		
		for(Defaut d :defauts) {
			
			FormIncident f = new FormIncident(d);
			listeDefauts.add(f);
			
		}
		
		return listeDefauts;
		
	}
	
	@PostMapping("/defaut/produit")
	public List<FormIncident> obtenirDefautParProduit(@RequestBody String produit){
		
		List<Defaut> defauts = defautService.obtenirDefautParProduit(produit);
		List<FormIncident> incidents = new ArrayList<FormIncident>();
		for(Defaut d: defauts) {
			
			FormIncident f = new FormIncident(d);
			incidents.add(f);
			
		}
		
		return incidents;
	}
	
	@PostMapping("/defaut/produit/voir")
	public FormIncident obtenirDefautParId(@RequestBody Integer id) {
		
		
		Defaut defaut = defautService.obtenirDefautParId(id);
		FormIncident incident = new FormIncident(defaut);

		return incident;
		
	}
	
	@PostMapping("/get")
	public FormSite obtenirSiteParId(@RequestBody Integer idSite) {
		
		Site site = siteService.obtenirSiteParId(idSite);
		FormSite formSite = new FormSite(site);
		return formSite;
		
	}
	
	@PostMapping("/ajouter/recurrence")
	public void ajouterRecurrence(@RequestBody RecurrenceAux recurrenceAux) {
		
		Recurrence recurrence = new Recurrence();
		Site site = siteService.obtenirSiteParId(recurrenceAux.getSite());
		Defaut defaut = defautService.obtenirDefautParId(recurrenceAux.getDefaut());
		recurrence.setDefaut(defaut);
		recurrence.setSite(site);
		recurrence.setTotal(recurrenceAux.getNombre());
		recurrenceService.ajouterRecurrence(recurrence);
	
	}
	
	@PostMapping("/defaut/cartographier")
	public List<FormSite> cartographier(@RequestBody Integer idDefaut){
		
		
		Defaut defaut = defautService.obtenirDefautParId(idDefaut);
		
	
		List<Recurrence> recurrences = recurrenceService.obtenirSites(defaut);
		
		
		List<FormSite> listeSites = new ArrayList<FormSite>();
		for(Recurrence r: recurrences) {
			
			Site s = r.getSite();
			FormSite f = new FormSite(s);
			listeSites.add(f);
			
		}

		return listeSites;
	
	}
	
	@PostMapping("/defauts")
	public List<FormIncident> obtenirDefautsParSite(@RequestBody Integer id){
		
		Site site = siteService.obtenirSiteParId(id);
		List<Recurrence> recurrences = recurrenceService.obtenirDefautParSite(site);
		List<FormIncident> listeDefauts = new ArrayList<FormIncident>();
		for(Recurrence r: recurrences) {
			
			
			Defaut d = r.getDefaut();
			FormIncident f = new FormIncident(d);
			f.setRecurrence(r.getTotal());
			listeDefauts.add(f);
		}
		
 		return listeDefauts;
	}
	
	@PostMapping("/defaut/produit/recurrence")
	public FormIncident obtenirDefautParIdPourProduit(@RequestBody FormIncident formIncident) {
			
		Recurrence recurrence = recurrenceService.obtenirDefautParSiteProduit(formIncident.getId(), formIncident.getSite());
		formIncident.setRecurrence(recurrence.getTotal());
		return formIncident;
	}
	
	
}
