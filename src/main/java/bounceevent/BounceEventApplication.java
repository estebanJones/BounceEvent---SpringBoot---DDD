package bounceevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import bounceevent.infrastructure.repository.UtilisateurRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UtilisateurRepository.class)
public class BounceEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(BounceEventApplication.class, args);
	}

}
