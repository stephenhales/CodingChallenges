package testCountSubstring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import countSubstring.CountSubstring;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestCountSubstring {

	private CountSubstring countSubstring = new CountSubstring();

	@Test
	public void getCount_ShouldReturnZero_WhenGivenZero(){
		//Arrange
		String inputString = "0";

		//Act
		int count = countSubstring.getCount(inputString);

		//Assert
		assertThat(count, is(0));
	}

	@Test
	public void getCount_ShouldReturnOne_WhenGivenOne(){
		//Arrange
		String inputString = "1";

		//Act
		int count = countSubstring.getCount(inputString);

		//Assert
		assertThat(count, is(1));
	}

	@Test
	public void getCount_ShouldReturnThree_WhenGivenOneOne(){
		//Arrange
		String inputString = "11";

		//Act
		int count = countSubstring.getCount(inputString);

		//Assert
		assertThat(count, is(3));
	}

	@Test
	public void getCount_ShouldReturnThree_WhenGivenOneZeroOne(){
		//Arrange
		String inputString = "101";

		//Act
		int count = countSubstring.getCount(inputString);

		//Assert
		assertThat(count, is(3));
	}

	@Test
	public void getCount_ShouldReturnSix_WhenGivenOneOneOne(){
		//Arrange
		String inputString = "111";

		//Act
		int count = countSubstring.getCount(inputString);

		//Assert
		assertThat(count, is(6));
	}

	@Test
	public void getCount_ShouldReturnTen_WhenGivenOneOneOneOne(){
		//Arrange
		String inputString = "1111";

		//Act
		int count = countSubstring.getCount(inputString);

		//Assert
		assertThat(count, is(10));
	}
}
