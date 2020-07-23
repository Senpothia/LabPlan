package com.michel.lab.service.jpa;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Utilisateur;
import com.michel.lab.repository.UserRepo;
import com.michel.lab.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	PasswordEncoder encoder;

	@Override
	public List<Utilisateur> listerUsers() {

		List<Utilisateur> users = userRepo.findAll();
		return users;
	}

	@Override
	public Utilisateur obtenirUser(Integer id) {

		Utilisateur user = userRepo.getOne(id);
		return user;
	}

	@Override
	public Utilisateur obtenirUser(String string) {


		// User user = userRepo.findByIdentity(string);

		return null;
	}

	@Override
	public Utilisateur obtenirUserParEmail(String email) {

		Utilisateur user = userRepo.findByEmail(email);
		return user;
	}
	
	

	@Override
	public void ajouterUser(Utilisateur user) {

		String password = encoder.encode(user.getPassword());
		user.setPassword(password);
		userRepo.save(user);

	}

	@Override
	public void modifierUser(Utilisateur user) {
		userRepo.save(user);

	}

	@Override
	public void supprimerUser(Utilisateur user) {
		userRepo.delete(user);

	}

	public Utilisateur obtenirUserParlogin(String email, String password) {
		
		Utilisateur utilisateur = userRepo.findByEmail(email);
		if (encoder.matches(password, utilisateur.getPassword())){
			
			return utilisateur;

		} else

			return null;

	}

}
