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
	
	public Utilisateur verificationConnection(String email, String password) throws Exception {
		Optional<Utilisateur> utilisateur = this.utilisateurRepository.findByEmailAndPassword(email, password);
		if(!utilisateur.isEmpty()) {
			return utilisateur.get();
		} else {
			throw new UserNotFoundException("Email ou mot de passe incorrect");
		}
	}
	
}
