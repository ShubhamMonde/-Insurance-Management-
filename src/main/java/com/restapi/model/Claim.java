package com.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long claim_number;
	
	@Column
	@NotNull(message="Description cannot be null ")
	@NotBlank(message="Description cannot be blank")
	private String description;
	
	@Column
	@NotNull(message="Claim Date cannot be null ")
	@NotBlank(message="Claim Date cannot be blank")
	private String claim_date;
	
	@Column
	@NotNull(message="Claim Status cannot be null ")
	@NotBlank(message="Claim Status cannot be blank")
	private String claim_status;

	@OneToOne(mappedBy = "claim")
	private InsurancePolicy insurancePolicy;
	
}
