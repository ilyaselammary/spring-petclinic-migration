package org.springframework.samples.petclinic.microservices.owners_service.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pets")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType type;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	// Getters et Setters
}
