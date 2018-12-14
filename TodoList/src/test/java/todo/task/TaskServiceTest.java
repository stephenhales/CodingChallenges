package todo.task;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import todo.common.Enums;
import todo.common.ValidationService;
import todo.exception.ValidationException;
import todo.task.model.Task;
import todo.task.service.TaskServiceBean;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

	@Mock
	private ValidationService validationService;

	@InjectMocks
	private TaskServiceBean taskService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private String validDescription = "laundry";

	@Test
	public void EmptyDescriptionThrowsException() throws ValidationException {
		//Arrange
		String description = "";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage(Enums.DESCRIPTIONEMPTY);

		//Act
		taskService.createTask(description);
	}

	@Test
	public void canCreateTask() throws ValidationException {
		//Arrange
		int expectedId = 0;

		//Act
		Task taskResult = taskService.createTask(validDescription);

		//Assert
		assertThat(taskResult.getDescription(), is(validDescription));
		assertThat(taskResult.getId(), is(expectedId));
		assertThat(taskResult.getIsCompleted(), is(false));
	}

	@Test
	public void canCompleteTask() throws ValidationException {
		//Arrange
		int taskId = 0;
		List<Task> tasks = new ArrayList<>();
		tasks.add(taskService.createTask(validDescription));

		//Act
		Task taskResult = taskService.completeTask(taskId, tasks).get(0);

		//Assert
		assertThat(taskResult.getId(), is(taskId));
		assertThat(taskResult.getIsCompleted(), is(true));
	}

	@Test
	public void getIncompleteTasks() throws ValidationException {
		//Arrange
		List<Task> tasks = new ArrayList<>();
		tasks.add(taskService.createTask(validDescription));
		tasks.add(taskService.createTask(validDescription));

		//Act
		List<Task> incompleteTasks = taskService.getIncompleteTasks(tasks);

		//Assert
		assertThat(incompleteTasks.size(), is(2));
		assertThat(incompleteTasks.get(0).getId(), is(0));
		assertThat(incompleteTasks.get(1).getId(), is(1));
	}

	@Test
	public void getIncompleteTasks_AfterTaskCompleted() throws ValidationException {
		//Arrange
		int taskId = 0;
		List<Task> tasks = new ArrayList<>();
		tasks.add(taskService.createTask(validDescription));
		tasks.add(taskService.createTask(validDescription));

		//Act
		List<Task> todoList = taskService.completeTask(taskId, tasks);
		List<Task> incompleteTasks = taskService.getIncompleteTasks(todoList);

		//Assert
		assertThat(incompleteTasks.size(), is(1));
		assertThat(incompleteTasks.get(0).getId(), is(1));
	}
}