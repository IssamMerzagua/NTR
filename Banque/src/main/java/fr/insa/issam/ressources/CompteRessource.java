package fr.insa.issam.ressources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.issam.models.Compte;
import fr.insa.issam.repositories.CompteRepository;

@RestController
@RequestMapping("comptes")
public class CompteRessource {

	@Autowired
	private CompteRepository compteRepository;
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Compte> getAllComptes(@RequestParam(name= "id", required = false, 
													defaultValue = "1") String codeCompte){

		return  this.compteRepository.findAll();

	}
}
