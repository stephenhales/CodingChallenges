package todo.user.api;

import java.util.Collections;
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

	public User createUser(String name) throws ValidationException, UserException {
		return userService.createUser(name, "");
	}

	public void addNewTask(User user, Task task){

	}

	public void completeTask(User user, String taskId){

	}

	public List<Task> getCompletedTasks(User user){
		return Collections.emptyList();
	}

	public List<Task> getIncompleteTasks(User user){
		return Collections.emptyList();
	}
}
