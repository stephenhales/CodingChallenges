package todo.user.service;

import org.springframework.stereotype.Service;

import todo.exception.UserException;
import todo.user.model.User;

@Service
public class UserServiceBean {

	public User createUser(String name) throws UserException{
		//validation
		isNameValid(name);

		User user = new User();
		user.setName(name);
		return user;
	}

	private Boolean isNameValid(String name) throws UserException{
		if(name == null){throw new UserException("Name is required"); }
		if(name.isEmpty()){throw new UserException("Name is empty"); }
		if(name.length() > 100){throw new UserException("Name is too long"); }
		return true;
	}
}
