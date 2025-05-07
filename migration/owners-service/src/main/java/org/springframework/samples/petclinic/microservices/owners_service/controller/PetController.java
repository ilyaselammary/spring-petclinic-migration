package org.springframework.samples.petclinic.microservices.owners_service.controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.microservices.owners_service.Services.PetService;
import org.springframework.samples.petclinic.microservices.owners_service.model.Pet;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

	private final PetService petService;

	@Autowired
	public PetController(PetService petService) {
		this.petService = petService;
	}

	@GetMapping
	public ResponseEntity<List<Pet>> getAllPets() {
		List<Pet> pets = petService.findAllPets();
		return new ResponseEntity<>(pets, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
		Optional<Pet> pet = petService.findPetById(id);
		return pet.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
			.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/owner/{ownerId}")
	public ResponseEntity<List<Pet>> getPetsByOwnerId(@PathVariable Long ownerId) {
		List<Pet> pets = petService.findPetsByOwnerId(ownerId);
		return new ResponseEntity<>(pets, HttpStatus.OK);
	}

	@GetMapping("/{id}/exists")
	public ResponseEntity<Boolean> petExists(@PathVariable Long id) {
		boolean exists = petService.petExists(id);
		return new ResponseEntity<>(exists, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
		Pet savedPet = petService.savePet(pet);
		return new ResponseEntity<>(savedPet, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pet> updatePet(@PathVariable Long id, @RequestBody Pet pet) {
		Optional<Pet> currentPet = petService.findPetById(id);
		if (currentPet.isPresent()) {
			pet.setId(id);
			Pet updatedPet = petService.savePet(pet);
			return new ResponseEntity<>(updatedPet, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePet(@PathVariable Long id) {
		Optional<Pet> pet = petService.findPetById(id);
		if (pet.isPresent()) {
			petService.deletePet(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
