package bounceevent.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bounceevent.domain.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
	public Optional<Utilisateur> findByEmail(String email);
	public Optional<Utilisateur> findByUsername(String username);
}	
