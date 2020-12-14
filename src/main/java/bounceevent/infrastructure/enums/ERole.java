package bounceevent.infrastructure.enums;

public enum ERole {
	ROLE_UTILISATEUR(1), ROLE_ADMINISTRATEUR(2), ROLE_MANAGER(3);
	
	private Integer roleValue;
	
	private ERole(Integer roleValue) {
		this.roleValue = roleValue;
	}
	
	public Integer getRoleValue() {
		return this.roleValue;
	}
}
