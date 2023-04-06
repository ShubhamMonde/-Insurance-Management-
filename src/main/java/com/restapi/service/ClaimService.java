package com.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.model.Claim;
import com.restapi.model.Client;
import com.restapi.repository.ClaimRepository;

@Service
public class ClaimService {
	@Autowired
	private ClaimRepository claimRepository;
	
	public Iterable<Claim> getAll() {
		return claimRepository.findAll();
	}
	
	public Claim add(Claim claim) {
		return claimRepository.save(claim);
	}

	public Claim find(Long id) {
		return claimRepository.findById(id).orElse(null);
	}

	public void delete(Long id) {
		claimRepository.deleteById(id);
		
	}

	public Claim update(Long id, Claim claim) {
		Claim foundClaim=this.find(id);
		if(foundClaim == null)
			return null;
		else {
			claim.setClaim_number(id);
			return claimRepository.save(claim);			
		}
	}

}
