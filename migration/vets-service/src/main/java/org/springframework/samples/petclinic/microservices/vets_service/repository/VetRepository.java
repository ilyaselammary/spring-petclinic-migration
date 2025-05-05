package org.springframework.samples.petclinic.microservices.vets_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.vet.Vet;


public interface VetRepository extends JpaRepository<Vet, Long> {
	// Méthodes spécifiques si nécessaire
}
