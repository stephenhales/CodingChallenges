package todo.user.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.common.Enums;
import todo.common.ValidationService;
import todo.exception.UserException;
import todo.exception.ValidationException;
import todo.user.model.User;


@Service
public class UserServiceBean {

	@Autowired
	private ValidationService validationService;

	public User createUser(String name, String email) throws ValidationException, UserException {
		validateName(name);
		validateEmail(email);

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		return user;
	}

	private void validateName(String name) throws ValidationException, UserException {
		List<String> errors = new ArrayList<>();
		if(name == null){throw new UserException(Enums.NAMEREQUIRED); }
		if(name.isEmpty()){errors.add(Enums.NAMEEMPTY); }
		if(name.length() > 100){errors.add(Enums.NAMETOOLONG); }
		if(stringHasNumber(name)){errors.add(Enums.NAMEHASNUMBERS);}

		if(!errors.isEmpty()){
			throw new ValidationException(errors);
		}
	}

	private void validateEmail(String email) throws ValidationException {
		List<String> errors = new ArrayList<>();
		if(!emailHasAMP(email)){ errors.add(Enums.EMAILHASNOAMP); }
		if(!emailHasMaxOneAMP(email)){ errors.add(Enums.EMAILHASTOOMANYAMP); }

		if(!errors.isEmpty()){
			throw new ValidationException(errors);
		}
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
