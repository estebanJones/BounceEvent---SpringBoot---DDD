package bounceevent.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bounceevent.domain.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

}
