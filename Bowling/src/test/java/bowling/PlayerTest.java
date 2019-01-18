package bowling;

import org.junit.Test;

import bowling.frame.Frame;
import bowling.player.Player;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player = new Player();

    @Test
    public void bowlZeros(){
        for(int i = 0; i<20; i++){
            player.roll(0);
        }
        assertEquals(0, player.score());
    }

    @Test
    public void bowlOnes(){
        for(int i = 0; i<20; i++){
            player.roll(1);
        }
        assertEquals(20, player.score());
    }

    @Test
    public void bowlFours(){
        for(int i = 0; i<20; i++){
            player.roll(4);
        }
        assertEquals(80, player.score());
    }

    @Test
    public void bowlOneSpare(){
        player.roll(5);
        player.roll(5);
        player.roll(3);
        for(int i = 0; i<17; i++){
            player.roll(0);
        }
        assertEquals(16, player.score());
    }

    @Test
    public void bowlAllSpares(){

        for(int i = 0; i<10; i++){
            player.roll(5);
            player.roll(5);
        }
        player.roll(5);
        assertEquals(150, player.score());
    }

    @Test
    public void whenStrike_SecondRollIsNull(){

        player.roll(10);
        for(int i = 0; i<9; i++){
            player.roll(0);
            player.roll(0);
        }
        Frame[] frames = player.getFrames();
        assertEquals(null, frames[0].getSecondRoll());
    }

    @Test
    public void whenStrike_NextFrameIsAdded(){

        player.roll(10);
        player.roll(2);
        player.roll(2);
        for(int i = 0; i<8; i++){
            player.roll(0);
            player.roll(0);
        }
        assertEquals(18, player.score());
    }

    // https://www.bowlinggenius.com/

    @Test
    public void whenTwoStrikesAndTwoPins_FirstFrame_AccountsForNextNextRoll(){

        player.roll(10);
        player.roll(10);
        player.roll(2);
        player.roll(0);
        for(int i = 0; i<7; i++){
            player.roll(0);
            player.roll(0);
        }
        assertEquals(36, player.score());
    }

	@Test
	public void whenThreeStrikes_FirstFrame_AccountsForSecondStrike(){

		player.roll(10);
		player.roll(10);
		player.roll(10);
		for(int i = 0; i<7; i++){
			player.roll(0);
			player.roll(0);
		}
		assertEquals(60, player.score());
	}

	@Test
	public void whenBowlOnes_FirstFrameScore_IsTwo(){

		player.roll(1);
		player.roll(1);

		Frame[] frames = player.getFrames();
		assertEquals(new Integer(2), frames[0].getPoints());
	}

	@Test
	public void whenThreeStrikes_FirstFrame_IsThirty(){

		player.roll(10);
		player.roll(10);
		player.roll(10);

		Frame[] frames = player.getFrames();
		assertEquals(new Integer(30), frames[0].getPoints());
	}

	@Test
	public void whenTwoStrikesAndTwoPins_FirstFrame_IsTwentyTwo(){

		player.roll(10);
		player.roll(10);
		player.roll(2);
		player.roll(0);

		Frame[] frames = player.getFrames();
		assertEquals(new Integer(22), frames[0].getPoints());
	}

	@Test
	public void whenBowlFirstFrame_TotalScore_IsTwo(){

		player.roll(1);
		player.roll(1);

		assertEquals(2, player.score());
	}

	@Test
	public void whenAllStrikes_ThreeHundred(){
		for(int i = 0; i<12; i++) {
			player.roll(10);
		}
		assertEquals(300, player.score());
	}

	@Test
	public void whenAllStrikes_NinthFrame_IsThirty(){
		for(int i = 0; i<12; i++) {
			player.roll(10);
		}
		Frame[] frames = player.getFrames();
		assertEquals(new Integer(30), frames[8].getPoints());
	}

	@Test
	public void whenAllZeros_TenthFrameIsOnes_IsTwo(){
		for(int i = 0; i<9; i++) {
			player.roll(0);
			player.roll(0);
		}
		player.roll(1);
		player.roll(1);
		assertEquals(2, player.score());
	}

	@Test
	public void whenAllZeros_TenthFrameIsSpareAndFive_IsFifteen(){
		for(int i = 0; i<9; i++) {
			player.roll(0);
			player.roll(0);
		}
		player.roll(5);
		player.roll(5);
		player.roll(5);
		assertEquals(15, player.score());
	}

	@Test
	public void whenAllZeros_TenthFrameIsStrikes_IsThirty(){
		for(int i = 0; i<9; i++) {
			player.roll(0);
			player.roll(0);
		}
		player.roll(10);
		player.roll(10);
		player.roll(10);
		assertEquals(30, player.score());
	}


	@Test
	public void whenAllZeros_TenthFrameIsStrikeAndSpare_IsTwenty(){
		for(int i = 0; i<9; i++) {
			player.roll(0);
			player.roll(0);
		}
		player.roll(10);
		player.roll(5);
		player.roll(5);
		assertEquals(20, player.score());
	}

	@Test
	public void whenAllZeros_NinthFrameIsStrike_TenthFrameIsStrikes_IsSixty(){
		for(int i = 0; i<8; i++) {
			player.roll(0);
			player.roll(0);
		}
		//Ninth
		player.roll(10);
		//Tenth
		player.roll(10);
		player.roll(10);
		player.roll(10);
		assertEquals(60, player.score());
	}
	
}
