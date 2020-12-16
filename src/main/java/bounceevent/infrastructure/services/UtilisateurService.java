package bounceevent.infrastructure.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import bounceevent.domain.entities.Personne;
import bounceevent.domain.entities.RoleUtilisateur;
import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.builder.UtilisateurBuilder;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;
import bounceevent.infrastructure.enums.ERole;
import bounceevent.infrastructure.repository.PersonneRepository;
import bounceevent.infrastructure.repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	private UtilisateurRepository utilisateurRepository;
	private PersonneRepository personneRepository;
	private UtilisateurBuilder utilisateurBuilder;
	
	public UtilisateurService(UtilisateurRepository utilisateurRepository, PersonneRepository personneRepository,  UtilisateurBuilder utilisateurBuilder) {
		this.utilisateurRepository = utilisateurRepository;
		this.personneRepository = personneRepository;
		this.utilisateurBuilder = utilisateurBuilder;
	}
	
	@Transactional
	public Utilisateur insertUtilisateur(RegisterDtoRequest registerDto, Personne personne) {
		Utilisateur utilisateur = this.createUtilisateur(registerDto, personne);
		//this.insertPersonne(personne);
		return this.utilisateurRepository.save(utilisateur);
	}
	
	public Optional<Utilisateur> rechercherUtilisateurParEmail(String email) {
		return this.utilisateurRepository.findByEmail(email);
	}
	private Utilisateur createUtilisateur(RegisterDtoRequest registerDto, Personne personne) {
//		 UtilisateurBuilder utilisateurBuilder = new UtilisateurBuilder(personne.getNom(), personne.getPrenom(), personne.getAge(), registerDto.getUsername(), 
//				registerDto.getPassword(),  registerDto.getEmail(), registerDto.getNumeroPortable());
//		utilisateurBuilder.appendPersonne(personne);
//		utilisateurBuilder.appendRole(, utilisateurBuilder.get());
		return this.utilisateurBuilder.build(registerDto, personne, new RoleUtilisateur(ERole.ROLE_UTILISATEUR));
		
	}
	
	@Transactional
	public Personne insertPersonne(Personne personne) {
		return this.personneRepository.save(personne);
	}
}
