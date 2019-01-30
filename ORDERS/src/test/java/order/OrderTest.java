package order;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderTest {

	Order order = new Order();

	@Test
	public void getStartingOrder_returnsOne_whenGivenOne(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(1);
		assertThat(result, is(expectedResult));
	}

	@Test
	public void getStartingOrder_returnsOneTwo_whenGivenOneTwo(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0,0);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(1,2);
		assertThat(result, is(expectedResult));
	}

	@Test
	public void getStartingOrder_returnsTwoOne_whenGivenZeroOne(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0,1);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(2,1);
		assertThat(result, is(expectedResult));
	}

	@Test
	public void getStartingOrder_returnsThreeTwoOne_whenGivenZeroOneTwo(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0,1,2);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(3,2,1);
		assertThat(result, is(expectedResult));
	}

	@Test
	public void getStartingOrder_returnsTwoOneThree_whenGivenZeroOneZero(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0,1,0);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(2,1,3);
		assertThat(result, is(expectedResult));
	}

	@Test
	public void getStartingOrder_returnsThreeTwo_whenGivenZeroOneTwoZeroOne(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0,1,2,0,1);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(3,2,1,5,4);
		assertThat(result, is(expectedResult));
	}

	@Test
	public void getStartingOrder_returnsAllRightButOne_whenGivenZeroOneTwoZeroOne(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0,1,2,0,1);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(3,2,1,5,4);
		assertThat(result, is(expectedResult));
	}

	@Test
	public void getStartingOrder_returnsChangeInMiddle_whenGivenCorrectButFour(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0,0,0,1,0);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(1,2,4,3,5);
		assertThat(result, is(expectedResult));
	}

	@Test
	public void getStartingOrder_returnsChangeAtRight_whenGivenCorrectButFive(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0,0,0,0,1);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(1,2,3,5,4);
		assertThat(result, is(expectedResult));
	}

	@Test
	public void getStartingOrder_returnsChangeAtLeft_whenGivenCorrectButTwo(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0,1,0,0,0);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(2,1,3,4,5);
		assertThat(result, is(expectedResult));
	}

}
