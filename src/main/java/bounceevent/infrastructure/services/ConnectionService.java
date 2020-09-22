package bounceevent.infrastructure.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.connection.DtoConnectionRequest;
import bounceevent.infrastructure.dto.connection.DtoConnectionResponse;
import bounceevent.infrastructure.exception.utilisateur.UserNotFoundException;
import bounceevent.infrastructure.repository.UtilisateurRepository;

@Service
public class ConnectionService {
	@Autowired
	UtilisateurService utilisateurService;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	
	@PostMapping("/connection")
	public ResponseEntity<?> connection(@Valid @RequestBody DtoConnectionRequest dtoRequest, BindingResult resValid) throws Exception {
		DtoConnectionResponse response = null;
		if(!resValid.hasErrors()) {
			Utilisateur utilisateur = this.verificationConnection(dtoRequest.getEmail(), dtoRequest.getPassword());
			response = new DtoConnectionResponse("Token de réussite " + utilisateur);
			return ResponseEntity.ok().body(response);
		} else {
			return ResponseEntity.badRequest().body("Une erreur est survenue lors de la connection");
		}
	}
	
	public Utilisateur verificationConnection(String email, String password) throws Exception {
		System.out.println("email " + email + " pass " + password);
		Optional<Utilisateur> utilisateur = this.utilisateurRepository.findByEmailAndPassword(email, password);
		System.out.println("utilisateur " + utilisateur);
		if(!utilisateur.isEmpty()) {
			System.out.println("dans if");
			return utilisateur.get();
		} else {
			throw new UserNotFoundException("Email ou mot de passe incorrect");
		}
	}
	
}
