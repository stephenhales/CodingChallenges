package todo.exception;

import java.util.List;

public class ValidationException extends Exception {
	public ValidationException(List<String> errorMessages) {
		super(errorMessages.toString());
	}
}
