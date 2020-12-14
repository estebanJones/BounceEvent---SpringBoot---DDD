package bounceevent.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bounceevent.domain.entities.RoleUtilisateur;

public interface RoleUtilisateurRepository extends JpaRepository<RoleUtilisateur, Long> {

}
