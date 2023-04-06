package com.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.Client;
import com.restapi.service.ClientService;

@RestController
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	//method to get all user
	@GetMapping("/api/clients")
	public Iterable<Client> getAllClient(){
		return clientService.getAll();
	}
	
	@PostMapping("/api/clients")
	public Client addUser(@RequestBody Client client) {
		return clientService.add(client);
	}
	
	@GetMapping("/api/clients/{id}")
	public ResponseEntity<?> findUser(@PathVariable Integer id){
		Client foundClient=clientService.find(id);
		//System.out.println(foundUser);
		if(foundClient == null) {
			return new ResponseEntity<>("Client Not Found",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(foundClient,HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/api/clients/{id}")
	public String deleteUser(@PathVariable Integer id) {
		clientService.delete(id);
		return "Client Deleted";
	}
	
	@PutMapping("/api/clients/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody Client client) {
		Client updateClient=clientService.update(id, client);
		if(updateClient == null) {
			return new ResponseEntity<>("Client Not Found",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(updateClient,HttpStatus.OK);
		}
	}
}
