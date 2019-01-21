package bowling;

import org.junit.FixMethodOrder;
import org.junit.Test;

import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

//TODO ideally you want tests for each class in your project, that focuses only on the methods in that class.
//Currently you are using the game as the driving force of your project.

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BowlingGameTest {

	// https://www.bowlinggenius.com/
    private BowlingGame game = new BowlingGame();


	//TODO test name syntax
	//I am a big fan of methodName_should_expectedBehavior_whenCondition()
	//The method name serves to group your tests, but also highlights which class and method you are focused on testing.
	//Looking at this method, am I testing the roll method, the getFrames method, or the getPoints method?
    @Test
    public void bowlZeros(){
        for(int i = 0; i<20; i++){
            game.roll(0);
        }

	    int result = game.score();
        assertEquals(0, result);
    }

    @Test
    public void bowlOnes(){
        for(int i = 0; i<20; i++){
            game.roll(1);
        }

	    int result = game.score();
        assertEquals(20, result);
    }

    @Test
    public void bowlFours(){
        for(int i = 0; i<20; i++){
            game.roll(4);
        }

	    int result = game.score();
        assertEquals(80, result);
    }

    //TODO Folding baby
	//If you use Intellij, I am a big fan of using editor folds to keep my code clean
	// ctrl-alt-t for windows

	//<editor-fold desc="Spare Tests">
	@Test
    public void bowlOneSpare(){
        game.roll(5);
        game.roll(5);
        game.roll(3);
        for(int i = 0; i<17; i++){
            game.roll(0);
        }

		int result = game.score();
        assertEquals(16, result);
    }

	@Test
	public void bowlAllSpares(){

		for(int i = 0; i<10; i++){
			game.roll(5);
			game.roll(5);
		}
		game.roll(5);

		int result = game.score();
		assertEquals(150, result);
	}
    //</editor-fold>

	//<editor-fold desc="Strike Tests">
	@Test
	public void whenStrike_SecondRollIsNull(){

		game.roll(10);
		for(int i = 0; i<9; i++){
			game.roll(0);
			game.roll(0);
		}

		Integer result = game.getFrames()[0].getSecondRoll();
		assertEquals(null, result);
	}

    @Test
    public void whenStrike_NextFrameIsAdded(){

        game.roll(10);
        game.roll(2);
        game.roll(2);
        for(int i = 0; i<8; i++){
            game.roll(0);
            game.roll(0);
        }

	    int result = game.score();
        assertEquals(18, result);
    }

    @Test
    public void whenTwoStrikesAndTwoPins_FirstFrame_AccountsForNextNextRoll(){

        game.roll(10);
        game.roll(10);
        game.roll(2);
        game.roll(0);
        for(int i = 0; i<7; i++){
            game.roll(0);
            game.roll(0);
        }

	    int result = game.score();
        assertEquals(36, result);
    }

	@Test
	public void whenThreeStrikes_FirstFrame_AccountsForSecondStrike(){

		game.roll(10);
		game.roll(10);
		game.roll(10);
		for(int i = 0; i<7; i++){
			game.roll(0);
			game.roll(0);
		}
		int result = game.score();
		assertEquals(60, result);
	}
	//</editor-fold>

	@Test
	public void whenBowlOnes_FirstFrameScore_IsTwo(){

		game.roll(1);
		game.roll(1);

		Integer result = game.getFrames()[0].getPoints();
		assertEquals(new Integer(2), result);
	}

	@Test
	public void whenThreeStrikes_FirstFrame_IsThirty(){

		game.roll(10);
		game.roll(10);
		game.roll(10);

		Integer result = game.getFrames()[0].getPoints();
		assertEquals(new Integer(30), result);
	}

	@Test
	public void whenTwoStrikesAndTwoPins_FirstFrame_IsTwentyTwo(){

		game.roll(10);
		game.roll(10);
		game.roll(2);
		game.roll(0);

		Integer result = game.getFrames()[0].getPoints();
		assertEquals(new Integer(22), result);
	}

	@Test
	public void whenBowlFirstFrame_TotalScore_IsTwo(){

		game.roll(1);
		game.roll(1);

		int result = game.score();
		assertEquals(2, result);
	}

	@Test
	public void whenAllStrikes_ThreeHundred(){
		for(int i = 0; i<12; i++) {
			game.roll(10);
		}

		int result = game.score();
		assertEquals(300, result);
	}

	@Test
	public void whenAllStrikes_NinthFrame_IsThirty(){
		for(int i = 0; i<12; i++) {
			game.roll(10);
		}

		Integer result = game.getFrames()[8].getPoints();
		assertEquals(new Integer(30), result);
	}

	@Test
	public void whenAllZeros_TenthFrameIsOnes_IsTwo(){
		for(int i = 0; i<9; i++) {
			game.roll(0);
			game.roll(0);
		}
		game.roll(1);
		game.roll(1);

		int result = game.score();
		assertEquals(2, result);
	}

	@Test
	public void whenAllZeros_TenthFrameIsSpareAndFive_IsFifteen(){
		for(int i = 0; i<9; i++) {
			game.roll(0);
			game.roll(0);
		}
		game.roll(5);
		game.roll(5);
		game.roll(5);

    	int result = game.score();
		assertEquals(15, result);
	}

	@Test
	public void whenAllZeros_TenthFrameIsStrikes_IsThirty(){
		for(int i = 0; i<9; i++) {
			game.roll(0);
			game.roll(0);
		}
		game.roll(10);
		game.roll(10);
		game.roll(10);

		int result = game.score();
		assertEquals(30, result);
	}


	@Test
	public void whenAllZeros_TenthFrameIsStrikeAndSpare_IsTwenty(){
		for(int i = 0; i<9; i++) {
			game.roll(0);
			game.roll(0);
		}
		game.roll(10);
		game.roll(5);
		game.roll(5);


		int result = game.score();
		assertEquals(20, result);
	}

	@Test
	public void whenAllZeros_NinthFrameIsStrike_TenthFrameIsStrikes_IsSixty(){
		for(int i = 0; i<8; i++) {
			game.roll(0);
			game.roll(0);
		}
		//Ninth
		game.roll(10);
		//Tenth
		game.roll(10);
		game.roll(10);
		game.roll(10);


		int result = game.score();
		assertEquals(60, result);
	}
	
}
