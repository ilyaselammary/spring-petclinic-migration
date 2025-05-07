package org.springframework.samples.petclinic.microservices.owners_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "types")
public class PetType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	// Getters et Setters
}
