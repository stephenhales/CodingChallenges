package bowling;

import java.util.ArrayList;
import java.util.List;

import bowling.player.Player;



//TODO The game class feels a little anemic to me.
//A game can be a container for all the moving pieces, in this case the Players and the Frames.
//It is strange to me that Frames don't believe to the game.
//Similarly, players should not need to know or care about the rules for scoring, the Game should keep track of that for them.
public class BowlingGame{

    private List<Player> players = new ArrayList<Player>();

    public void score(){
        for(Player player : players){
			player.score();
        }
    }

    //TODO do we ever add or remove players throughout a Game? Are the number of players determine at the start of the game?
    //What is a cleaner way to indicate that?
    public void addPlayer(){
	    players.add(new Player());
    }

    //TODO try adding a notion of Rounds, which consists of players taking their turn rolling until they fill a Frame.
    //What would a takeRound() method look like in the Game class?
    //What would a takeTurn() method look like in the Player class?
    //That would allow you to make the Game both the container and the driver for activity (as opposed to the player).
}
