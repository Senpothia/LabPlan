package com.michel.lab.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michel.lab.model.Login;
import com.michel.lab.model.Utilisateur;
import com.michel.lab.model.UtilisateurAux;
import com.michel.lab.security.JWTGenerator;
import com.michel.lab.service.jpa.UserService;

@RestController
//@RequestMapping("/lab-service")
public class TokenController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	private JWTGenerator jwtGenerator;
	
	public TokenController(JWTGenerator jwtGenerator) {
		
		this.jwtGenerator = jwtGenerator;
	}
	
	@PostMapping("/connexion")
	public ResponseEntity<UtilisateurAux> generate(@RequestBody final Login login){
		
	
		Utilisateur jwtUser = new Utilisateur();
		jwtUser = existUtilisateur(login);
		
		if (jwtUser != null) {
			
			UtilisateurAux userAux = new UtilisateurAux();
			userAux.setId(jwtUser.getId()); 
			userAux.setNom(jwtUser.getNom());
			userAux.setPrenom(jwtUser.getPrenom());
			userAux.setRole("USER");
			userAux.setUsername(jwtUser.getUsername());
			String token = jwtGenerator.generate(jwtUser);
			userAux.setToken(token);
			return new ResponseEntity<UtilisateurAux>(userAux, HttpStatus.OK);
					
		}else {
			
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
		
 	}
	
	private Utilisateur existUtilisateur(Login login) {
		
	
		
		try {
			
		Utilisateur utilisateur = userService.obtenirUserParlogin(login.getUser(), login.getPassword());
		utilisateur.setRole("Admin");
	
		return utilisateur;
		
		} catch (Exception e) {
			
			
			return null;
		}

		
	}
	


}
