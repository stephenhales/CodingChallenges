package todo.task.service;

import org.springframework.stereotype.Service;

import todo.task.model.Task;

@Service
public class TaskServiceBean {

	public Task createTask(String description){
		isDescriptionValid(description);

		Task task = new Task();
		task.setDescription(description);
		return task;
	}

	private void isDescriptionValid(String name){

	}
}
