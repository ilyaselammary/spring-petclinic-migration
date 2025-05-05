package org.springframework.samples.petclinic.microservices.vets_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.microservices.vets_service.model.Specialty;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {	// Méthodes spécifiques si nécessaire
}
