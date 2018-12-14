import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import objects.Movie;

public class MovieTest {

	private static String validTitle = "Bourne";
	private static int validPriceCode = 1;

	@Test
	public void canGetPriceCode(){
		//Arrange
		Movie movie = new Movie(validTitle, validPriceCode);

		//Act
		int priceCode = movie.getPriceCode();

		//Assert
		assertThat(priceCode, is(validPriceCode));
	}

	@Test
	public void canSetPriceCode(){
		//Arrange
		Movie movie = new Movie(validTitle, validPriceCode);
		int newPriceCode = 2;

		//Act
		movie.setPriceCode(newPriceCode);

		//Assert
		assertThat(movie.getPriceCode(), is(newPriceCode));
	}

	@Test
	public void canGetTitle(){
		//Arrange
		Movie movie = new Movie(validTitle, validPriceCode);

		//Act
		String movieTitle = movie.getTitle();

		//Assert
		assertThat(movieTitle, is(validTitle));
	}

}
