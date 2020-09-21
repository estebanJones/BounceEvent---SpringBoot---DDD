package bounceevent.infrastructure.dto.inscription;

public class RegisterDtoRequest {
	private Integer age;
	private String nom;
	private String prenom;
	private String email;
	private String numeroPortable;
	private String password;
	private String username;
	
	public RegisterDtoRequest(Integer age, String nom, String prenom, String email, String numeroPortable,
			String password, String username) {
		this.age = age;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numeroPortable = numeroPortable;
		this.password = password;
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
