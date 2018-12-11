package todo.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.common.Enums;
import todo.common.ValidationService;
import todo.exception.UserException;
import todo.exception.ValidationException;
import todo.task.model.Task;
import todo.task.service.TaskServiceBean;
import todo.user.model.User;
import todo.user.repository.UserRepository;


@Service
public class UserServiceBean {

	@Autowired
	private ValidationService validationService;

	@Autowired
	private TaskServiceBean taskService;

	@Autowired
	private UserRepository userRepository;

	public User createUser(String name, String email) throws ValidationException, UserException {
		validationService.validate(validateName(name), validateEmail(email));
		userRepository.createUser(new User(name, email));
		return new User(name, email);
	}

	public User createTaskForUser(User user, String taskDescription) throws ValidationException{
		Task newTask = taskService.createTask(taskDescription);
		user.addTask(newTask);
		userRepository.updateUser(user);
		return user;
	}

	public Optional<User> getUserById(int userId){
		return userRepository.getUserById(userId);
	}

	public User completeTaskForUser(User user, int taskId){
		List<Task> userTasks = taskService.completeTask(taskId, user.getTasks());
		user.setTasks(userTasks);
		userRepository.updateUser(user);
		return user;
	}

	public List<Task> getIncompleteTasksForUser(User user){
		return taskService.getIncompleteTasks(user.getTasks());
	}

	private List<String> validateName(String name) throws UserException {
		List<String> errors = new ArrayList<>();
		if(name == null){throw new UserException(Enums.NAMEREQUIRED); }
		if(name.isEmpty()){errors.add(Enums.NAMEEMPTY); }
		if(name.length() > 100){errors.add(Enums.NAMETOOLONG); }
		if(stringHasNumber(name)){errors.add(Enums.NAMEHASNUMBERS);}
		return errors;
	}

	private List<String> validateEmail(String email) {
		List<String> errors = new ArrayList<>();
		if(!emailHasAMP(email)){ errors.add(Enums.EMAILHASNOAMP); }
		if(!emailHasMaxOneAMP(email)){ errors.add(Enums.EMAILHASTOOMANYAMP); }
		if(emailNullBeforeAMP(email)) {errors.add(Enums.EMAILNULLBEFOREAMP); }
		if(emailNullAfterAMP(email)) {errors.add(Enums.EMAILNULLAFTERAMP); }
		return errors;
	}

	private Boolean emailHasMaxOneAMP(String email){
		return StringUtils.countMatches(email,"@") <= 1;
	}

	private Boolean emailHasAMP(String email){
		return email.contains("@");
	}

	private Boolean emailNullBeforeAMP(String email){
		return StringUtils.substringBefore(email, "@").isEmpty();
	}

	private Boolean emailNullAfterAMP(String email){
		return StringUtils.substringAfter(email, "@").isEmpty();
	}

	private Boolean stringHasNumber(String string){
		String numbers = string.replaceAll("[^0-9]","");
		return !numbers.isEmpty();
	}
}
