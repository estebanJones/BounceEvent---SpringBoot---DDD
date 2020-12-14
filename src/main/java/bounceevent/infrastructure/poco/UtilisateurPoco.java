package bounceevent.infrastructure.poco;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;
import bounceevent.infrastructure.repository.UtilisateurRepository;

@Component
public class UtilisateurPoco {
	private UtilisateurRepository utilisateurRepository;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	
	UtilisateurPoco(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}
	
	public boolean controleInscriptionProprietes(RegisterDtoRequest dtoRequest) {
		return (this.checkIfDtoIsNotBlank(dtoRequest) && 
				this.checkEmailSyntaxe(dtoRequest) 			&&
				this.checkIfUsernameNotExiste(dtoRequest)&&
			    this.checkIfEmailExiste(dtoRequest))    ?  
					   true :  false;
	}
	

	private boolean checkIfEmailExiste(RegisterDtoRequest dtoRequest) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean checkIfUsernameNotExiste(RegisterDtoRequest dtoRequest) {
		Optional<Utilisateur> utilisateur = this.utilisateurRepository.findByUsername(dtoRequest.getUsername());

			return (!utilisateur.isPresent()) ? true : false;			
		
	}

	public boolean checkEmailSyntaxe(RegisterDtoRequest dtoRequest) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(dtoRequest.getEmail());
        return matcher.find();
	}
	
	public boolean checkIfDtoIsNotBlank(RegisterDtoRequest dtoRequest) {
		if(dtoRequest.getAge() != null && !dtoRequest.getNom().isBlank() && 
		  !dtoRequest.getPrenom().isBlank() && !dtoRequest.getUsername().isBlank() &&
		  !dtoRequest.getEmail().isBlank() && !dtoRequest.getPassword().isBlank()) {
				
			return true;
		}else {
			return false;
		}
	}
}
