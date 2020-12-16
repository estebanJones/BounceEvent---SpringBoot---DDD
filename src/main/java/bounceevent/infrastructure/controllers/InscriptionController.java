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
import bounceevent.infrastructure.services.ControleurInscriptionService;

@RestController
@CrossOrigin
@RequestMapping("/bounce_event")
public class InscriptionController {
	private InscriptionManager inscriptionService;
	private  ControleurInscriptionService controleurInscription;
	
	public InscriptionController(InscriptionManager inscriptionService, ControleurInscriptionService controleurInscription) {
		this.controleurInscription = controleurInscription;
		this.inscriptionService = inscriptionService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody @Valid RegisterDtoRequest dtoRequest, BindingResult resValid) {
		if(!resValid.hasErrors()) {
			if(this.controleurInscription.controleInscriptionProprietes(dtoRequest)) {
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
