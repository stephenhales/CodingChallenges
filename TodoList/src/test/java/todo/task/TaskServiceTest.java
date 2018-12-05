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
import todo.task.service.TaskServiceBean;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

	@Mock
	private ValidationService validationService;

	@InjectMocks
	private TaskServiceBean taskService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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