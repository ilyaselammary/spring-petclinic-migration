package org.springframework.samples.petclinic.microservices.vets_service.DTOs;

public class SpecialtyDTO {
	private Long id;
	private String name;

	// Getters et Setters
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
}
