package todo.exception;

public class UserException extends RuntimeException {

	public UserException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

	public UserException(String errorMessage) {
		super(errorMessage);
	}
}
