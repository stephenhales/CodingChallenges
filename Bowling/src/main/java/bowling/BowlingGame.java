package bowling;

import java.util.ArrayList;
import java.util.List;

import bowling.player.Player;

public class BowlingGame{

    private List<Player> players = new ArrayList<Player>();

    public void score(){
        for(Player player : players){
			player.score();
        }
    }

    public void addPlayer(){
	    players.add(new Player());
    }
}
