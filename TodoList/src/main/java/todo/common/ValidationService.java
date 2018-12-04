package todo.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import todo.exception.ValidationException;

@Service
public class ValidationService {

	//This combines all validation errors into one list and throws a single exception.
	//https://docs.oracle.com/javase/1.5.0/docs/guide/language/varargs.html
	@SafeVarargs
	public final void validate(List<String>... errorLists) throws ValidationException{
		List<String> errors = new ArrayList<>();
		for(List<String> errorList: errorLists){
			errors.addAll(errorList);
		}
		if(!errors.isEmpty()){
			throw new ValidationException(errors);
		}
	}
}
