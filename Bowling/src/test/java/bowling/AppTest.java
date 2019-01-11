package bowling;

import org.junit.Test;

import bowling.frame.Frame;

import static org.junit.Assert.assertEquals;

public class AppTest {

    BowlingGame game = new BowlingGame();

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
}
