import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {
	
	private static String validTitle = "Bourne";
	private static int validPriceCode = 1;

	@Test
	private void canGetPriceCode(){
		//Arrange
		Movie movie = new Movie(validTitle, validPriceCode);

		//Act
		int priceCode = movie.getPriceCode();

		//Assert
		assertThat(priceCode, is(validPriceCode));
	}

	@Test
	private void canSetPriceCode(){
		//Arrange
		Movie movie = new Movie(validTitle, validPriceCode);
		int newPriceCode = 2;

		//Act
		movie.setPriceCode(newPriceCode);

		//Assert
		assertThat(movie.getPriceCode(), is(newPriceCode));
	}

	@Test
	private void canGetTitle(){
		//Arrange
		Movie movie = new Movie(validTitle, validPriceCode);

		//Act
		String priceCode = movie.getTitle();

		//Assert
		assertThat(priceCode, is(validTitle));
	}

}
