package fr.insa.issam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.insa.issam.models.Compte;
import fr.insa.issam.repositories.CompteRepository;

@Service
public class CompteService {

	@Autowired
	private CompteRepository compteRepository;
	
	public List<Compte> getListCompte(){
		
		return (List<Compte>) this.compteRepository.findAll();
		
	}
}
