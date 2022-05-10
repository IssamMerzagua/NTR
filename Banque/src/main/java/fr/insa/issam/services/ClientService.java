package fr.insa.issam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.insa.issam.models.Client;
import fr.insa.issam.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getListClient(){
		
		return this.clientRepository.findAll();
		
	}

	
}
