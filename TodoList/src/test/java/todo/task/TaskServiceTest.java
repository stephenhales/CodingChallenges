package todo.task;

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
	public void canCreateUser() throws ValidationException {
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
	public void canCompleteTask() {
		//Arrange
		String id = "1";

		//Act
		//taskService.completeTask();

		//Assert
		//thrown.expect(UserException.class);
		//thrown.expectMessage("Name is required");
	}
}