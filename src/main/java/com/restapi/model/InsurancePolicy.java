package com.restapi.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Entity
@Data
public class InsurancePolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long policy_number; 
	
	@Column
	@NotNull(message="Policy Type cannot be null ")
	@NotBlank(message="Policy Type cannot be blank")
	private String policy_type; 
	
	@Column
	@NotNull(message="Coverage Amount cannot be null ")
	private Long coverage_amount;
	
	@Column
	@NotNull(message="Premium cannot be null ")
	private Long premium; 
	
	@Column
	@NotNull(message="Start Date cannot be null ")
	@NotBlank(message="Primium cannot be blank")
	private String start_date;
	
	@Column
	@NotNull(message="End date cannot be null ")
	@NotBlank(message="End date cannot be blank")
	private String end_date;
	
	

	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	
	@OneToOne
	@JoinColumn(name = "claim_claimno")
	private Claim claim;



}
