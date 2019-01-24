package bowling.common;

import java.util.List;

import bowling.frame.Frame;

public class Score {

	public static int getFrameScore(Frame frame, int nextFirstRoll, int nextSecondRoll){

		if(isStrike(frame.getFirstRoll()))
			return addNextTwoRolls(nextFirstRoll, nextSecondRoll);

		if(isSpare(frame))
			return addNextRoll(nextFirstRoll);

		return frame.getFirstRoll() + frame.getSecondRoll();
	}

	public static int getTotalScore(List<Frame> frames){
		int score = 0;
		for(Frame frame : frames){
			score += (frame.getPoints() != Frame.notCalculated ? frame.getPoints() : 0 );
		}
		return score;
	}

	public static int addNextTwoRolls(int nextFirstRoll, int nextSecondRoll){
		return(nextFirstRoll == Frame.notRolled || nextSecondRoll == Frame.notRolled) ? Frame.notCalculated : 10 + nextFirstRoll + nextSecondRoll;
	}

	public static int addNextRoll(int nextFirstRoll){
		return (nextFirstRoll == Frame.notRolled) ? Frame.notCalculated : 10 + nextFirstRoll;
	}

	public static boolean isStrike(int firstRoll){
		return firstRoll == 10;
	}

	public static boolean isSpare(Frame frame){
		return frame.getFirstRoll() + frame.getFirstRoll() == 10;
	}
}
