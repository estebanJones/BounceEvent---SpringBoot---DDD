package bounceevent.infrastructure.dto.connection;

public class DtoConnectionRequest {
	private String email;
	private String password;
	private boolean resterConnecter;
	
	public DtoConnectionRequest(String email, String password, boolean resterConnecter) {
		this.email = email;
		this.password = password;
		this.resterConnecter = resterConnecter;
	}

	public DtoConnectionRequest() {
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isResterConnecter() {
		return resterConnecter;
	}

	public void setResterConnecter(boolean resterConnecter) {
		this.resterConnecter = resterConnecter;
	}
}
