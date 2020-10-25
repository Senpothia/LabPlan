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

import com.michel.lab.model.Anomalie;
import com.michel.lab.model.FormAnomalie;
import com.michel.lab.model.FormOf;
import com.michel.lab.model.Of;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.service.jpa.AnomalieService;
import com.michel.lab.service.jpa.OfService;
import com.michel.lab.service.jpa.UserService;

@RestController
@RequestMapping("/lab-service/private/gestion/usine")
public class UsineController {
	
	@Autowired
	OfService ofService;
	
	@Autowired
	UserService UserService;
	
	@Autowired
	AnomalieService anomalieService;
	
	@PostMapping("/of/enregistrer")
	public void enregistrerOf(@RequestHeader("Authorization") String token, @RequestBody FormOf formOf) {
		
	ofService.enregistrerOf(formOf);
		
	}
	
	@GetMapping("/of/liste")
	public List<FormOf> obtenirListeOfs(@RequestHeader("Authorization") String token){
		
		List<Of> ofs = ofService.listeDesOfs();
		List<FormOf> listeOfs = new ArrayList<FormOf>();
		for(Of o: ofs) {
			
			FormOf f = new FormOf(o);
			listeOfs.add(f);
		}
		
		return listeOfs;
	}
	
	@PostMapping("/of/voir")
	public FormOf obtenirOfParId(@RequestHeader("Authorization")  String token, @RequestBody Integer id) {
		
		Of of = ofService.obtenirOfParId(id);
		FormOf formOf = new FormOf(of);
		return formOf;
	}
	
	@PostMapping("/anomalie/enregistrer")
	public void enregistrerAnomalie(@RequestHeader("Authorization") String token, @RequestBody FormAnomalie formAnomalie){
		
		Utilisateur controleur = UserService.obtenirUser(formAnomalie.getControleur());
		Anomalie anomalie = new Anomalie(formAnomalie, controleur);
		anomalieService.enregistrerAnomalie(anomalie);
		
	}
	
	@GetMapping("/anomalies/liste")
	public List<FormAnomalie> obtenirListeAnomalies(@RequestHeader("Authorization") String token){
		
		List<Anomalie> anomalies = anomalieService.obtenirListeAnomalies();
		List<FormAnomalie> listeAnomalies = new ArrayList<FormAnomalie>();
		for(Anomalie a: anomalies) {
			
			FormAnomalie f = new FormAnomalie(a);
			listeAnomalies.add(f);
		}
		
		
		return listeAnomalies;
	}
	
	@PostMapping("/anomalie")
	public FormAnomalie obtenirAnomalieParId(
			@RequestHeader("Authorization")String token, 
			@RequestBody Integer id) {
		
		Anomalie anomalie = anomalieService.obtenirAnomalieParId(id);
		FormAnomalie formAnomalie = new FormAnomalie(anomalie);
		return formAnomalie;
	}
	
	
	
}