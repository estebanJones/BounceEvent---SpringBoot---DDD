package bounceevent.infrastructure.builder;

import bounceevent.domain.entities.Personne;
import bounceevent.domain.entities.RoleUtilisateur;
import bounceevent.domain.entities.Utilisateur;


public class UtilisateurBuilder {
	private Utilisateur utilisateur;
	
	public UtilisateurBuilder(String nom, String prenom, Integer age, String username, String password, String email, String numeroPortable) {
		this.utilisateur = new Utilisateur(nom, prenom, age, username, password, email, numeroPortable);
	}
	
	public UtilisateurBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	public UtilisateurBuilder appendPersonne(Personne personne) {
		this.utilisateur.setPersonne(personne);
		return this;
	}
	
	public UtilisateurBuilder appendRole(RoleUtilisateur role, Utilisateur utilisateur) {
		role.setUtilisateur(this.utilisateur);
		this.utilisateur.getRoles().add(role);
		return this;
	}
	
	public Utilisateur get() {
		return this.utilisateur;
	}
}
