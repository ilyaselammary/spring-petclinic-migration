package org.springframework.samples.petclinic.microservices.owners_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.microservices.owners_service.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
	List<Pet> findByOwnerId(Long ownerId);
}

