package com.michel.lab.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Domaine;
import com.michel.lab.repository.DomaineRepo;
import com.michel.lab.repository.QualificationRepo;
import com.michel.lab.service.IDomaineService;
import com.michel.lab.service.IQualificationService;

@Service
public class DomaineService implements IDomaineService {

	@Autowired
	DomaineRepo domaineRepo;

	@Override
	public void ajouterDomaine(Domaine domaine) {

		System.out.println("Méthode ajouterDomaine");

		List<Domaine> domaines = domaineRepo.findAll();

		System.out.println("nom domaine récupéré:" + domaine.getNom());
		System.out.println("Taille liste des domaines récupérée: " + domaines.size());
		
		if (domaines.size() != 0) {

			for (Domaine dom : domaines) {

				System.out.println("nom domaine dom:" + dom.getNom());

				if (domaines.size() != 0) {

					if (dom.getNom().equals(domaine.getNom())) {

						System.out.println("Le domaine existe déjà");

					} else {

						System.out.println("Enregistrement du domaine");
						domaineRepo.save(domaine);
					}

				} else {

					System.out.println("Enregistrement du domaine");
					domaineRepo.save(domaine);
				}

			}

		} else {
			
			System.out.println("Enregistrement du domaine quand taille liste domaine = 0");
			domaineRepo.save(domaine);
		}

	}

	@Override
	public void modifierDomaine(Domaine domaine) {

		domaineRepo.save(domaine);

	}

	public List<Domaine> obtenirDomaine(String nomDomaine) {

		List<Domaine> domaines = domaineRepo.findByNom(nomDomaine);
		return domaines;
	}

	@Override
	public List<Domaine> TousLesDomaines() {
		List<Domaine> domaines = domaineRepo.findAll();

		return domaines;
	}

	@Override
	public List<String> tousLesNomsDomaines() {
		List<Domaine> domaines = domaineRepo.findAll();
		List<String> nomsDomaines = new ArrayList<String>();

		for (Domaine dom : domaines) {

			nomsDomaines.add(dom.getNom());

		}

		return nomsDomaines;
	}

}
