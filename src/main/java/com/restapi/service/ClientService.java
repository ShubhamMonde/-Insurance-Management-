package com.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.model.Client;
import com.restapi.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;

	public Iterable<Client> getAll() {
		return clientRepository.findAll();
	}
	
	public Client add(Client client) {
		return clientRepository.save(client);
	}

	public Client find(Integer id) {
		return clientRepository.findById(id).orElse(null);
	}

	public void delete(Integer id) {
		clientRepository.deleteById(id);
		
	}

	public Client update(Integer id, Client client) {
		Client foundClient=this.find(id);
		if(foundClient == null)
			return null;
		else {
			client.setId(id);
			return clientRepository.save(client);			
		}
	}


}
