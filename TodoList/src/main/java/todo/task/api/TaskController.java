package todo.task.api;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.exception.UserException;
import todo.task.model.Task;
import todo.task.service.TaskServiceBean;
import todo.user.model.User;
import todo.user.service.UserServiceBean;

@Service
public class TaskController {

	@Autowired
	private TaskServiceBean taskService;

	public Task createTask(String description) {
		return null;
	}
}
