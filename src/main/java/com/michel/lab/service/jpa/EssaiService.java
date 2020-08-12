package com.michel.lab.service.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michel.lab.model.Essai;
import com.michel.lab.model.EssaiAux;
import com.michel.lab.model.FormEssai;
import com.michel.lab.model.Qualification;
import com.michel.lab.repository.EssaiRepo;
import com.michel.lab.repository.ProcedureRepo;
import com.michel.lab.repository.QualificationRepo;
import com.michel.lab.service.IEssaiService;

@Service
public class EssaiService  implements IEssaiService{
	
	
	@Autowired
	EssaiRepo essaiRepo;
	
	@Autowired
	ProcedureRepo userRepo;
	
	@Autowired
	QualificationRepo qualificationRepo;
	
	public void ajouterEssai(Essai essai) {
		
		essaiRepo.save(essai);
	}

	@Override
	public void ajouterEssai(Integer id, Integer qualification, Integer utilisateur) {
		// TODO Auto-generated method stub
		
	}

	public Essai obtenirParId(Integer idEssai) {
		
		Essai essai = essaiRepo.getOne(idEssai);
		return essai;
	}

	public List<EssaiAux> obtenirEssaisParQualification(Integer qualification) {
		
		Qualification qualif = qualificationRepo.findByNumero(qualification);
		List<Essai> essais = qualif.getEssais();
		List<EssaiAux> listeEssais = new ArrayList<EssaiAux>();
		
		for (Essai es:essais) {
			
			EssaiAux esAux = new EssaiAux(es);
			listeEssais.add(esAux);
			
		}
		
		return listeEssais;
	}

	public Essai obtenirEssaiParNum(Integer num) {  // num = id de l'essai

		Essai essai = essaiRepo.getOne(num);
		return essai;
	}

	@Override
	public Essai obtenirEssaiParId(Integer id) {
		
		Essai essai = essaiRepo.getOne(id);
		return essai;
	}

	

	public void modifierEssai(FormEssai formEssai) {
		
		Integer idEssai = formEssai.getId();
		Essai essai = essaiRepo.getOne(idEssai);
		String statut = formEssai.getStatut();
		String resultat =  formEssai.getResultat();
		
		if (resultat.equals("Conforme")) {
			
			essai.setResultat(true);
			
		} else {
			
			essai.setResultat(false);
			
		}
		
		if (statut.equals("Ouverte")){
			
			essai.setStatut(true);
			
		}else {
			
			essai.setStatut(false);
			
		}
		
		essaiRepo.save(essai);
		
	}


}
