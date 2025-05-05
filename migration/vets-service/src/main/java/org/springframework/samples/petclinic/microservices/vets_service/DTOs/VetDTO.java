package org.springframework.samples.petclinic.microservices.vets_service.DTOs;

import java.util.Set;

public class VetDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private Set<SpecialtyDTO> specialties;

	// Getters et Setters
}
