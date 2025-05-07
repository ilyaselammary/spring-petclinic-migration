package org.springframework.samples.petclinic.microservices.vets_service.DTOs;

import java.util.Set;

public class VetDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private Set<SpecialtyDTO> specialties;

	// Getters et Setters
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Set<SpecialtyDTO> getSpecialties() {
		return specialties;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSpecialties(Set<SpecialtyDTO> specialties) {
		this.specialties = specialties;
	}
}
}
