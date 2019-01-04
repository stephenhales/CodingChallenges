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
            if(player1.getScore() > 2)
                return "Deuce";
            return scoreToString(player1.getScore()) + "-All";
        }
        if (player1.getScore() > 3 || player2.getScore() > 3)
        {
            return advantageScoreToString(player1.getScore(), player2.getScore());
        }
        return scoreToString(player1.getScore())
            + "-"
            + scoreToString(player2.getScore());
    }

    private String scoreToString(int score){
        switch(score)
        {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return null;
        }
    }

    private String advantageScoreToString(int _player1Score, int _player2Score){
        int minusResult = _player1Score - _player2Score;
        if (minusResult==1)
            return "Advantage player1";
        else if (minusResult ==-1)
            return "Advantage player2";
        else if (minusResult>=2)
            return "Win for player1";
        else
            return "Win for player2";
    }
}
