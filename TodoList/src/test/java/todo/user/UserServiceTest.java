package todo.user;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.apache.commons.lang3.StringUtils;


import todo.exception.UserException;
import todo.exception.ValidationException;
import todo.user.service.UserServiceBean;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserServiceBean userService;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private String emailString = "";

	@Test
	public void nullNameThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = null;

		//Assert
		thrown.expect(UserException.class);
		thrown.expectMessage("Name is required");

		//Act
		userService.createUser(name, emailString);
	}

	@Test
	public void emptyNameThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = "";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Name is empty");

		//Act
		userService.createUser(name, emailString);
	}

	@Test
	public void longNameThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = StringUtils.repeat("a", 101);

		//Assert
		Assert.assertTrue(name.length() > 100);
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Name is too long");

		//Act
		userService.createUser(name, emailString);
	}

	@Test
	public void nameContainsNumberThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = "1";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Name contains numbers");

		//Act
		userService.createUser(name, emailString);
	}

	@Test
	public void nameContainsNumberAndTooLongThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = StringUtils.repeat("1", 101);

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Name contains numbers");
		thrown.expectMessage("Name is too long");

		//Act
		userService.createUser(name, emailString);
	}

	@Test
	public void emailNoAMPThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = "a";
		String email = "a";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Email has no @");

		//Act
		userService.createUser(name, email);
	}

	@Test
	public void emailMaxOneAMPThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = "a";
		String email = "@@";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Email has multiple @");

		//Act
		userService.createUser(name, email);
	}
}