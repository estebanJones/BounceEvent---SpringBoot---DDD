package bounceevent.infrastructure.dto.connection;

public class DtoConnectionResponse {
	private String tokenConnection;
	private String username;
	private String email;
	private Long utilisateurId;
	
	public DtoConnectionResponse() {
		
	}
	
	public DtoConnectionResponse(String tokenConnection, String username, Long utilisateurId, String email) {
		this.tokenConnection = tokenConnection;
		this.username = username;
		this.utilisateurId = utilisateurId;
		this.email = email;
	}

	public String getTokenConnection() {
		return tokenConnection;
	}

	public void setTokenConnection(String tokenConnection) {
		this.tokenConnection = tokenConnection;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
