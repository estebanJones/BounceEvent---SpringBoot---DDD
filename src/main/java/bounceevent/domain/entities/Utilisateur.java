package bounceevent.domain.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur extends Personne {
	private String username;
	private String password;
	private String email;
	private String numeroPortable;
	private String roles;
	private boolean active;
	
	@OneToOne
	private Personne personne;
	
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String prenom, Integer age, String username, String password, String email, String numeroPortable) {
		super(nom, prenom, age);
		this.username = username;
		this.password = password;
		this.email = email;
		this.numeroPortable = numeroPortable;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroPortable() {
		return numeroPortable;
	}

	public void setNumeroPortable(String numeroPortable) {
		this.numeroPortable = numeroPortable;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
	
}
