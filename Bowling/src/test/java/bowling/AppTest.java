package bowling;

import org.junit.Test;

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
}
