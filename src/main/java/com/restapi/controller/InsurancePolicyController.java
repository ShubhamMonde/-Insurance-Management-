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
import com.restapi.model.InsurancePolicy;
import com.restapi.service.InsurancePolicyService;

@RestController
public class InsurancePolicyController {
	@Autowired
	private InsurancePolicyService insurancePolicyService;
	
	
	@GetMapping("/api/policies")
	public Iterable<InsurancePolicy> getAllInsurancePolicy(){
		return insurancePolicyService.getAll();
	}
	
	@PostMapping("/api/policies")
	public InsurancePolicy addInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
		return insurancePolicyService.add(insurancePolicy);
	}
	
	@GetMapping("/api/policies/{id}")
	public ResponseEntity<?> findInsurancePolicy(@PathVariable Long id){
		InsurancePolicy foundInsurancePolicy=insurancePolicyService.find(id);
		if(foundInsurancePolicy == null) {
			return new ResponseEntity<>("Insurance Policy Not Found",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(foundInsurancePolicy,HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/api/policies/{id}")
	public String deleteInsurancePolicy(@PathVariable Long id) {
		insurancePolicyService.delete(id);
		return "Insurance Policy Deleted";
	}
	
	@PutMapping("/api/policies/{id}")
	public ResponseEntity<?> updateInsurancePolicy(@PathVariable Long id, @RequestBody InsurancePolicy insurancePolicy) {
		InsurancePolicy updateInsurancePolicy=insurancePolicyService.update(id, insurancePolicy);
		if(updateInsurancePolicy == null) {
			return new ResponseEntity<>("InsurancePolicy Not Found",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(updateInsurancePolicy,HttpStatus.OK);
		}
	}

}
