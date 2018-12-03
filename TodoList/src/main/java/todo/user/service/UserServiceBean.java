package todo.user.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.common.ValidationService;
import todo.exception.UserException;
import todo.exception.ValidationException;
import todo.user.model.User;

@Service
public class UserServiceBean {

	public User createUser(String name, String email) throws ValidationException, UserException {
		validateName(name);
		validateEmail(email);

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		return user;
	}

	private List<String> validateName(String name) throws ValidationException, UserException {
		List<String> errors = new ArrayList<>();
		if(name == null){throw new UserException("Name is required"); }
		if(name.isEmpty()){errors.add("Name is empty"); }
		if(name.length() > 100){errors.add("Name is too long"); }
		if(stringHasNumber(name)){errors.add("Name contains numbers");}

		if(!errors.isEmpty()){
			throw new ValidationException(errors);
		}
		return errors;
	}

	private List<String> validateEmail(String email) throws ValidationException {
		List<String> errors = new ArrayList<>();
		if(!emailHasAMP(email)){ errors.add("Email has no @"); }
		if(!emailHasMaxOneAMP(email)){ errors.add("Email has multiple @"); }

		if(!errors.isEmpty()){
			throw new ValidationException(errors);
		}
		return errors;
	}

	private Boolean emailHasMaxOneAMP(String email){
		return StringUtils.countMatches(email,"@") <= 1;
	}

	private Boolean emailHasAMP(String email){
		return email.contains("@");
	}

	private Boolean stringHasNumber(String string){
		String numbers = string.replaceAll("[^0-9]","");
		return !numbers.isEmpty();
	}
}
