package bounceevent.infrastructure.manager;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bounceevent.domain.entities.Personne;
import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;
import bounceevent.infrastructure.dto.inscription.RegisterDtoResponse;
import bounceevent.infrastructure.services.PersonneService;
import bounceevent.infrastructure.services.UtilisateurDAO;


@Service
public class InscriptionManager {
	private UtilisateurDAO utilisateurDAO;
	private PersonneService personneService;
	private PasswordEncoder passwordEncoder;
	
	public InscriptionManager(UtilisateurDAO utilisateurDAO, PersonneService personneService, PasswordEncoder passwordEncoder) {
		this.utilisateurDAO = utilisateurDAO;
		this.personneService = personneService;
		this.passwordEncoder = passwordEncoder;
	}
	
	public RegisterDtoResponse inscription(RegisterDtoRequest dtoRequest) {
		Personne personne = new Personne(dtoRequest.getNom(), dtoRequest.getPrenom(), dtoRequest.getAge());
		this.encodePassword(dtoRequest);
		Utilisateur utilisateur = this.utilisateurDAO.insertUtilisateur(dtoRequest, personne);
		return new RegisterDtoResponse(utilisateur);
	}
	
	private void encodePassword(RegisterDtoRequest dtoRequest) {
		dtoRequest.setPassword(this.passwordEncoder.encode(dtoRequest.getPassword()));
	}
}
