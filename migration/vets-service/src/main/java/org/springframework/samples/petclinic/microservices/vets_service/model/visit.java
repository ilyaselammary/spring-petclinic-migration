package org.springframework.samples.petclinic.microservices.vets_service.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
@Data
public class visit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "visit_date")
	private LocalDate date;

	@Column(name = "description")
	private String description;

	@Column(name = "pet_id")
	private Long petId;
}
