package bounceevent.infrastructure.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bounceevent.domain.entities.Personne;
import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;
import bounceevent.infrastructure.dto.inscription.RegisterDtoResponse;
import bounceevent.infrastructure.services.UtilisateurService;

@RestController
@RequestMapping("/bounce_event")
public class InscriptionController {
	private Logger LOG = LoggerFactory.getLogger(InscriptionController.class);
	
	@Autowired
	UtilisateurService utilisateurService;
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid RegisterDtoRequest dtoRequest, BindingResult resValid) {
		if(!resValid.hasErrors()) {
			System.out.println("hheloo ?");
			Personne personne = new Personne(dtoRequest.getNom(), dtoRequest.getPrenom(), dtoRequest.getAge());

			Utilisateur utilisateur = this.utilisateurService.insertUtilisateur(dtoRequest, personne);
			RegisterDtoResponse response = new RegisterDtoResponse(utilisateur);
			return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.badRequest().body("Une erreur dans l'inscription est survenue");
		}
	}
}
