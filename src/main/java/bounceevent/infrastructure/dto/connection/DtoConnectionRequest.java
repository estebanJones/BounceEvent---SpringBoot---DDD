package bounceevent.infrastructure.dto.connection;

public class DtoConnectionRequest {
	private String username;
	private String password;
	private boolean resterConnecter;
	
	public DtoConnectionRequest(String username, String password, boolean resterConnecter) {
		super();
		this.username = username;
		this.password = password;
		this.resterConnecter = resterConnecter;
	}

	public DtoConnectionRequest() {
		super();
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

	public boolean isResterConnecter() {
		return resterConnecter;
	}

	public void setResterConnecter(boolean resterConnecter) {
		this.resterConnecter = resterConnecter;
	}
	
	
}
