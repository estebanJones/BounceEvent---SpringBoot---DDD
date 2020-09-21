package bounceevent.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bounceevent.domain.entities.Personne;
import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;
import bounceevent.infrastructure.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	@Autowired
	PersonneService personneService;
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	public Utilisateur insertUtilisateur(RegisterDtoRequest registerDto, Personne personne) {
		this.personneService.insertPersonne(personne);
		Utilisateur utilisateur = new Utilisateur(registerDto.getUsername(), registerDto.getPassword(), registerDto.getEmail(), registerDto.getNumeroPortable());
		utilisateur.setPersonne(personne);
		return this.utilisateurRepository.save(utilisateur);
	}
	
	
}
