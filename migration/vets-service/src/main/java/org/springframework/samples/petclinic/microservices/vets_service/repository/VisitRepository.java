package org.springframework.samples.petclinic.microservices.vets_service.repository;


import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
	List<Visit> findByPetId(Long petId);
}
