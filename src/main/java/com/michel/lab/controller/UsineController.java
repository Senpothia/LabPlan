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

import com.michel.lab.model.FormOf;
import com.michel.lab.model.Of;
import com.michel.lab.service.jpa.OfService;

@RestController
@RequestMapping("/lab-service/private/gestion/usine")
public class UsineController {
	
	@Autowired
	OfService ofService;
	
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
	public FormOf obtenirOfParId(@RequestHeader("Authorization")  String token, Integer id) {
		
		Of of = ofService.obtenirOfParId(id);
		FormOf formOf = new FormOf(of);
		return formOf;
	}
	
	

}
