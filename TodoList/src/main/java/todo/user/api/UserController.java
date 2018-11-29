package todo.user.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.task.model.Task;
import todo.user.model.User;
import todo.user.service.UserServiceBean;

@Service
public class UserController {

	@Autowired
	private UserServiceBean userService;

	public User createUser(String name){
		return userService.createUser(name);
	}

	public void createTask(User user){

	}

	public void completeTask(User user){

	}

	public List<Task> getCompletedTasks(User user){
		return Collections.emptyList();
	}

	public List<Task> getIncompleteTasks(User user){
		return Collections.emptyList();
	}
}
