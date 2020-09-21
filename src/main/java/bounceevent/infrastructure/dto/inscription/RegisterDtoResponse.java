package bounceevent.infrastructure.dto.inscription;

import bounceevent.domain.entities.Utilisateur;

public class RegisterDtoResponse {
	private String username;
	private String email;
	private String numeroPortable;
	
	public RegisterDtoResponse(Utilisateur utilisateur) {
		this.username = utilisateur.getUsername();
		this.email = utilisateur.getEmail();
		this.numeroPortable = utilisateur.getNumeroPortable();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
}
