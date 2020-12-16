package bounceevent.infrastructure.builder;

import org.springframework.stereotype.Component;

import bounceevent.domain.entities.Personne;
import bounceevent.domain.entities.RoleUtilisateur;
import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;

@Component
public class UtilisateurBuilder {
	private Utilisateur utilisateur;
	
	public UtilisateurBuilder() {

	}
	
	public Utilisateur build(RegisterDtoRequest registerDto, Personne personne, RoleUtilisateur role) {
		this.utilisateur = new Utilisateur(registerDto.getNom(), registerDto.getPrenom(), registerDto.getAge(), registerDto.getUsername(), 
				registerDto.getPassword(), registerDto.getEmail(), registerDto.getNumeroPortable());
		
		this.appendRole(role);
		return this.get();
	}

	
	private UtilisateurBuilder appendRole(RoleUtilisateur role) {
		role.setUtilisateur(this.utilisateur);
		this.utilisateur.getRoles().add(role);
		return this;
	}
	
	private Utilisateur get() {
		return this.utilisateur;
	}
}
