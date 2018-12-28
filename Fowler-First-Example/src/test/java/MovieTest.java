import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import refactored.Movie;

public class MovieTest {
	
	private static String regularMovie = "Regular Movie";
	private static String newReleaseMovie = "New Release Movie";
	private static String childrenMovie = "Children Movie";

	@Test
	public void canGetCost_ForRegularMovie_twoDays(){
		//Arrange
		Movie movie = mockRegularMovie();
		int daysRented = 2;

		//Act
		double movieCostResult = movie.getCost(daysRented);

		//Assert
		double expectedCost = 2;
		assertThat(movieCostResult, is(expectedCost));
	}

	@Test
	public void canGetCost_ForRegularMovie_threeDays(){
		//Arrange
		Movie movie = mockRegularMovie();
		int daysRented = 3;

		//Act
		double movieCostResult = movie.getCost(daysRented);

		//Assert
		double expectedCost = 3.5;
		assertThat(movieCostResult, is(expectedCost));
	}

	@Test
	public void canGetCost_ForNewReleaseMovie(){
		//Arrange
		Movie movie = mockNewReleaseMovie();
		int daysRented = 2;

		//Act
		double movieCostResult = movie.getCost(daysRented);

		//Assert
		double expectedCost = 6;
		assertThat(movieCostResult, is(expectedCost));
	}

	@Test
	public void canGetCost_ForChildrenMovie_threeDays(){
		//Arrange
		Movie movie = mockChildrenMovie();
		int daysRented = 3;

		//Act
		double movieCostResult = movie.getCost(daysRented);

		//Assert
		double expectedCost = 1.5;
		assertThat(movieCostResult, is(expectedCost));
	}

	@Test
	public void canGetCost_ForChildrenMovie_fiveDays(){
		//Arrange
		Movie movie = mockChildrenMovie();
		int daysRented = 5;

		//Act
		double movieCostResult = movie.getCost(daysRented);

		//Assert
		double expectedCost = 4.5;
		assertThat(movieCostResult, is(expectedCost));
	}

	@Test
	public void canGetRenterPoints_ForRegularMovie(){
		//Arrange
		Movie movie = mockRegularMovie();
		int daysRented = 5;

		//Act
		int points = movie.getRenterPoints(daysRented);

		//Assert
		int expectedPoints = 1;
		assertThat(points, is(expectedPoints));
	}

	@Test
	public void canGetRenterPoints_ForNewReleaseMovie_OneDay(){
		//Arrange
		Movie movie = mockNewReleaseMovie();
		int daysRented = 1;

		//Act
		int points = movie.getRenterPoints(daysRented);

		//Assert
		int expectedPoints = 1;
		assertThat(points, is(expectedPoints));
	}

	@Test
	public void canGetRenterPoints_ForNewReleaseMovie_TwoDays(){
		//Arrange
		Movie movie = mockNewReleaseMovie();
		int daysRented = 2;

		//Act
		int points = movie.getRenterPoints(daysRented);

		//Assert
		int expectedPoints = 2;
		assertThat(points, is(expectedPoints));
	}

	@Test
	public void canGetRenterPoints_ForChildrenMovie() {
		//Arrange
		Movie movie = mockChildrenMovie();
		int daysRented = 5;

		//Act
		int points = movie.getRenterPoints(daysRented);

		//Assert
		int expectedPoints = 1;
		assertThat(points, is(expectedPoints));
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
