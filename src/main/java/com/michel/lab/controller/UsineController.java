package com.michel.lab.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.michel.lab.model.Repetition;
import com.michel.lab.model.RepetitionAux;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.service.jpa.AnomalieService;
import com.michel.lab.service.jpa.OfService;
import com.michel.lab.service.jpa.RepetitionService;
import com.michel.lab.service.jpa.UserService;

@RestController
@RequestMapping("/private/gestion/usine")
public class UsineController {
	
	@Autowired
	OfService ofService;
	
	@Autowired
	UserService UserService;
	
	@Autowired
	AnomalieService anomalieService;
	
	@Autowired
	RepetitionService repetitionService;
	
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
	
	@PostMapping("/anomalie/produits")
	public List<String> listeProduitsAvecAnomalie(@RequestHeader("Authorization") String token){
		
		List<String> produits = anomalieService.obtenirListeProduits();
		
		return produits;
	}
	
	@PostMapping("/anomalie/produit")
	public List<FormAnomalie> obtenirAnomaliesParProduit(@RequestHeader("Authorization") String token, @RequestBody String produit){
		
		List<Anomalie> anomalies = anomalieService.obtenirListeAnomalieProduit(produit);
		List<FormAnomalie> listeAnomalies = new ArrayList<FormAnomalie>();
		for(Anomalie a: anomalies) {
			
			FormAnomalie f = new FormAnomalie(a);
			listeAnomalies.add(f);
		}
		return listeAnomalies;
	}
	
	@PostMapping("/of/anomalies")
	public List<FormAnomalie> obtenirAnomalieParOf(@RequestHeader("Authorization") String token, @RequestBody Integer id){
		
		List<Repetition> repetitions = repetitionService.obtenirRepetitionsParOf(id);
		List<FormAnomalie> anomalies = new ArrayList<FormAnomalie>();
		for(Repetition r: repetitions) {
			
			Anomalie a = r.getAnomalie();
			FormAnomalie f = new FormAnomalie(a);
			f.setTotal(r.getTotal());
			anomalies.add(f);		}
	
		return anomalies;
	}
	
	@PostMapping("/of/produit")
	public List<FormOf> obtenirOfsParProduit(@RequestHeader("Authorization") String token, @RequestBody String produit){
		
		List<Of> ofs = ofService.obtenirOfsParProduit(produit);
		List<FormOf> listeOfs = new ArrayList<FormOf>();
		for(Of o: ofs) {
			
			FormOf f = new FormOf(o);
			listeOfs.add(f);
					
		}
		
		return listeOfs;
	}
	
	@PostMapping("/enregistrer/repetition")
	public void enregistrerRepetition(@RequestHeader("Authorization") String token, @RequestBody RepetitionAux repetitionAux) {
		
		Repetition repetition = new Repetition();
		Anomalie anomalie = anomalieService.obtenirAnomalieParId(repetitionAux.getAnomalie());
		Of of = ofService.obtenirOfParId(repetitionAux.getOf());
		repetition.setAnomalie(anomalie);
		repetition.setOf(of);
		repetition.setTotal(repetitionAux.getTotal());
		repetitionService.enregistrerRepetition(repetition);
	
	}
	
	@PostMapping("/repetitions/of")
	public List<RepetitionAux> obtenirRepetitionsParOf(@RequestHeader("Authorization") String token, @RequestBody Integer of) {
		
		List<Repetition> repetitions = repetitionService.obtenirRepetitionsParOf(of);
		List<RepetitionAux> listeRepetitions = new ArrayList<RepetitionAux>();
		for(Repetition r: repetitions) {
			
			RepetitionAux rep = new RepetitionAux(r);
			listeRepetitions.add(rep);
			
		}
		
		return listeRepetitions;
	}
	
	@PostMapping("/modifier/of")
	public void modifierOf(@RequestHeader("Authorization") String token,  @RequestBody FormOf formOf) {
	
	Of of = ofService.obtenirOfParId(formOf.getId());
	of.setCode(formOf.getCode());
	of.setDate(LocalDateTime.parse(formOf.getDate()+ " " + "00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	of.setNumero(formOf.getNumero());
	of.setProduit(formOf.getProduit());
	of.setTaille(formOf.getTaille());
	ofService.modifierOf(of);

	}
	
	@PostMapping("/supprimer/of")
	public void supprimerOf(@RequestHeader("Authorization") String token, @RequestBody Integer id) {
		
		ofService.supprimerOfParId(id);
	}
	
	@PostMapping("/modifier/anomalie")
	public void modifierAnomalie(@RequestHeader("Authorization") String token, @RequestBody FormAnomalie formAnomalie) {
	
	anomalieService.modifierAnomalie(formAnomalie);
	}
	
	@PostMapping("/supprimer/anomalie")
	public void supprimerAnomalie(@RequestHeader("Authorization") String token, @RequestBody Integer id) {
		
		anomalieService.supprimerAnomalie(id);
	}
	
	
}
