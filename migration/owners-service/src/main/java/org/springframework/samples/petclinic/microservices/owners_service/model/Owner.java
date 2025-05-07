package org.springframework.samples.petclinic.microservices.owners_service.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "owners")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "telephone")
	private String telephone;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();
}
