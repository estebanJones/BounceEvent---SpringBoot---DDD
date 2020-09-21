package bounceevent.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bounceevent.domain.entities.Personne;
import bounceevent.infrastructure.repository.PersonneRepository;

@Service
public class PersonneService {
	@Autowired
	PersonneRepository personneRepository;
	
	public Personne insertPersonne(Personne personne) {
		return this.personneRepository.save(personne);
	}
}
