package bowling;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;

import bowling.frame.Frame;
import bowling.player.Player;

import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

//TODO ideally you want tests for each class in your project, that focuses only on the methods in that class.
//Currently you are using the game as the driving force of your project.

//TODO Fancy
//Whenever I get a good deal of tests, I like to add this to the class.
//It will run the tests in the order specified (in this case, alpha order ascending).
//Junit defaults to randomly running your tests, to ensure you don't build dependencies across tests (a no-no)
//But the main advantage is that it puts your test results window in alpha-ordering.
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BowlingGameTest {

    BowlingGame game = new BowlingGame(); //TODO can be private.

    @Test
    public void bowlZeros(){
        for(int i = 0; i<20; i++){
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    public void bowlOnes(){
        for(int i = 0; i<20; i++){
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    @Test
    public void bowlFours(){
        for(int i = 0; i<20; i++){
            game.roll(4);
        }
        assertEquals(80, game.score());
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
        assertEquals(16, game.score());
    }

	@Test
	public void bowlAllSpares(){

		for(int i = 0; i<10; i++){
			game.roll(5);
			game.roll(5);
		}
		game.roll(5);
		assertEquals(150, game.score());
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
		Frame[] frames = game.getFrames();
		assertEquals(null, frames[0].getSecondRoll());
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
        assertEquals(18, game.score());
    }

    // https://www.bowlinggenius.com/

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
        assertEquals(36, game.score());
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
		assertEquals(60, game.score());
	}
	//</editor-fold>

	//TODO test name syntax
	//I am a big fan of methodName_should_expectedBehavior_whenCondition()
	//The method name serves to group your tests, but also highlights which class and method you are focused on testing.
	//Looking at this method, am I testing the roll method, the getFrames method, or the getPoints method?
	@Test
	public void whenBowlOnes_FirstFrameScore_IsTwo(){

		game.roll(1);
		game.roll(1);

		Frame[] frames = game.getFrames();
		assertEquals(new Integer(2), frames[0].getPoints());
	}

	@Test
	public void whenThreeStrikes_FirstFrame_IsThirty(){

		game.roll(10);
		game.roll(10);
		game.roll(10);

		Frame[] frames = game.getFrames();
		assertEquals(new Integer(30), frames[0].getPoints());
	}

	@Test
	public void whenTwoStrikesAndTwoPins_FirstFrame_IsTwentyTwo(){

		game.roll(10);
		game.roll(10);
		game.roll(2);
		game.roll(0);

		Frame[] frames = game.getFrames();
		assertEquals(new Integer(22), frames[0].getPoints());
	}

	@Test
	public void whenBowlFirstFrame_TotalScore_IsTwo(){

		game.roll(1);
		game.roll(1);

		assertEquals(2, game.score());
	}

	@Test
	public void whenAllStrikes_ThreeHundred(){
		for(int i = 0; i<12; i++) {
			game.roll(10);
		}
		assertEquals(300, game.score());
	}

	@Test
	public void whenAllStrikes_NinthFrame_IsThirty(){
		for(int i = 0; i<12; i++) {
			game.roll(10);
		}
		Frame[] frames = game.getFrames();
		assertEquals(new Integer(30), frames[8].getPoints());
	}

	@Test
	public void whenAllZeros_TenthFrameIsOnes_IsTwo(){
		for(int i = 0; i<9; i++) {
			game.roll(0);
			game.roll(0);
		}
		game.roll(1);
		game.roll(1);
		assertEquals(2, game.score());
	}

	//TODO Triple A
	//You can add a lot of clarity to tests by following the AAA rule.
	//This will help focus you while writing tests, and applies a clear standard that makes it easier for your readers
	//to digest your tests.
	@Test
	public void whenAllZeros_TenthFrameIsSpareAndFive_IsFifteen(){
    	arrangeSpareInLastFrame();
    	int result = game.score(); //act. Sometimes having the invocation of the method/class under test (mut/cut) in its own line makes it easier to read. But you could inline it with the assert.
		assertEquals(15, result);//assert
	}

	private void arrangeSpareInLastFrame(){ //I sometimes like to use "setup" instead of arrange.
		for(int i = 0; i<9; i++) {
			game.roll(0);
			game.roll(0);
		}
		game.roll(5);
		game.roll(5);
		game.roll(5);
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
		assertEquals(30, game.score());
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
		assertEquals(20, game.score());
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
		assertEquals(60, game.score());
	}
	
}
