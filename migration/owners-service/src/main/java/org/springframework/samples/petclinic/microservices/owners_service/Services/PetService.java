package org.springframework.samples.petclinic.microservices.owners_service.Services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.samples.petclinic.microservices.owners_service.model.Pet;
import org.springframework.samples.petclinic.microservices.owners_service.repository.PetRepository;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

	private final PetRepository petRepository;

	@Autowired
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@Transactional(readOnly = true)
	public List<Pet> findAllPets() {
		return petRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Pet> findPetById(Long id) {
		return petRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Pet> findPetsByOwnerId(Long ownerId) {
		return petRepository.findByOwnerId(ownerId);
	}

	@Transactional
	public Pet savePet(Pet pet) {
		return petRepository.save(pet);
	}

	@Transactional
	public void deletePet(Long id) {
		petRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public boolean petExists(Long id) {
		return petRepository.existsById(id);
	}
}
