package bounceevent.infrastructure.poco;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import bounceevent.domain.entities.Utilisateur;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;
import bounceevent.infrastructure.repository.UtilisateurRepository;

public class UtilisateurPoco {
	RegisterDtoRequest dtoRequest;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@Autowired
	static UtilisateurRepository utilisateurRepository;
	
	
	UtilisateurPoco(RegisterDtoRequest dtoRequest) {
		this.dtoRequest = dtoRequest;
	}
	
	public static boolean controleInscriptionProprietes(RegisterDtoRequest dtoRequest) {
		System.out.println("dto " + dtoRequest.getUsername());
		return (UtilisateurPoco.checkIfDtoIsNotBlank(dtoRequest) && 
			   UtilisateurPoco.checkEmailSyntaxe(dtoRequest) 			&&
			   UtilisateurPoco.checkIfUsernameNotExiste(dtoRequest)&&
			   UtilisateurPoco.checkIfEmailExiste(dtoRequest))    ?  
					   true :  false;
	}
	

	private static boolean checkIfEmailExiste(RegisterDtoRequest dtoRequest) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean checkIfUsernameNotExiste(RegisterDtoRequest dtoRequest) {
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByUsername(dtoRequest.getUsername());
		System.out.println((!utilisateur.isPresent()) ? true : false);
		return (!utilisateur.isPresent()) ? true : false;			
		
	}

	public static boolean checkEmailSyntaxe(RegisterDtoRequest dtoRequest) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(dtoRequest.getEmail());
        return matcher.find();
	}
	
	public static boolean checkIfDtoIsNotBlank(RegisterDtoRequest dtoRequest) {
		if(dtoRequest.getAge() != null && !dtoRequest.getNom().isBlank() && 
		  !dtoRequest.getPrenom().isBlank() && !dtoRequest.getUsername().isBlank() &&
		  !dtoRequest.getEmail().isBlank() && !dtoRequest.getPassword().isBlank()) {
				
			return true;
		}else {
			return false;
		}
	}
}
