package bounceevent.infrastructure.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.services.UtilisateurDAO;

@RestController
@CrossOrigin
@RequestMapping("/bounce_event")
public class ProfilController {
	private UtilisateurDAO utilisateurService;
	
	public ProfilController(UtilisateurDAO utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	@GetMapping("/profil/{email}")
	public ResponseEntity<?> getProfilUtilisateur(@PathVariable String email) {
		Optional<Utilisateur> utilisateur = this.utilisateurService.rechercherUtilisateurParEmail(email);
		if(utilisateur.isPresent()) {
			return ResponseEntity.ok(utilisateur); 
		} else {
			return ResponseEntity.badRequest().body("L'utilisateur avec cet email n'existe pas.");
		}
	}
}
