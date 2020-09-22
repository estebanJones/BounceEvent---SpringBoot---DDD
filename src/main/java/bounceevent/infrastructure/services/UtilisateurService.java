package bounceevent.infrastructure.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bounceevent.domain.entities.Personne;
import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;
import bounceevent.infrastructure.exception.utilisateur.UserNotFoundException;
import bounceevent.infrastructure.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	@Autowired
	PersonneService personneService;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Transactional
	public Utilisateur insertUtilisateur(RegisterDtoRequest registerDto, Personne personne) {
		Utilisateur utilisateur = this.createUtilisateur(registerDto, personne);
		return this.utilisateurRepository.save(utilisateur);
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
