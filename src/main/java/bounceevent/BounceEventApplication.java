package bounceevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import bounceevent.infrastructure.repository.UtilisateurRepository;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class BounceEventApplication {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200").allowedMethods("GET", "POST", "PATCH", "PUT", "OPTIONS")
						.allowCredentials(true);
				;
			}
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BounceEventApplication.class, args);
	}

}
