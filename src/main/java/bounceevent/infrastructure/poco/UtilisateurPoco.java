package bounceevent.infrastructure.poco;

import bounceevent.domain.entities.Personne;
import bounceevent.infrastructure.dto.inscription.RegisterDtoRequest;

public class UtilisateurPoco {
	RegisterDtoRequest dtoRequest;
	
	UtilisateurPoco(RegisterDtoRequest dtoRequest) {
		this.dtoRequest = dtoRequest;
	}
	
	public static boolean controleInscriptionProprietes(RegisterDtoRequest dtoRequest) {
		return UtilisateurPoco.checkIfDtoIsNotBlank(dtoRequest) && 
			   UtilisateurPoco.checkEmail(dtoRequest) 			&&
			   UtilisateurPoco.checkIfUsernameExiste(dtoRequest)&&
			   UtilisateurPoco.checkIfEmailExiste(dtoRequest)    ?  
					   true :  false;
	}
	

	private static boolean checkIfEmailExiste(RegisterDtoRequest dtoRequest2) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean checkIfUsernameExiste(RegisterDtoRequest dtoRequest2) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean checkEmail(RegisterDtoRequest dtoRequest) {
		return true;
	}
	
	public static boolean checkIfDtoIsNotBlank(RegisterDtoRequest dtoRequest) {
		if(dtoRequest.getAge() != null && !dtoRequest.getNom().isBlank() && 
		  !dtoRequest.getPrenom().isBlank() && !dtoRequest.getUsername().isBlank() &&
		  !dtoRequest.getEmail().isBlank() && !dtoRequest.getPassword().isEmpty()) {
				
			return true;
		}else {
			return false;
		}
	}
}
