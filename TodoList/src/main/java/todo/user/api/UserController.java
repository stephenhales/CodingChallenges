package todo.user.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.exception.UserException;
import todo.exception.ValidationException;
import todo.user.model.User;
import todo.user.service.UserServiceBean;
import todo.task.model.Task;

@Service
public class UserController {

	@Autowired
	private UserServiceBean userService;

	public User createUser(String name, String email) throws ValidationException, UserException {
		return userService.createUser(name, email);
	}

	public User getUserById(int userId){
		return userService.getUserById(userId).get();
	}

	public User addNewTask(int userId, String taskDescription) throws ValidationException{
		User user = userService.getUserById(userId).get();
		return userService.createTaskForUser(user, taskDescription);
	}

	public User completeTask(int userId, int taskId){
		User user = userService.getUserById(userId).get();
		return userService.completeTaskForUser(user, taskId);
	}

	public List<Task> getIncompleteTasks(int userId){
		User user = userService.getUserById(userId).get();
		return userService.getIncompleteTasksForUser(user);
	}
}
