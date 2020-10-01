package bounceevent.infrastructure.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.connection.DtoConnectionRequest;
import bounceevent.infrastructure.dto.connection.DtoConnectionResponse;
import bounceevent.infrastructure.exception.utilisateur.UserNotFoundException;
import bounceevent.infrastructure.services.ConnectionService;

@RestController
@CrossOrigin
@RequestMapping("/bounce_event")
public class ConnectionController {
	private ConnectionService connectionService;
	
	public ConnectionController(ConnectionService connectionService) {
		this.connectionService = connectionService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> connection(@Valid @RequestBody DtoConnectionRequest dtoRequest, BindingResult resValid) throws Exception {
		if(!resValid.hasErrors()) {
			 Utilisateur utilisateur = this.connectionService.verificationConnection(dtoRequest.getEmail(), dtoRequest.getPassword());
			 DtoConnectionResponse response = new DtoConnectionResponse("Token de réussite ", utilisateur.getUsername(), utilisateur.getId(), utilisateur.getEmail());
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body(new UserNotFoundException("Email ou mot de passe incorrect").getMessage());
		}
	}
}
