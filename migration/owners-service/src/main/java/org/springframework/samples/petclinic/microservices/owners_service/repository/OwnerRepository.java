package org.springframework.samples.petclinic.microservices.owners_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.microservices.owners_service.model.Owner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
	List<Owner> findByLastNameContainingIgnoreCase(String lastName);
}
