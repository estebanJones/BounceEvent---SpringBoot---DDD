package bounceevent.infrastructure.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bounceevent.domain.entities.Personne;
import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;
import bounceevent.infrastructure.dto.inscription.RegisterDtoResponse;
import bounceevent.infrastructure.exception.FormulaireIncompletException;
import bounceevent.infrastructure.exception.RequeteErreurException;
import bounceevent.infrastructure.poco.UtilisateurPoco;
import bounceevent.infrastructure.services.UtilisateurService;

@RestController
@CrossOrigin
@RequestMapping("/bounce_event")
public class InscriptionController {
	private Logger LOG = LoggerFactory.getLogger(InscriptionController.class);
	private UtilisateurService utilisateurService;
	private  UtilisateurPoco poco;
	
	public InscriptionController(UtilisateurService utilisateurService, UtilisateurPoco poco) {
		this.poco = poco;
		this.utilisateurService = utilisateurService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid RegisterDtoRequest dtoRequest, BindingResult resValid) {
		if(!resValid.hasErrors()) {
			if(this.poco.controleInscriptionProprietes(dtoRequest)) {
				Personne personne = new Personne(dtoRequest.getNom(), dtoRequest.getPrenom(), dtoRequest.getAge());
				Utilisateur utilisateur = this.utilisateurService.insertUtilisateur(dtoRequest, personne);
				RegisterDtoResponse response = new RegisterDtoResponse(utilisateur);
				
				return ResponseEntity.ok(response);
			} else {
				return ResponseEntity.badRequest().body(new FormulaireIncompletException("Veuillez remplir les champs correctement");
			}
		} else {
			return ResponseEntity.badRequest().body(new RequeteErreurException("Une erreur est survenue"));
		}
	}
}
