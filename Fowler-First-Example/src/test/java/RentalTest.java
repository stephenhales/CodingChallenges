import org.junit.Test;

import refactored.Movie;
import refactored.Rental;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class RentalTest {
	private static int dayRented = 1;

	@Test
	public void canGetDaysRented(){
		//Arrange
		Movie movie = mock(Movie.class);
		Rental rental = new Rental(movie, dayRented);

		//Act
		int daysRentedResult = rental.getDaysRented();

		//Assert
		assertThat(daysRentedResult, is(dayRented));
	}

	@Test
	public void canGetMovie(){
		//Arrange
		Movie movie = mock(Movie.class);
		Rental rental = new Rental(movie, dayRented);

		//Act
		Movie movieResult = rental.getMovie();

		//Assert
		assertThat(movieResult, is(movie));
	}
}
