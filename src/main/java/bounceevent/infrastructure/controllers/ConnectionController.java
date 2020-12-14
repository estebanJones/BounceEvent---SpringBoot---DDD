package bounceevent.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bounceevent.infrastructure.dto.connection.UtilisateurDto;
import bounceevent.infrastructure.repository.UtilisateurRepository;


@RestController
@CrossOrigin
@RequestMapping("/bounce_event")
public class ConnectionController {
	private UtilisateurRepository utilisateurRepo;
	
	public ConnectionController(UtilisateurRepository utilisateurRepo) {
		this.utilisateurRepo = utilisateurRepo;
	}
	
	 @GetMapping("/me")
     public ResponseEntity<?> quiSuisJe() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.utilisateurRepo.findByEmail(email)
                .map(UtilisateurDto::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
   	  }
}
