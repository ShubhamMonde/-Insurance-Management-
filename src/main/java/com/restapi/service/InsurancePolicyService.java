package com.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.model.Client;
import com.restapi.model.InsurancePolicy;
import com.restapi.repository.InsurancePolicyRepository;

@Service
public class InsurancePolicyService {
	@Autowired
	private InsurancePolicyRepository insurancePolicyRepository;

	public Iterable<InsurancePolicy> getAll() {
		return insurancePolicyRepository.findAll();
	}

	public InsurancePolicy add(InsurancePolicy insurancePolicy) {
		return insurancePolicyRepository.save(insurancePolicy);
	}

	public InsurancePolicy find(Long id) {
		return insurancePolicyRepository.findById(id).orElse(null);
	}

	public void delete(Long id) {
		insurancePolicyRepository.deleteById(id);
	}

	public InsurancePolicy update(Long id, InsurancePolicy insurancePolicy) {
		InsurancePolicy foundInsurancePolicy=this.find(id);
		if(foundInsurancePolicy == null)
			return null;
		else {
			insurancePolicy.setPolicy_number(id);
			return insurancePolicyRepository.save(insurancePolicy);			
		}
	}




}
