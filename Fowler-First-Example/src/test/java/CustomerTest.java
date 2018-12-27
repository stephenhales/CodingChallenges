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
	private static String childrenMovie = "Children Movie";

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
		customer.addRental(rental);

		//Act
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(regularMovie, 2);
		assertThat(getTotal(statement), is(getTotal(expectedStatement)));
		assertThat(getMovieDetails(statement), is(getMovieDetails(expectedStatement)));
	}

	@Test
	public void regularMovie_WhenTwoDays(){
		//Arrange
		Rental rental = mockRental(mockRegularMovie(), 2);
		Customer customer = mockCustomer();
		customer.addRental(rental);

		//Act
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(regularMovie, 2);
		assertThat(getTotal(statement), is(getTotal(expectedStatement)));
		assertThat(getMovieDetails(statement), is(getMovieDetails(expectedStatement)));
	}

	@Test
	public void regularMovie_WhenOverTwoDays(){
		//Arrange
		Rental rental = mockRental(mockRegularMovie(), 3);
		Customer customer = mockCustomer();
		customer.addRental(rental);

		//Act
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(regularMovie, 3.5);
		assertThat(getTotal(statement), is(getTotal(expectedStatement)));
		assertThat(getMovieDetails(statement), is(getMovieDetails(expectedStatement)));
	}

	@Test
	public void newReleaseMovie_WhenTwoDays(){
		//Arrange
		Rental rental = mockRental(mockNewReleaseMovie(), 2);
		Customer customer = mockCustomer();
		customer.addRental(rental);

		//Act
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(newReleaseMovie, 6);
		assertThat(getTotal(statement), is(getTotal(expectedStatement)));
		assertThat(getMovieDetails(statement), is(getMovieDetails(expectedStatement)));
	}

	@Test
	public void newReleaseMovie_WhenThreeDays(){
		//Arrange
		Rental rental = mockRental(mockNewReleaseMovie(),3);
		Customer customer = mockCustomer();
		customer.addRental(rental);

		//Act
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(newReleaseMovie, 9);
		assertThat(getTotal(statement), is(getTotal(expectedStatement)));
		assertThat(getMovieDetails(statement), is(getMovieDetails(expectedStatement)));
	}

	@Test
	public void childrenMovie_WhenUnderThreeDays(){
		//Arrange
		Rental rental = mockRental(mockChildrenMovie(),2);
		Customer customer = mockCustomer();
		customer.addRental(rental);

		//Act
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(childrenMovie, 1.5);
		assertThat(getTotal(statement), is(getTotal(expectedStatement)));
		assertThat(getMovieDetails(statement), is(getMovieDetails(expectedStatement)));
	}

	@Test
	public void childrenMovie_WhenThreeDays(){
		//Arrange
		Rental rental = mockRental(mockChildrenMovie(), 3);
		Customer customer = mockCustomer();
		customer.addRental(rental);

		//Act
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(childrenMovie, 1.5);
		assertThat(getTotal(statement), is(getTotal(expectedStatement)));
		assertThat(getMovieDetails(statement), is(getMovieDetails(expectedStatement)));
	}

	@Test
	public void childrenMovie_WhenOverThreeDays(){
		//Arrange
		Rental rental = mockRental(mockChildrenMovie(), 4);
		Customer customer = mockCustomer();
		customer.addRental(rental);

		//Act
		String statement = ignorePoints(customer.statement());

		//Assert
		String expectedStatement = createStatement(childrenMovie, 3);
		assertThat(getTotal(statement), is(getTotal(expectedStatement)));
		assertThat(getMovieDetails(statement), is(getMovieDetails(expectedStatement)));
	}

	/*	Statement Unit tests: Renter Points	 */

	@Test
	public void regularMovie_HasOneRenterPoint(){
		//Arrange
		Rental rental = mockRental(mockRegularMovie(), 1);
		Customer customer = mockCustomer();
		customer.addRental(rental);

		//Act
		String statement = customer.statement();

		//Assert
		String expectedStatement = createStatement(regularMovie, 2, 1);
		assertThat(getTotal(statement), is(getTotal(expectedStatement)));
		assertThat(getMovieDetails(statement), is(getMovieDetails(expectedStatement)));
	}

	@Test
	public void newReleaseMovie_WhenRentedOneDay_HasOneRenterPoint(){
		//Arrange
		Rental rental = mockRental(mockNewReleaseMovie(), 1);
		Customer customer = mockCustomer();
		customer.addRental(rental);

		//Act
		String statement = customer.statement();

		//Assert
		String expectedStatement = createStatement(newReleaseMovie, 3, 1);
		assertThat(getTotal(statement), is(getTotal(expectedStatement)));
		assertThat(getMovieDetails(statement), is(getMovieDetails(expectedStatement)));
		assertThat(getPoints(statement), is(getPoints(expectedStatement)));
	}

	@Test
	public void newReleaseMovie_WhenRentedTwoDays_HasTwoRenterPoints(){
		//Arrange
		Rental rental = mockRental(mockNewReleaseMovie(), 2);
		Customer customer = mockCustomer();
		customer.addRental(rental);

		//Act
		String statement = customer.statement();

		//Assert
		String expectedStatement = createStatement(newReleaseMovie, 6, 2);
		assertThat(getTotal(statement), is(getTotal(expectedStatement)));
		assertThat(getMovieDetails(statement), is(getMovieDetails(expectedStatement)));
		assertThat(getPoints(statement), is(getPoints(expectedStatement)));
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

	private Movie mockChildrenMovie(){
		return new Movie(childrenMovie, Movie.CHILDREN);
	}

	private String createStatement( String movieTitle, double amountDue){
		String result = "Rental record for " + validName + "\n";
		result += statementMovieRow(movieTitle, amountDue);
		result += "Amount owed is " + String.valueOf(amountDue) + "\n";
		result += "You earned x frequent renter points";
		return result;
	}

	private String createStatement( String movieTitle, double amountDue, int points){
		String result = "Rental record for " + validName + "\n";
		result += statementMovieRow(movieTitle, amountDue);
		result += "Amount owed is " + String.valueOf(amountDue) + "\n";
		result += "You earned " + points  + " frequent renter points";
		return result;
	}

	private String statementMovieRow(String movieTitle, double amountDue){
		return "\t" + movieTitle + "\t" + String.valueOf(amountDue) + "\n";
	}

	private String ignorePoints(String string){
		String find = "You earned \\w frequent renter points*";
		String replace = "You earned x frequent renter points";
		return string.replaceAll(find, replace);
	}

	private String getTotal(String string){
		return string.split("\n")[2];
	}

	private String getMovieDetails(String string){
		return string.split("\n")[1];
	}

	private String getPoints(String string){
		return string.split("\n")[3];
	}
}
