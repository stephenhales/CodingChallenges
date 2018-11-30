package Kata2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class KataTest {

	Kata newKata;

	@Before
	public void setUp(){
		newKata = new Kata();
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void zeroReturnsOne() throws Exception {
		//Arrange
		int startNumber = 0;

		//Act
		int actual = newKata.getNextPalindrome(startNumber);

		//Assert
		int expected = 1;
		assertThat(actual, is(expected));
	}

	@Test
	public void oneReturnsTwo() throws Exception {
		//Arrange
		int startNumber = 1;

		//Act
		int actual = newKata.getNextPalindrome(startNumber);

		//Assert
		int expected = 2;
		assertThat(actual, is(expected));
	}

	@Test
	public void nineReturnsEleven() throws Exception {
		//Arrange
		int startNumber = 9;

		//Act
		int actual = newKata.getNextPalindrome(startNumber);

		//Assert
		int expected = 11;
		assertThat(actual, is(expected));
	}

	@Test
	public void tenReturnsEleven() throws Exception {
		//Arrange
		int startNumber = 10;

		//Act
		int actual = newKata.getNextPalindrome(startNumber);

		//Assert
		int expected = 11;
		assertThat(actual, is(expected));
	}


	@Test
	public void testDefault() throws Exception {
		//Arrange
		int startNumber = 1329;

		//Act
		int actual = newKata.getNextPalindrome(startNumber);

		//Assert
		int expected = 1331;
		assertThat(actual, is(expected));
	}

	@Test
	public void testUpperLimit() throws Exception {
		//Arrange
		int startNumber = 999998;

		//Act
		int actual = newKata.getNextPalindrome(startNumber);

		//Assert
		int expected = 999999;
		assertThat(actual, is(expected));
	}

	@Test
	public void doesNotReturnOverOneMillion() throws Exception {
		//Arrange
		int startNumber = 1000000;

		//Assert
		thrown.expect(Exception.class);
		thrown.expectMessage("Number too large");

		//Act
		newKata.getNextPalindrome(startNumber);
	}

	@Test
	public void doesNotReturnOverOneMillion2() throws Exception {
		//Arrange
		int startNumber = 999999;

		//Assert
		thrown.expect(Exception.class);
		thrown.expectMessage("Number too large");

		//Act
		newKata.getNextPalindrome(startNumber);
	}

	@Test
	public void doesNotReceiveNegative() throws Exception  {
		//Arrange
		int startNumber = -1;

		//Assert
		thrown.expect(Exception.class);
		thrown.expectMessage("Number is negative");

		//Act
		newKata.getNextPalindrome(startNumber);
	}
}