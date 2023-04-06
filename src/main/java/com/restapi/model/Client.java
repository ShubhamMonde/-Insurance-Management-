package com.restapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	@NotNull(message="Name cannot be null ")
	@NotBlank(message="Name cannot be blank")
	private String name;
	
	@Column
	@NotNull(message="DOB cannot be null ")
	@NotBlank(message="DOB cannot be blank")
	private String dob;
	
	@Column
	@NotNull(message="Address cannot be null ")
	@NotBlank(message="Address cannot be blank")
	private String address;
	
	@Column
	@NotNull(message="Contact number cannot be null ")
	@NotBlank(message="Contact Number cannot be blank")
	@Size(max=10)
	private String contact_no;
	
	
//	@OneToMany(mappedBy = "client")
//	private List<InsurancePolicy> insurancePolicies;
	
	@OneToMany(mappedBy = "client")
	private List<InsurancePolicy> insurancePolicies;
}
