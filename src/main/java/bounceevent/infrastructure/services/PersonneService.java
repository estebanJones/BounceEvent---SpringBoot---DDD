package bounceevent.infrastructure.services;

import org.springframework.stereotype.Service;

import bounceevent.domain.entities.Personne;
import bounceevent.infrastructure.repository.PersonneRepository;

@Service
public class PersonneService {
	private PersonneRepository personneRepository;
	
	public PersonneService(PersonneRepository personneRepository) {
		this.personneRepository = personneRepository;
	}
	
	public Personne insertPersonne(Personne personne) {
		return this.personneRepository.save(personne);
	}
}
