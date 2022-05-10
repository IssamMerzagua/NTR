package fr.insa.issam.ressources;

import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.issam.models.Client;
import fr.insa.issam.repositories.ClientRepository;
import fr.insa.issam.exception.ModelNotValidException;
import fr.insa.issam.ressources.dto.ClientCreateModel;



@RestController
@RequestMapping("clients")
public class ClientRessource extends CommonResource {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Client> getAllClients(@RequestParam(name= "nom", 
													required = false, 
													defaultValue = "merzagua") 
													String nom){
		
		return (List<Client>) this.clientRepository.findAll();

	}
	
    private void validateClientModel(ClientCreateModel clientToCreate) throws ModelNotValidException {
        ModelNotValidException ex = new ModelNotValidException();

        if(clientToCreate == null) {
            ex.getMessages().add("ClientCreateModel : null");
        }

        if(clientToCreate.getEmail() == null || clientToCreate.getEmail().isBlank()) {
            ex.getMessages().add("email est vide");
        }
        if(clientToCreate.getName() == null || clientToCreate.getName().isBlank()) {
            ex.getMessages().add("name est vide");
        }

        if(!ex.getMessages().isEmpty()) {
            throw ex;
        }
    }
}
