package bounceevent.infrastructure.services;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bounceevent.domain.entities.Personne;
import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;
import bounceevent.infrastructure.dto.inscription.RegisterDtoResponse;

@Service
public class InscriptionService {
	private PasswordEncoder passwordEncoder;
	private UtilisateurService utilisateurService;
	
	public InscriptionService(UtilisateurService utilisateurService, PasswordEncoder passwordEncoder) {
		this.utilisateurService = utilisateurService;
		this.passwordEncoder = passwordEncoder;
	}
	
	public RegisterDtoResponse inscription(RegisterDtoRequest dtoRequest) {
		Personne personne = new Personne(dtoRequest.getNom(), dtoRequest.getPrenom(), dtoRequest.getAge());
		String op = dtoRequest.getPassword();
		dtoRequest.setPassword(this.encodePassword(dtoRequest.getPassword()));
		Utilisateur utilisateur = this.utilisateurService.insertUtilisateur(dtoRequest, personne);
		return new RegisterDtoResponse(utilisateur);
	}
	
	private String encodePassword(String password) {
		return this.passwordEncoder.encode(password);
	}
}
