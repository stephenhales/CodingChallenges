package todo.exception;

import java.util.List;

public class ValidationException extends RuntimeException {

	public ValidationException(List<String> errorMessages) {
		super(errorMessages.toString());
	}
}
