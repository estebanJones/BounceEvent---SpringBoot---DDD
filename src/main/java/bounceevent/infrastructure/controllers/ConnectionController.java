package bounceevent.infrastructure.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.connection.DtoConnectionRequest;
import bounceevent.infrastructure.exception.utilisateur.UserNotFoundException;
import bounceevent.infrastructure.services.ConnectionService;

@RestController
@CrossOrigin
@RequestMapping("/bounce_event")
public class ConnectionController {
	private ConnectionService connectionService;
	private AuthenticationManager authenticationManager;
	
	public ConnectionController(ConnectionService connectionService, AuthenticationManager authenticationManager) {
		this.connectionService = connectionService;
		this.authenticationManager = authenticationManager;
	}
	
	@PostMapping("/connection")
	public ResponseEntity<?> connection(@Valid @RequestBody DtoConnectionRequest dtoRequest, BindingResult resValid) throws Exception {
		if(!resValid.hasErrors()) {
			UsernamePasswordAuthenticationToken authenticationTokenRequest = new
	                UsernamePasswordAuthenticationToken(dtoRequest.getUsername(), dtoRequest.getPassword());
			Authentication authentication = this.authenticationManager.authenticate(authenticationTokenRequest);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(authentication);

            Utilisateur user = (Utilisateur) authentication.getPrincipal();
//			 Utilisateur utilisateur = this.connectionService.verificationConnection(dtoRequest.getEmail(), dtoRequest.getPassword());
//			 DtoConnectionResponse response = new DtoConnectionResponse("Token de réussite ", utilisateur.getUsername(), utilisateur.getId(), utilisateur.getEmail());
			return ResponseEntity.ok().body(user);
		} else {
			return ResponseEntity.badRequest().body(new UserNotFoundException("Email ou mot de passe incorrect").getMessage());
		}
	}
}
