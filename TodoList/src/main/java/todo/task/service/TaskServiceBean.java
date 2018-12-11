package todo.task.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todo.common.Enums;
import todo.common.ValidationService;
import todo.exception.ValidationException;
import todo.task.model.Task;

@Service
public class TaskServiceBean {

	@Autowired
	private ValidationService validationService;

	private int nextTaskId = 0;

	public Task createTask(String description) throws ValidationException {
		validationService.validate(validateDescription(description));
		return new Task(nextTaskId++, description);
	}

	public List<Task> completeTask(int taskId, List<Task> tasks){
		tasks.stream()
			.filter(task -> task.getId() == taskId)
			.findFirst()
			.ifPresent(task -> task.setIsCompleted(true));
		return tasks;
	}

	public List<Task> getIncompleteTasks(List<Task> tasks){
		//TODO
		return new ArrayList<>();
	}

	private List<String> validateDescription(String description){
		List<String> errors = new ArrayList<>();
		if(description.isEmpty()) { errors.add(Enums.DESCRIPTIONEMPTY); }
		return errors;
	}
}
