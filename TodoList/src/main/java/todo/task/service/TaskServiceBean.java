package todo.task.service;

import org.springframework.stereotype.Service;

import todo.task.model.Task;

@Service
public class TaskServiceBean {

	public Task createTask(String id, String description){
		//validation

		//creation
		return new Task();
	}
}
