package todo.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import todo.exception.UserException;
import todo.exception.ValidationException;
import todo.user.model.User;

@Service
public class UserServiceBean {

	public User createUser(String name){
		//validation
		isNameValid(name);

		User user = new User();
		user.setName(name);
		return user;
	}

	private void isNameValid(String name){
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
		char[] ch = string.toCharArray();
		for(int i = 0; i< ch.length; i++){
			if(Character.isDigit(ch[i])){
				return true;
			}
		}
		return false;
	}
}
