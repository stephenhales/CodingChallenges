package todo.user;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.apache.commons.lang3.StringUtils;

import todo.common.Enums;
import todo.common.ValidationService;
import todo.exception.UserException;
import todo.exception.ValidationException;
import todo.task.model.Task;
import todo.task.service.TaskServiceBean;
import todo.user.model.User;
import todo.user.repository.UserRepository;
import todo.user.service.UserServiceBean;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock
	private ValidationService validationService;

	@Mock
	private TaskServiceBean taskService;

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserServiceBean userService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private String validName = "a";
	private String validEmail = "a@a.com";
	private String validTaskDescription = "laundry";

	@Test
	public void nullNameThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = null;

		//Assert
		thrown.expect(UserException.class);
		thrown.expectMessage(Enums.NAMEREQUIRED);

		//Act
		userService.createUser(name, validEmail);
	}

	@Test
	public void emptyNameThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = "";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage(Enums.NAMEEMPTY);

		//Act
		userService.createUser(name, validEmail);
	}

	@Test
	public void longNameThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = StringUtils.repeat("a", 101);

		//Assert
		Assert.assertTrue(name.length() > 100);
		thrown.expect(ValidationException.class);
		thrown.expectMessage(Enums.NAMETOOLONG);

		//Act
		userService.createUser(name, validEmail);
	}

	@Test
	public void nameContainsNumberThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = "1";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage(Enums.NAMEHASNUMBERS);

		//Act
		userService.createUser(name, validEmail);
	}

	@Test
	public void nameContainsNumberAndTooLongThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = StringUtils.repeat("1", 101);

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage(Enums.NAMEHASNUMBERS);
		thrown.expectMessage(Enums.NAMETOOLONG);

		//Act
		userService.createUser(name, validEmail);
	}

	@Test
	public void emailNoAMPThrowsException() throws ValidationException, UserException {
		//Arrange
		String email = "aa.com";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage(Enums.EMAILHASNOAMP);

		//Act
		userService.createUser(validName, email);
	}

	@Test
	public void emailMaxOneAMPThrowsException() throws ValidationException, UserException {
		//Arrange
		String email = "@@";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage(Enums.EMAILHASTOOMANYAMP);

		//Act
		userService.createUser(validName, email);
	}

	@Test
	public void emailNullBeforeAMPThrowsException() throws ValidationException, UserException {
		//Arrange
		String email = "@a.com";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage(Enums.EMAILNULLBEFOREAMP);

		//Act
		userService.createUser(validName, email);
	}

	@Test
	public void emailNullAfterAMPThrowsException() throws ValidationException, UserException {
		//Arrange
		String email = "a@";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage(Enums.EMAILNULLAFTERAMP);

		//Act
		userService.createUser(validName, email);
	}

	@Test
	public void canCreateUser() throws ValidationException, UserException {
		//Act
		User userResult = userService.createUser(validName, validEmail);

		//Assert
		assertThat(userResult.getName(), is(validName));
		assertThat(userResult.getEmail(), is(validEmail));
	}

	@Test
	public void canCreateTaskForUser() throws ValidationException, UserException {
		//Arrange
		User user = userService.createUser(validName, validEmail);
		Task task = new Task(0, validTaskDescription);
		when(taskService.createTask(anyString())).thenReturn(task);

		//Act
		User userResult = userService.createTaskForUser(user, validTaskDescription);

		//Assert
		assertNotNull(userResult.getTasks());
		assertThat(userResult.getTasks().size(), is(1));
	}

	@Test
	public void canCreateValidTaskForUser() throws ValidationException, UserException {
		//Arrange
		User user = userService.createUser(validName, validEmail);
		Task task = new Task(0, validTaskDescription);

		when(taskService.createTask(anyString())).thenReturn(task);

		//Act
		User userResult = userService.createTaskForUser(user, validTaskDescription);
		Task taskResult = userResult.getTasks().get(0);

		//Assert
		assertThat(taskResult.getId(), is(0));
		assertThat(taskResult.getDescription(), is(validTaskDescription));
		assertThat(taskResult.getIsCompleted(), is(false));
	}

	@Test
	public void canCompleteTaskForUser() throws ValidationException, UserException {
		//Arrange
		User user = userService.createUser(validName, validEmail);
		List<Task> mockTasks = mockTaskListForUser(validTaskDescription);
		user.setTasks(mockTasks);

		when(taskService.completeTask(0, mockTasks)).thenReturn(mockTasks);

		//Act
		User userResult = userService.completeTaskForUser(user, 0);

		//Assert
		assertNotNull(userResult.getTasks());
		assertThat(userResult.getTasks().size(), is(1));
	}

	@Test
	public void verifyCanCompleteTaskForUser() throws ValidationException, UserException {
		//Arrange
		User user = userService.createUser(validName, validEmail);
		List<Task> mockTasks = mockTaskListForUser(validTaskDescription);
		user.setTasks(mockTasks);

		when(taskService.completeTask(0, mockTasks)).thenReturn(mockTasks);

		//Act
		User userResult = userService.completeTaskForUser(user, 0);

		//Assert
		assertEquals(mockTasks, userResult.getTasks());
	}

	@Test
	public void canGetIncompleteTasksForUser() throws ValidationException, UserException {
		//Arrange
		User user = userService.createUser(validName, validEmail);
		List<Task> mockTasks = mockTaskListForUser(validTaskDescription);
		user.setTasks(mockTasks);

		when(taskService.getIncompleteTasks(mockTasks)).thenReturn(mockTasks);

		//Act
		List<Task> resultIncompleteTasks = userService.getIncompleteTasksForUser(user);

		//Assert
		assertEquals(mockTasks, resultIncompleteTasks);
	}

	private List<Task> mockTaskListForUser(String taskDescription){
		List<Task> mockTasks = new ArrayList<>();
		mockTasks.add(new Task(0, taskDescription));
		return mockTasks;
	}
}