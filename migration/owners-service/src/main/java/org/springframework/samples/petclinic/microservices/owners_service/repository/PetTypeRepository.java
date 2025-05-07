package org.springframework.samples.petclinic.microservices.owners_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.microservices.owners_service.model.PetType;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}
