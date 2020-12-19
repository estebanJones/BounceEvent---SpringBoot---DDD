package bounceevent.domain.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import bounceevent.infrastructure.enums.ERole;

@Entity
public class RoleUtilisateur extends BaseEntite{

	 @ManyToOne
     @JoinColumn(name = "utilisateur_id")
     private Utilisateur utilisateur;

    @Enumerated(EnumType.STRING)
    private ERole role;
    
	public RoleUtilisateur() {
		super();
	}
	
	
	public RoleUtilisateur(ERole role) {
		super();
		this.role = role;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ERole getRole() {
		return role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}
}
