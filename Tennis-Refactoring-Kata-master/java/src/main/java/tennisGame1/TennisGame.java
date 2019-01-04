package tennisGame1;

import common.ITennisGame;

public class TennisGame implements ITennisGame {
    
    private TennisPlayer player1;
	private TennisPlayer player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new TennisPlayer(player1Name);
	    this.player2 = new TennisPlayer(player2Name);
	}

    public void wonPoint(String playerName) {
        if (playerName == player1.getName())
            player1.addPoint();
        else
            player2.addPoint();
    }

    public String getScore() {
        if (player1.getScore() == player2.getScore())
        {
            if(player1.getScore() > Score.THIRTY)
                return "Deuce";
            return Score.toString(player1.getScore()) + "-All";
        }
        if (player1.getScore() > Score.FORTY || player2.getScore() > Score.FORTY)
        {
            return advantageScoreToString();
        }
        return Score.toString(player1.getScore())
            + "-"
            + Score.toString(player2.getScore());
    }

    private String advantageScoreToString(){
        if(isWin())
	        return "Win for " + getWinningPlayer().getName();
        return "Advantage " + getWinningPlayer().getName();
    }

    private TennisPlayer getWinningPlayer(){
    	return player1.getScore() > player2.getScore() ? player1 : player2;
    }

    private Boolean isWin(){
	    return Math.abs(player1.getScore() - player2.getScore()) >= 2;
    }
}
