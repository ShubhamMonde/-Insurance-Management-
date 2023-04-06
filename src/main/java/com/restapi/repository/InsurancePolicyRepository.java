package com.restapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.restapi.model.InsurancePolicy;

public interface InsurancePolicyRepository extends CrudRepository<InsurancePolicy, Long>{

}
