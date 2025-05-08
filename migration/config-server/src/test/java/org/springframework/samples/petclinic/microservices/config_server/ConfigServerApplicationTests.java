package org.springframework.samples.petclinic.microservices.config_server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test") // Utiliser un profil de test
public class ConfigServerApplicationTests {

	@Test
	void contextLoads() {
		// Test vide juste pour vérifier que le contexte se charge
	}
}
