import java.util.Vector;

import org.junit.Test;

import objects.Customer;
import objects.Rental;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CustomerTest {

	private static String validName = "Stephen";

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
		Customer customer = new Customer(validName);

		//Act
		customer.addRental(rental);
		Object rentalResult = customer.getRentals().firstElement();

		//Assert
		assertThat(rentalResult, is((Object) rental));
	}

	/*	Statement Unit tests:	 */

	@Test
	public void canGetStatement(){
		//Arrange

		//Act

		//Assert
	}

}
