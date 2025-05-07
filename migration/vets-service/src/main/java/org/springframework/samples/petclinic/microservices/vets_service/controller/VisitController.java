package org.springframework.samples.petclinic.microservices.vets_service.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.microservices.vets_service.Service.VisitService;
import org.springframework.samples.petclinic.microservices.vets_service.model.visit;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/visits")
public class VisitController {

	private final VisitService visitService;

	@Autowired
	public VisitController(VisitService visitService) {
		this.visitService = visitService;
	}

	@GetMapping
	public ResponseEntity<List<visit>> getAllVisits() {
		List<visit> visits = visitService.findAllVisits();
		return new ResponseEntity<>(visits, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<visit> getVisitById(@PathVariable Long id) {
		Optional<visit> visit = visitService.findVisitById(id);
		return visit.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
			.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/pet/{petId}")
	public ResponseEntity<List<visit>> getVisitsByPetId(@PathVariable Long petId) {
		List<visit> visits = visitService.findVisitsByPetId(petId);
		return new ResponseEntity<>(visits, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<visit> createVisit(@RequestBody visit visit) {
		visit savedVisit = visitService.saveVisit(visit);
		return new ResponseEntity<>(savedVisit, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<visit> updateVisit(@PathVariable Long id, @RequestBody visit visit) {
		Optional<visit> currentVisit = visitService.findVisitById(id);
		if (currentVisit.isPresent()) {
			visit.setId(id);
			visit updatedVisit = visitService.saveVisit(visit);
			return new ResponseEntity<>(updatedVisit, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVisit(@PathVariable Long id) {
		Optional<visit> visit = visitService.findVisitById(id);
		if (visit.isPresent()) {
			visitService.deleteVisit(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
