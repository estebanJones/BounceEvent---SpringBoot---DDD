package bounceevent.infrastructure.dto.connection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import bounceevent.domain.entities.Utilisateur;

/**
 * @author Jordan
 * Structure modèlisant un collègue servant à communiquer avec l'extérieur (WEB
 * API).
 */
 
 
public class UtilisateurDto {
	private Long id;
	private String email;
	private String nom;
	private String prenom;

	private List<String> roles = new ArrayList<>();

	public UtilisateurDto(Utilisateur utilisateur) {
		this.id = utilisateur.getId();
		this.email = utilisateur.getEmail();
		this.nom = utilisateur.getNom();
		this.prenom = utilisateur.getPrenom();
		this.roles = utilisateur.getRoles().stream().map(roleUtilisateur -> String.valueOf(roleUtilisateur.getRole().getRoleValue())).collect(Collectors.toList());
	}
	
	public UtilisateurDto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	
}
