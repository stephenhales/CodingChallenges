import org.junit.Test;

import refactored.Movie;
import refactored.Rental;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;


public class RentalTest {

	private static int dayRented = 1;
	private static String regularMovie = "Regular Movie";
	private static String newReleaseMovie = "New Release Movie";
	private static String childrenMovie = "Children Movie";

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

	@Test
	public void canGetCost_ForRegularMovieRental_twoDays(){
		//Arrange
		Rental rental = mockRental(mockRegularMovie(),2);

		//Act
		double rentalCostResult = Rental.getCostForMovieRental(rental);

		//Assert
		double expectedCost = 2;
		assertThat(rentalCostResult, is(expectedCost));
	}

	@Test
	public void canGetCost_ForRegularMovieRental_threeDays(){
		//Arrange
		Rental rental = mockRental(mockRegularMovie(),3);

		//Act
		double rentalCostResult = Rental.getCostForMovieRental(rental);

		//Assert
		double expectedCost = 3.5;
		assertThat(rentalCostResult, is(expectedCost));
	}

	@Test
	public void canGetCost_ForNewReleaseMovieRental(){
		//Arrange
		Rental rental = mockRental(mockNewReleaseMovie(),2);

		//Act
		double rentalCostResult = Rental.getCostForMovieRental(rental);

		//Assert
		double expectedCost = 6;
		assertThat(rentalCostResult, is(expectedCost));
	}

	@Test
	public void canGetCost_ForChildrenMovieRental_threeDays(){
		//Arrange
		Rental rental = mockRental(mockChildrenMovie(),3);

		//Act
		double rentalCostResult = Rental.getCostForMovieRental(rental);

		//Assert
		double expectedCost = 1.5;
		assertThat(rentalCostResult, is(expectedCost));
	}

	@Test
	public void canGetCost_ForChildrenMovieRental_fiveDays(){
		//Arrange
		Rental rental = mockRental(mockChildrenMovie(),5);

		//Act
		double rentalCostResult = Rental.getCostForMovieRental(rental);

		//Assert
		double expectedCost = 4.5;
		assertThat(rentalCostResult, is(expectedCost));
	}

	@Test
	public void canGetRenterPoints_ForRegularMovieRental(){
		//Arrange
		Rental rental = mockRental(mockRegularMovie(),1);

		//Act
		int points = Rental.getRenterPoints(rental);

		//Assert
		int expectedPoints = 1;
		assertThat(points, is(expectedPoints));
	}

	@Test
	public void canGetRenterPoints_ForNewReleaseMovieRental_OneDay(){
		//Arrange
		Rental rental = mockRental(mockNewReleaseMovie(),1);

		//Act
		int points = Rental.getRenterPoints(rental);

		//Assert
		int expectedPoints = 1;
		assertThat(points, is(expectedPoints));
	}

	@Test
	public void canGetRenterPoints_ForNewReleaseMovieRental_TwoDays(){
		//Arrange
		Rental rental = mockRental(mockNewReleaseMovie(),2);

		//Act
		int points = Rental.getRenterPoints(rental);

		//Assert
		int expectedPoints = 2;
		assertThat(points, is(expectedPoints));
	}

	@Test
	public void canGetRenterPoints_ForChildrenMovieRental() {
		//Arrange
		Rental rental = mockRental(mockChildrenMovie(),1);

		//Act
		int points = Rental.getRenterPoints(rental);

		//Assert
		int expectedPoints = 1;
		assertThat(points, is(expectedPoints));
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
}
