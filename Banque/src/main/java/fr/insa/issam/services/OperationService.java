package fr.insa.issam.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import fr.insa.issam.models.Client;
import fr.insa.issam.models.Compte;
import fr.insa.issam.repositories.ClientRepository;
import fr.insa.issam.ressources.dto.OperationCreateModel;
import fr.insa.issam.exception.FonctionnalProcessException;
import fr.insa.issam.models.Operation;
import fr.insa.issam.repositories.OperationRepository;
import fr.insa.issam.ressources.dto.OperationCreateModel;


@Service
public class OperationService {

	@Autowired
	private OperationRepository operationRepository;
	
	public List<Operation> getListOperation(){
		
		return this.operationRepository.findAll();
		
	}
	

    /**
     * Save an operation in the databse
     * @param operationToCreate Model of the operation to create.
     * @return The entity saved in database @see Operation
     */
    @Transactional(rollbackOn = Exception.class)
    public Operation saveOperation(OperationCreateModel operationToCreate) throws FonctionnalProcessException {

//        Operation s = Operation.builder()
//                .typeOperation(operationToCreate.getTypeOperation())
//                .montant(operationToCreate.getMontant())
//                .compte(operationToCreate.getCodeCompte())
//                .build();
    	Operation s = new Operation() {
    		
		};
        return this.operationRepository.save(s);
    }
}
