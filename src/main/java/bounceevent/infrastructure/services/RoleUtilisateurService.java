package bounceevent.infrastructure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import bounceevent.domain.entities.RoleUtilisateur;
import bounceevent.infrastructure.repository.RoleUtilisateurRepository;

public class RoleUtilisateurService {
	private RoleUtilisateurRepository roleRepository;
	
	public RoleUtilisateurService(RoleUtilisateurRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

}
