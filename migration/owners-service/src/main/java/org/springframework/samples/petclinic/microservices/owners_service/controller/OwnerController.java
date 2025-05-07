package org.springframework.samples.petclinic.microservices.owners_service.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.microservices.owners_service.Services.OwnerService;
import org.springframework.samples.petclinic.microservices.owners_service.model.Owner;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {

	private final OwnerService ownerService;

	@Autowired
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@GetMapping
	public ResponseEntity<List<Owner>> getAllOwners() {
		List<Owner> owners = ownerService.findAllOwners();
		return new ResponseEntity<>(owners, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
		Optional<Owner> owner = ownerService.findOwnerById(id);
		return owner.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
			.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/find")
	public ResponseEntity<List<Owner>> getOwnersByLastName(@RequestParam String lastName) {
		List<Owner> owners = ownerService.findOwnersByLastName(lastName);
		if (owners.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(owners, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
		Owner savedOwner = ownerService.saveOwner(owner);
		return new ResponseEntity<>(savedOwner, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Owner> updateOwner(@PathVariable Long id, @RequestBody Owner owner) {
		Optional<Owner> currentOwner = ownerService.findOwnerById(id);
		if (currentOwner.isPresent()) {
			owner.setId(id);
			Owner updatedOwner = ownerService.saveOwner(owner);
			return new ResponseEntity<>(updatedOwner, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
		Optional<Owner> owner = ownerService.findOwnerById(id);
		if (owner.isPresent()) {
			ownerService.deleteOwner(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

