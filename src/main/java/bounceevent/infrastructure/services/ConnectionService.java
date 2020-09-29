package bounceevent.infrastructure.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.connection.DtoConnectionRequest;
import bounceevent.infrastructure.dto.connection.DtoConnectionResponse;
import bounceevent.infrastructure.exception.EmailNotFoundException;
import bounceevent.infrastructure.exception.PasswordIncorrectException;
import bounceevent.infrastructure.exception.utilisateur.UserNotFoundException;
import bounceevent.infrastructure.repository.UtilisateurRepository;

@Service
public class ConnectionService  {

	private UtilisateurService utilisateurService;
	private UtilisateurRepository utilisateurRepository;
	private PasswordEncoder passwordEncoder;
	
	public ConnectionService(PasswordEncoder passwordEncoder, UtilisateurService utilisateurService, UtilisateurRepository utilisateurRepository) {
		this.passwordEncoder = passwordEncoder;
		this.utilisateurService = utilisateurService;
		this.utilisateurRepository = utilisateurRepository;
	}
	
	public Utilisateur verificationConnection(String email, String passwordCoteClient) throws Exception {
		Utilisateur utilisateur = this.controleEmail(email);
		
		if(this.controleMotDePasse(passwordCoteClient, utilisateur.getPassword())) {
			return utilisateur;
		} else {
			throw new PasswordIncorrectException("Mot de passe incorrect");
		}
	}
	
	
	private Utilisateur controleEmail(String email) throws EmailNotFoundException {
		Optional<Utilisateur> utilisateur = this.utilisateurRepository.findByEmail(email);
		if(!utilisateur.isEmpty()) {
			return utilisateur.get();
		} else {
			throw new EmailNotFoundException("Email ou mot de passe incorrect");
		}
	}
	
	private boolean controleMotDePasse(CharSequence passwordCoteClient, String passwordEncode) {
		return this.passwordEncoder.matches(passwordCoteClient, passwordEncode);
	}
}
