package bounceevent.infrastructure.exception;

public class PasswordIncorrectException extends Exception {
	boolean invalide = false;
	
	public PasswordIncorrectException(String message) {
		super(message);
		
	}
}
