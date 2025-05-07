package org.springframework.samples.petclinic.microservices.owners_service.Services;

import org.springframework.beans.factory.annotation.*;
import org.springframework.samples.petclinic.microservices.owners_service.model.Owner;
import org.springframework.samples.petclinic.microservices.owners_service.repository.OwnerRepository;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

	private final OwnerRepository ownerRepository;

	@Autowired
	public OwnerService(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Transactional(readOnly = true)
	public List<Owner> findAllOwners() {
		return ownerRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Optional<Owner> findOwnerById(Long id) {
		return ownerRepository.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Owner> findOwnersByLastName(String lastName) {
		return ownerRepository.findByLastNameContainingIgnoreCase(lastName);
	}

	@Transactional
	public Owner saveOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Transactional
	public void deleteOwner(Long id) {
		ownerRepository.deleteById(id);
	}
}
