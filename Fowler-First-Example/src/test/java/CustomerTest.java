import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import refactored.Customer;
import refactored.Movie;
import refactored.Rental;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CustomerTest {

	private static String validName = "Stephen";

	private static String regularMovie = "Regular Movie";
	private static String newReleaseMovie = "New Release Movie";

	@Test
	public void canGetCustomerName(){
		//Arrange
		Customer customer = new Customer(validName);

		//Act
		String name = customer.getName();

		//Assert
		assertThat(name, is(validName));
	}

	@Test
	public void canAddRental(){
		//Arrange
		Rental rental = mock(Rental.class);
		Customer customer = mockCustomer();

		//Act
		customer.addRental(rental);
		Object rentalResult = customer.getRentals().firstElement();

		//Assert
		assertThat(rentalResult, is((Object) rental));
	}

	/*	Statement Unit tests:	 */

	@Test
	public void regularMovie_WhenUnderTwoDays(){
		//Arrange
		Rental rental = mockRental(mockRegularMovie(),1);
		Customer customer = mockCustomer();

		//Act
		customer.addRental(rental);
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(regularMovie, 2);
		assertThat(statement, is(expectedStatement));
	}

	@Test
	public void regularMovie_WhenTwoDays(){
		//Arrange
		Rental rental = mockRental(mockRegularMovie(), 2);
		Customer customer = mockCustomer();

		//Act
		customer.addRental(rental);
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(regularMovie, 2);
		assertThat(statement, is(expectedStatement));
	}

	@Test
	public void regularMovie_WhenOverTwoDays(){
		//Arrange
		Rental rental = mockRental(mockRegularMovie(), 3);
		Customer customer = mockCustomer();

		//Act
		customer.addRental(rental);
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(regularMovie, 3.5);
		assertThat(statement, is(expectedStatement));
	}

	@Test
	public void newReleaseMovie_WhenTwoDays(){
		//Arrange
		Rental rental = mockRental(mockNewReleaseMovie(), 2);
		Customer customer = mockCustomer();

		//Act
		customer.addRental(rental);
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(newReleaseMovie, 6);
		assertThat(statement, is(expectedStatement));
	}

	@Test
	public void newReleaseMovie_WhenThreeDays(){
		//Arrange
		Rental rental = mockRental(mockNewReleaseMovie(),3);
		Customer customer = mockCustomer();

		//Act
		customer.addRental(rental);
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(newReleaseMovie, 9);
		assertThat(statement, is(expectedStatement));
	}

	private Customer mockCustomer(){
		return new Customer(validName);
	}

	private Rental mockRental(Movie movie, int days){
		return new Rental(movie, days);
	}

	private Movie mockRegularMovie(){
		return new Movie(regularMovie, Movie.REGULAR);
	}

	private Movie mockNewReleaseMovie(){
		return new Movie(newReleaseMovie, Movie.NEW_RELEASE);
	}

	private String createStatement( String movieTitle, double amountDue){
		String result = "Rental record for " + validName + "\n";
		result += creatStatementMovieRow(movieTitle, amountDue);
		result += "Amount owed is " + String.valueOf(amountDue) + "\n";
		result += "You earned x frequent renter points";
		return result;
	}

	private String createStatement( String movieTitle, double amountDue, int points){
		String result = "Rental record for " + validName + "\n";
		result += creatStatementMovieRow(movieTitle, amountDue);
		result += "Amount owed is " + String.valueOf(amountDue) + "\n";
		result += "You earned " + points  + " frequent renter points";
		return result;
	}

	private String creatStatementMovieRow(String movieTitle, double amountDue){
		return "\t" + movieTitle + "\t" + String.valueOf(amountDue) + "\n";
	}

	private String ignorePoints(String string){
		String find = "You earned \\w frequent renter points*";
		String replace = "You earned x frequent renter points";
		return string.replaceAll(find, replace);
	}
}
