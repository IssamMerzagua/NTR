/**
 * 
 */
package fr.insa.issam.controleur;

import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.insa.issam.metier.IAgenceMetier;
import fr.insa.issam.models.Client;
import fr.insa.issam.models.Compte;
import fr.insa.issam.models.CompteCourant;
import fr.insa.issam.models.CompteEpargne;
import fr.insa.issam.models.Operation;
import fr.insa.issam.repositories.ClientRepository;
import fr.insa.issam.repositories.CompteRepository;

/**
 * @author Issam
 *
 */

@Controller
public class AgenceController {

	@Autowired
	private IAgenceMetier agenceMetier;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired 
	private CompteRepository compteRepository;
	
	@RequestMapping(value= {"/","index"},method=RequestMethod.GET)
	public String index() {
		
		return "comptes";
	}
	
	@RequestMapping(value="/consulterCompte")
	public String consulter(Model model, String codeCompte,
			@RequestParam(name="page", defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size) {
		// On appelle la couche metier pour consulter un compte
		try {
			Compte compte = agenceMetier.consulterCompte(codeCompte);
			model.addAttribute("compte", compte);
			
			Page<Operation> pageOperations = agenceMetier.listOperation(codeCompte, page, size);
			model.addAttribute("listOperations", pageOperations.getContent());
			int[] pages = new int[pageOperations.getTotalPages()];
			model.addAttribute("pages",pages);
			model.addAttribute("pageCourante", page);
			
		}catch(Exception e) {
			model.addAttribute("exception", e);
		}
		
		return "comptes";
	}
	
	@RequestMapping(value="/saveOperation",method=RequestMethod.POST)
	public String saveOperation(Model model,String typeOperation,String codeCompte,double montant,String codeCompte2) {
		try {
			if(typeOperation.equals("versement")) {
				agenceMetier.verser(codeCompte, montant);
			}
			else if(typeOperation.equals("retrait")) {
				agenceMetier.retirer(codeCompte, montant);
			}
			else if(typeOperation.equals("virement")){ 
				agenceMetier.virement(codeCompte, codeCompte2, montant);
			}
		}catch(Exception e) {
			model.addAttribute("error", e);
			return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
		}
		
		return "redirect:/consulterCompte?codeCompte="+codeCompte;
	}
	
	@RequestMapping(value="/nouveauCompte")
	String creerCompte() {
		
		return "creerCompte";
	}
	
	@RequestMapping(value="/supprimerCompte")
	String supprimerCompte() {
		
		return "supprimerCompte";
	}
	
	@RequestMapping(value="/creer",method=RequestMethod.POST)
	public String creerNouveauCompte(String codeCompte, String nom, 
							  		 String email, String typeCompte,
							  		 String decouvert, String taux,
							  		 String solde) {
		
		double _solde = Double.parseDouble(solde);
		
		Client client=clientRepository.save(new Client(nom,email));
		System.out.println("=============::"+typeCompte+"========::=======");
		if(typeCompte.contentEquals("compteCourant")) {
			double _decouvert = Double.parseDouble(decouvert);
			compteRepository.save(new CompteCourant(codeCompte,new Date(),_solde,client,_decouvert));
		}
		
		if(typeCompte.contentEquals("compteEpargne")) {
			double _taux = Double.parseDouble(taux);
			compteRepository.save(new CompteEpargne(codeCompte,new Date(),_solde,client,_taux));
		}
		
		return "redirect:/";
	}
	
//	  @DeleteMapping("/supprimerCompte/{codeCompte}")
//	  public ResponseEntity<HttpStatus> supprimerCompte(@PathVariable("codeCompte") String codeCompte) {
//		    try {
//	    	compteRepository.deleteById(codeCompte);
//	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	    } catch (Exception e) {
//	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	  }
	
	  @RequestMapping(value="/supprimer", method=RequestMethod.DELETE)
	  public ResponseEntity<HttpStatus> supprimerCompte(String codeCompte) {
		    try {
	    	this.compteRepository.deleteById(codeCompte);
//	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	 return new ResponseEntity<>(HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PutMapping("/modifier/{codeCompte}")
	  public ResponseEntity<Compte> modifierCompte(@PathVariable("codeCompte") String codeCompte, @RequestBody Compte compte) {
	    Optional<Compte> compteData = compteRepository.findById(codeCompte);

	    if (compteData.isPresent()) {
	    	Compte _compte = compteData.get();
	    	_compte.setSolde(compte.getSolde());
	    	
	      return new ResponseEntity<>(compteRepository.save(_compte), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	      

}
