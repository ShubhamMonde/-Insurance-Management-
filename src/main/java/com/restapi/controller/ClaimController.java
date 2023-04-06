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

import com.restapi.model.Claim;
import com.restapi.service.ClaimService;

@RestController
public class ClaimController {
	@Autowired
	private ClaimService claimService;
	
	@GetMapping("/api/claims")
	public Iterable<Claim> getAllClaim(){
		return claimService.getAll();
	}
	
	@PostMapping("/api/claims")
	public Claim addClaim(@RequestBody Claim claim) {
		return claimService.add(claim);
	}
	
	@GetMapping("/api/claims/{id}")
	public ResponseEntity<?> findClaim(@PathVariable Long id){
		Claim foundClaim=claimService.find(id);
		if(foundClaim == null) {
			return new ResponseEntity<>("Claim Not Found",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(foundClaim,HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/api/claims/{id}")
	public String deleteClaim(@PathVariable Long id) {
		claimService.delete(id);
		return "Claim Deleted";
	}
	
	@PutMapping("/api/claims/{id}")
	public ResponseEntity<?> updateClaim(@PathVariable Long id, @RequestBody Claim claim) {
		Claim updateClaim=claimService.update(id, claim);
		if(updateClaim == null) {
			return new ResponseEntity<>("Claim Not Found",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(updateClaim,HttpStatus.OK);
		}
	}

}
