package bounceevent.domain.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bouncer")
public class Bouncer extends Utilisateur{
	@OneToOne
	private Utilisateur utilisateur;
	
	public Bouncer() {
		super();
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
