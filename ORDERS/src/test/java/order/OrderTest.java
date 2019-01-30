package order;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderTest {

	Order order = new Order();

	@Test
	public void getStartingOrder_returnsOneWhenGivenOne(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(1);
		assertThat(result, is(expectedResult));
	}

	@Test
	public void getStartingOrder_returnsOneTwoWhenGivenOneTwo(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0,0);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(1,2);
		assertThat(result, is(expectedResult));
	}

	@Test
	public void getStartingOrder_returnsTwoOneWhenGivenZeroOne(){
		//Arrange
		List<Integer> movesPerPerson = Arrays.asList(0,1);

		//Act
		List<Integer> result = order.getStartingOrder(movesPerPerson);

		//Assert
		List<Integer> expectedResult = Arrays.asList(2,1);
		assertThat(result, is(expectedResult));
	}
}
