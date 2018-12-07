package todo.user.api;

import java.util.List;

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

	public User addNewTask(User user, String taskDescription){
		return userService.createTaskForUser(user, taskDescription);
	}

	public User completeTask(User user, int taskId){
		return userService.completeTaskForUser(user, taskId);
	}

	public List<Task> getIncompleteTasks(User user){
		return userService.getIncompleteTasksForUser(user);
	}
}
