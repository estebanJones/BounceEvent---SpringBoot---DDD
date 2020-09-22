package bounceevent.infrastructure.dto.connection;

public class DtoConnectionResponse {
	private String tokenConnection;

	public DtoConnectionResponse(String tokenConnection) {
		this.tokenConnection = tokenConnection;
	}

	public String getTokenConnection() {
		return tokenConnection;
	}

	public void setTokenConnection(String tokenConnection) {
		this.tokenConnection = tokenConnection;
	}
	
	
}
