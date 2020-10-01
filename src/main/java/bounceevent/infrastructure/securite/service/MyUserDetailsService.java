package bounceevent.infrastructure.securite.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.repository.UtilisateurRepository;
import bounceevent.infrastructure.securite.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {
	private UtilisateurRepository utilisateurRepo;
	
	public MyUserDetailsService(UtilisateurRepository utilisateurRepo) {
		this.utilisateurRepo = utilisateurRepo;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> utilisateur = this.utilisateurRepo.findByUsername(username);
		utilisateur.orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé " + username));
		return utilisateur.map(MyUserDetails::new).get();

	}

}
