package org.springframework.samples.petclinic.microservices.vets_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.microservices.vets_service.model.vet;


public interface VetRepository extends JpaRepository<vet, Long> {
	// Méthodes spécifiques si nécessaire
}
