package bounceevent.infrastructure.manager;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bounceevent.domain.entities.Personne;
import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;
import bounceevent.infrastructure.dto.inscription.RegisterDtoResponse;
import bounceevent.infrastructure.services.PersonneService;
import bounceevent.infrastructure.services.UtilisateurService;


@Service
public class InscriptionManager {
	private UtilisateurService utilisateurService;
	private PersonneService personneService;
	private PasswordEncoder passwordEncoder;
	
	public InscriptionManager(UtilisateurService utilisateurService, PersonneService personneService, PasswordEncoder passwordEncoder) {
		this.utilisateurService = utilisateurService;
		this.personneService = personneService;
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
