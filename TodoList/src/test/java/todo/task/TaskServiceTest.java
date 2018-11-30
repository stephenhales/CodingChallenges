package todo.task;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import todo.task.service.TaskServiceBean;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

	@InjectMocks
	private TaskServiceBean taskService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	//@Test
	public void NullNameThrowsException() {
		//Arrange
		String name = null;

		//Assert
		//thrown.expect(UserException.class);
		//thrown.expectMessage("Name is required");

		//Act
		//taskService.(name);
	}
}