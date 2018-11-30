package todo.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import todo.exception.UserException;
import todo.exception.ValidationException;
import todo.user.model.User;

@Service
public class UserServiceBean {

	public User createUser(String name) throws ValidationException, UserException {
		//validation
		isNameValid(name);

		User user = new User();
		user.setName(name);
		return user;
	}

	private void isNameValid(String name) throws ValidationException, UserException {
		List<String> errors = new ArrayList<>();
		if(name == null){throw new UserException("Name is required"); }
		if(name.isEmpty()){errors.add("Name is empty"); }
		if(name.length() > 100){errors.add("Name is too long"); }
		if(stringHasNumber(name)){errors.add("Name contains numbers");}

		if(!errors.isEmpty()){
			throw new ValidationException(errors);
		}
	}

	private Boolean stringHasNumber(String string){
		String numbers = string.replaceAll("[^0-9]","");
		return !numbers.isEmpty();
	}
}
