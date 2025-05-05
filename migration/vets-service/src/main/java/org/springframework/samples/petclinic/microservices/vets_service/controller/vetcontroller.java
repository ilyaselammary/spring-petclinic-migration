package org.springframework.samples.petclinic.microservices.vets_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.microservices.vets_service.repository.VetRepository;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vets")
public class vetcontroller {

	private final VetRepository vetRepository;

	@Autowired
	public vetcontroller(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@GetMapping
	public List<Vet> getAllVets() {
		return vetRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vet> getVetById(@PathVariable Long id) {
		Optional<Vet> vet = vetRepository.findById(id);
		if (vet.isPresent()) {
			return ResponseEntity.ok(vet.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Vet createVet(@RequestBody Vet vet) {
		return vetRepository.save(vet);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Vet> updateVet(@PathVariable Long id, @RequestBody Vet vetDetails) {
		Optional<Vet> vet = vetRepository.findById(id);
		if (vet.isPresent()) {
			Vet existingVet = vet.get();
			existingVet.setFirstName(vetDetails.getFirstName());
			existingVet.setLastName(vetDetails.getLastName());
			existingVet.setSpecialties(vetDetails.getSpecialties());
			return ResponseEntity.ok(vetRepository.save(existingVet));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVet(@PathVariable Long id) {
		Optional<Vet> vet = vetRepository.findById(id);
		if (vet.isPresent()) {
			vetRepository.delete(vet.get());
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
