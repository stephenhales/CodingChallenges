package bowling;

import bowling.frame.Frame;
import bowling.frame.TenthFrame;


//A game can be a container for all the moving pieces, in this case the Players and the Frames.
//It is strange to me that Frames don't believe to the game.
//Similarly, players should not need to know or care about the rules for scoring, the Game should keep track of that for them.

//TODO Defensive programming
//It is important in java to make sure you program defensively, i.e. prevent bugs such as NullPointerException.
//Unfortunately, that can clutter your code and make things more difficult to read.
//Therefore, if possible, it is better to avoid writing null checks. If you see yourself doing it, ask yourself:
//1. Is null invalid in my design, or built into my domain? For example, is a null String distinct from an
//empty String because I need to determine whether the user intentionally gave me nothing or accidentally gave
//me nothing.
//Whenever possible design your system to treat null as invalid. For example, you could pass a specific String value
//such as -1 to indicate the user forgetting to provide a value.
//2. Can I guarantee that I have what I need when I get to this code? If possible, you should design your
//system (and get a working agreement with your team) such that if you ask for something as an input, you are
//guaranteed to have it provided. Instead of designing a method with two arguments, one of which is optional,
//instead write two methods (one with two arguments, and one with only the single required argument). This way
//callers never pass you a null. Similarly, identify the boundaries of your system (i.e. database layer or http layer),
//and only run validation at those locations (do null checks at the edges, so that your internal code doesn't have to; plus this allows you to fail fast, and provide feedback earlier).
public class BowlingGame{

	private final int noNextRoll = 0;
	private int currentFrameNumber = 1;
	private int notRolled = -1;

	private Frame[] frames = new Frame[]{
		new Frame(), new Frame(), new Frame(),
		new Frame(), new Frame(), new Frame(),
		new Frame(), new Frame(), new Frame(),
		new TenthFrame()
	};

	BowlingGame(){ }

    //TODO try adding a notion of Rounds, which consists of players taking their turn rolling until they fill a Frame.
    //What would a takeRound() method look like in the Game class?
    //What would a takeTurn() method look like in the Player class?
    //That would allow you to make the Game both the container and the driver for activity (as opposed to the player).

	public int score(){
		int score = 0;
		for(Frame frame : frames){
			score += (frame.getPoints() != null ? frame.getPoints() : 0 );
			frame.printFrame(score);
		}
		return score;
	}

	public void roll(int knockedDownPins){
		getNextOpenFrame().roll(knockedDownPins);
		setFrameScores();
	}

	public Frame[] getFrames(){
		return frames;
	}

	private Frame getNextOpenFrame(){
		return getFrame(currentFrameNumber).canRoll() ?
			getFrame(currentFrameNumber) :
			getFrame(++currentFrameNumber);
	}

	private Frame getFrame(int frameNumber){
		if(!isValidFrameNumber(frameNumber)) return new Frame();
		return frames[frameNumber-1];
	}

	private Frame getNextFrame(int frameNumber){
		return getFrame(frameNumber + 1);
	}

	private void setFrameScores(){
		int frameNumber = 1;
		for(Frame frame : frames){

			if(frame.getPoints() != null) {
				frameNumber++;
				continue;
			}

			frame.setPoints(
				getNextRoll(frameNumber),
				getNextNextRoll(frameNumber));

			if(frame.getPoints() == null)
				break;

			frameNumber++;
		}
	}

	private Integer getNextRoll(int frameNumber){
		if(isTenthFrame(frameNumber)) return noNextRoll;
		return getNextFrame(frameNumber).getFirstRoll();
	}

	private Integer getNextNextRoll(int frameNumber){
		Integer lastRoll = getNextRoll(frameNumber);

		if(isTenthFrame(frameNumber)) return noNextRoll;
		//TODO Magic numbers
		if(lastRoll != notRolled && lastRoll == 10 && frameNumber != 9){
			return getNextRoll(frameNumber + 1);
		}
		return getNextFrame(frameNumber).getSecondRoll();
	}

	private boolean isTenthFrame(int frameNumber){
		return frameNumber == 10;
	}

	private boolean isValidFrameNumber(int frameNumber){
		return frameNumber < 11;
	}
}
