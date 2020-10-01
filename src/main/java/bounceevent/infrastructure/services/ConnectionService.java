package bounceevent.infrastructure.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.exception.EmailNotFoundException;
import bounceevent.infrastructure.repository.UtilisateurRepository;

@Service
public class ConnectionService  {

	private UtilisateurService utilisateurService;
	private UtilisateurRepository utilisateurRepository;

	
	public ConnectionService( UtilisateurService utilisateurService, UtilisateurRepository utilisateurRepository) {
		this.utilisateurService = utilisateurService;
		this.utilisateurRepository = utilisateurRepository;
	}
	
	public Utilisateur verificationConnection(String email, String passwordCoteClient) throws Exception {
		Utilisateur utilisateur = this.controleEmail(email);
		return utilisateur;
//		if(this.controleMotDePasse(passwordCoteClient, utilisateur.getPassword())) {
//			return utilisateur;
//		} else {
//			throw new PasswordIncorrectException("Mot de passe incorrect");
//		}
	}
	
	
	private Utilisateur controleEmail(String email) throws EmailNotFoundException {
		Optional<Utilisateur> utilisateur = this.utilisateurRepository.findByEmail(email);
		if(!utilisateur.isEmpty()) {
			return utilisateur.get();
		} else {
			throw new EmailNotFoundException("Email ou mot de passe incorrect");
		}
	}
	
//	private boolean controleMotDePasse(CharSequence passwordCoteClient, String passwordEncode) {
//		return this.passwordEncoder.matches(passwordCoteClient, passwordEncode);
//	}
}
