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
		Rental rental = mockRegularRental(1);
		Customer customer = mockCustomer();

		//Act
		customer.addRental(rental);
		String statement = customer.statement();

		//Assert
		String expectedStatement = createStatement(regularMovie, 2);
		assertThat(statement, is(expectedStatement));
	}

	@Test
	public void regularMovie_WhenOverTwoDays(){
		//Arrange

		//Act

		//Assert
	}

	private Customer mockCustomer(){
		return new Customer(validName);
	}

	private Rental mockRegularRental(int days){
		return new Rental(mockRegularMovie(), days);
	}

	private Movie mockRegularMovie(){
		return new Movie(regularMovie, Movie.REGULAR);
	}

	private String createStatement( String movieTitle, double amountDue){
		String result = "Rental record for " + validName + "\n";
		result += creatStatementMovieRow(movieTitle, amountDue);
		result += "Amount owed is " + String.valueOf(amountDue) + "\n";
		result += "You earned " + "1"  + " frequent renter points";
		return result;
	}

	private String creatStatementMovieRow(String movieTitle, double amountDue){
		return "\t" + movieTitle + "\t" + String.valueOf(amountDue) + "\n";
	}
}
