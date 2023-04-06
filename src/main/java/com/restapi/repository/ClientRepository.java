package com.restapi.repository;

import org.springframework.data.repository.CrudRepository;


import com.restapi.model.Client;

public interface ClientRepository extends CrudRepository<Client, Integer>{

}
