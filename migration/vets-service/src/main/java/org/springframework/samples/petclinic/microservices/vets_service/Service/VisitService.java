package org.springframework.samples.petclinic.microservices.vets_service.Service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.samples.petclinic.microservices.vets_service.model.visit;
import org.springframework.samples.petclinic.microservices.vets_service.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

	private final VisitRepository visitRepository;

	@Autowired
	public VisitService(VisitRepository visitRepository) {
		this.visitRepository = visitRepository;
	}

	@Transactional(readOnly = true)
	public List<visit> findAllVisits() {
		return visitRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<visit> findVisitById(Long id) {
		return visitRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public List<visit> findVisitsByPetId(Long petId) {
		return visitRepository.findByPetId(petId);
	}

	@Transactional
	public visit saveVisit(visit visit) {
		return visitRepository.save(visit);
	}

	@Transactional
	public void deleteVisit(Long id) {
		visitRepository.deleteById(id);
	}
}
