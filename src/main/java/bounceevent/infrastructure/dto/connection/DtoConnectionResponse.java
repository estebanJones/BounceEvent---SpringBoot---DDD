package bounceevent.infrastructure.dto.connection;

public class DtoConnectionResponse {
	private String tokenConnection;
	private Integer utilisateurId;
	
	public DtoConnectionResponse(String tokenConnection, Integer utilisateurId) {
		this.tokenConnection = tokenConnection;
		this.utilisateurId = utilisateurId;
	}

	public String getTokenConnection() {
		return tokenConnection;
	}

	public void setTokenConnection(String tokenConnection) {
		this.tokenConnection = tokenConnection;
	}

	public Integer getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(Integer utilisateurId) {
		this.utilisateurId = utilisateurId;
	}
	
	
}
