package com.michel.lab.security;


import java.security.Signature;

import org.springframework.stereotype.Component;

import com.michel.lab.constants.Constants;
import com.michel.lab.model.Utilisateur;

import com.michel.lab.model.UtilisateurAux;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTGenerator {
	
	public String generate(Utilisateur jwtUser) {
		
		Claims claims = Jwts.claims()
				.setSubject(jwtUser.getUsername());
		claims.put(Constants.USER_ID, String.valueOf(jwtUser.getId()));
		claims.put(Constants.ROLE, jwtUser.getRole());
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, Constants.YOUR_SECRET)
				.compact();
	}

	


}
