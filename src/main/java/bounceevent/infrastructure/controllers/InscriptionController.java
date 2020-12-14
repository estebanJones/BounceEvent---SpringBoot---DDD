package bounceevent.infrastructure.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;
import bounceevent.infrastructure.dto.inscription.RegisterDtoResponse;
import bounceevent.infrastructure.exception.FormulaireIncompletException;
import bounceevent.infrastructure.exception.RequeteErreurException;
import bounceevent.infrastructure.manager.InscriptionManager;
import bounceevent.infrastructure.poco.UtilisateurPoco;

@RestController
@CrossOrigin
@RequestMapping("/bounce_event")
public class InscriptionController {
	private InscriptionManager inscriptionService;
	private  UtilisateurPoco poco;
	
	public InscriptionController(InscriptionManager inscriptionService, UtilisateurPoco poco) {
		this.poco = poco;
		this.inscriptionService = inscriptionService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid RegisterDtoRequest dtoRequest, BindingResult resValid) {
		if(!resValid.hasErrors()) {
			if(this.poco.controleInscriptionProprietes(dtoRequest)) {
				RegisterDtoResponse response = this.inscriptionService.inscription(dtoRequest);
				return ResponseEntity.ok(response);
			} else {
				return ResponseEntity.badRequest().body(new FormulaireIncompletException("Veuillez remplir les champs correctement"));
			}
		} else {
			return ResponseEntity.badRequest().body(new RequeteErreurException("Une erreur est survenue"));
		}
	}
}
