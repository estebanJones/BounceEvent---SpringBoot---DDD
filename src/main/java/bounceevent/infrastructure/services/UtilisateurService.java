package bounceevent.infrastructure.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import bounceevent.domain.entities.Personne;
import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;
import bounceevent.infrastructure.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	private UtilisateurRepository utilisateurRepository;
	
	public UtilisateurService(UtilisateurRepository utilisateurRepository, PasswordEncoder passwordEncoder) {
		this.utilisateurRepository = utilisateurRepository;
	}
	
	@Transactional
	public Utilisateur insertUtilisateur(RegisterDtoRequest registerDto, Personne personne) {
		Utilisateur utilisateur = this.createUtilisateur(registerDto, personne);
		return this.utilisateurRepository.save(utilisateur);
	}
	
	public Optional<Utilisateur> rechercherUtilisateurParEmail(String email) {
		return this.utilisateurRepository.findByEmail(email);
	}
	private Utilisateur createUtilisateur(RegisterDtoRequest registerDto, Personne personne) {
		return new Utilisateur(
				personne.getNom(), 
			    personne.getPrenom(), 
			    personne.getAge(), 
			    registerDto.getUsername(), 
			    registerDto.getPassword(), 
			    registerDto.getEmail(), 
			    registerDto.getNumeroPortable()
		);
	}
	

}
