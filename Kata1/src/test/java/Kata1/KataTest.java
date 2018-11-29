package Kata1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class KataTest {

	Kata newKata;

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		newKata = new Kata();
	}

	@Test
	public void zeroReturnsEmptyArray(){
		//Arrange
		List<Integer> testArray = Arrays.asList(0);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = new ArrayList<>();
		assertThat(actual, is(expected));
	}

	@Test
	public void oneReturnsEmptyArray(){
		//Arrange
		List<Integer> testArray = Arrays.asList(1);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = new ArrayList<>();
		assertThat(actual, is(expected));
	}

	@Test
	public void twoReturnsTwo(){
		//Arrange
		List<Integer> testArray = Arrays.asList(2);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = Arrays.asList(2);
		assertThat(actual, is(expected));
	}

	@Test
	public void threeReturnsThree(){
		//Arrange
		List<Integer> testArray = Arrays.asList(3);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = Arrays.asList(3);
		assertThat(actual, is(expected));
	}

	@Test
	public void fourReturnsEmpty(){
		//Arrange
		List<Integer> testArray = Arrays.asList(4);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = Arrays.asList();
		assertThat(actual, is(expected));
	}

	@Test
	public void fiveReturnsFive(){
		//Arrange
		List<Integer> testArray = Arrays.asList(5);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = Arrays.asList(5);
		assertThat(actual, is(expected));
	}

	@Test
	public void sixReturnsSix(){
		//Arrange
		List<Integer> testArray = Arrays.asList(6);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = Arrays.asList();
		assertThat(actual, is(expected));
	}

	@Test
	public void sevenReturnsSeven(){
		//Arrange
		List<Integer> testArray = Arrays.asList(7);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = Arrays.asList(7);
		assertThat(actual, is(expected));
	}
	@Test
	public void elevenReturnsEleven(){
		//Arrange
		List<Integer> testArray = Arrays.asList(11);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = Arrays.asList(11);
		assertThat(actual, is(expected));
	}

	@Test
	public void highIntReturnsPrime(){
		//Arrange
		List<Integer> testArray = Arrays.asList(113);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = Arrays.asList(113);
		assertThat(actual, is(expected));
	}

	@Test
	public void twoPrimes(){
		//Arrange
		List<Integer> testArray = Arrays.asList(3,5);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = Arrays.asList(3,5);
		assertThat(actual, is(expected));
	}

	@Test
	public void onePrimeOneNot(){
		//Arrange
		List<Integer> testArray = Arrays.asList(3,6);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = Arrays.asList(3);
		assertThat(actual, is(expected));
	}

	@Test
	public void twoNotPrime(){
		//Arrange
		List<Integer> testArray = Arrays.asList(6,8);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = Arrays.asList();
		assertThat(actual, is(expected));
	}

	@Test
	public void threePrimes(){
		//Arrange
		List<Integer> testArray = Arrays.asList(5,7,11);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = Arrays.asList(5,7,11);
		assertThat(actual, is(expected));
	}

	//Performance test
	@Test
	public void oneMillion(){
		//Arrange
		List<Integer> testArray = Arrays.asList(1000000);

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArray);

		//Assert
		List<Integer> expected = new ArrayList<>();
		assertThat(actual, is(expected));
	}

	//Performance test
	//@Test
	public void oneToOneMillion(){
		//Arrange
		List<Integer> testArrayMill = IntStream.rangeClosed(1, 1000000) //array of IntStream
			.boxed() //Stream<Integer>
			.collect(Collectors.toList()); //List<Integer

		//Act
		List<Integer> actual = newKata.getPrimeNumbers(testArrayMill);

		//Assert
		List<Integer> expected = new ArrayList<>();
		assertThat(actual, is(expected));
	}

}