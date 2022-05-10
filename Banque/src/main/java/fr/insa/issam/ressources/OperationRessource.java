package fr.insa.issam.ressources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.issam.models.Client;
import fr.insa.issam.models.Operation;
import fr.insa.issam.repositories.ClientRepository;
import fr.insa.issam.repositories.OperationRepository;
import fr.insa.issam.ressources.dto.OperationCreateModel;
import fr.insa.issam.services.OperationService;
import fr.insa.issam.exception.ModelNotValidException;
import fr.insa.issam.ressources.dto.OperationCreateModel;
import fr.insa.issam.exception.FonctionnalProcessException;
import fr.insa.issam.ressources.dto.OperationCreateModel;

@RestController
@RequestMapping("operations")
public class OperationRessource {

    @Autowired
    OperationService operationService;
	
	@GetMapping()
	public List<Operation> getAllOperations(@RequestParam(name= "type_op", 
													required = false, 
													defaultValue = "VI") 
													String nom){
		
		return null ;//this.operationService.findAll();
	}
	
    @PostMapping
    public Operation createOperation(@RequestBody OperationCreateModel operationToCreate) throws FonctionnalProcessException {
        validateOperationModel(operationToCreate);
        return this.operationService.saveOperation(operationToCreate);
    }
    
    private void validateOperationModel(OperationCreateModel operationToCreate) throws ModelNotValidException {
        ModelNotValidException ex = new ModelNotValidException();

        if(operationToCreate == null) {
            ex.getMessages().add("OperationCreateModel : null");
        }

        if(operationToCreate.getTypeOperation() == null || operationToCreate.getTypeOperation().isBlank()) {
            ex.getMessages().add("email est vide");
        }
        if(operationToCreate.getMontant() == 0 ) {
            ex.getMessages().add("name est vide");
        }
        if(operationToCreate.getCodeCompte() == null ||  operationToCreate.getCodeCompte().isBlank()) {
            ex.getMessages().add("firstname est vide");
        }
        if(!ex.getMessages().isEmpty()) {
            throw ex;
        }
    }
}
