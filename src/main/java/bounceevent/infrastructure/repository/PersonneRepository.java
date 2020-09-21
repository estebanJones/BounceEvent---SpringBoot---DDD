package bounceevent.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bounceevent.domain.entities.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer> {

}
