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

	@Test
	public void NullNameThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = null;

		//Assert
		thrown.expect(UserException.class);
		thrown.expectMessage("Name is required");

		//Act
		userService.createUser(name);
	}

	@Test
	public void EmptyNameThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = "";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Name is empty");

		//Act
		userService.createUser(name);
	}

	@Test
	public void LongNameThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = StringUtils.repeat("a", 101);

		//Assert
		Assert.assertTrue(name.length() > 100);
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Name is too long");

		//Act
		userService.createUser(name);
	}

	@Test
	public void NameContainsNumberThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = "1";

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Name contains numbers");

		//Act
		userService.createUser(name);
	}

	@Test
	public void NameContainsNumberAndTooLongThrowsException() throws ValidationException, UserException {
		//Arrange
		String name = StringUtils.repeat("1", 101);

		//Assert
		thrown.expect(ValidationException.class);
		thrown.expectMessage("Name contains numbers");
		thrown.expectMessage("Name is too long");

		//Act
		userService.createUser(name);
	}
}