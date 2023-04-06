package com.restapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.restapi.model.Claim;

public interface ClaimRepository extends CrudRepository<Claim, Long>{

}
