package bowling;

import java.util.ArrayList;
import java.util.List;

import bowling.common.Score;
import bowling.frame.Frame;


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

	private int currentRound = 1;
	private int noNextRoll = 0;


	private List<Frame> frames = new ArrayList<>();

	BowlingGame(){
		for(int round = 1; round <= 10; round++ ){
			frames.add(new Frame());
		}
	}

    //TODO try adding a notion of Rounds, which consists of players taking their turn rolling until they fill a Frame.
    //What would a takeRound() method look like in the Game class?
    //What would a takeTurn() method look like in the Player class?
    //That would allow you to make the Game both the container and the driver for activity (as opposed to the player).

	public int score(){
		display(frames);
		return Score.getTotalScore(frames);
	}

	public void roll(int knockedDownPins){
		getNextOpenFrame().roll(knockedDownPins);
		additionalFrameSetup();
		setFrameScores();
	}

	public List<Frame> getFrames(){
		return frames;
	}

	private Frame getNextOpenFrame(){
		return canPlayerRoll(getFrame(currentRound)) ?
			getFrame(currentRound) :
			getFrame(++currentRound);
	}

	private boolean canPlayerRoll(Frame frame){
		return hasNotRolled(frame.getFirstRoll())
			|| hasNotRolled(frame.getSecondRoll()) && !Score.isStrike(frame.getFirstRoll());
	}

	private boolean hasNotRolled(int roll){
		return roll == Frame.notRolled;
	}

	private Frame getFrame(int frameNumber){
		if(isInvalidFrameNumber(frameNumber)) return new Frame();
		return frames.get(frameNumber-1);
	}

	private Frame getNextFrame(int frameNumber){
		return getFrame(frameNumber + 1);
	}

	private void setFrameScores(){
		int frameNumber = currentRound;
		if( 10 < currentRound )
			frameNumber = 10;
		Frame frame = getFrame(frameNumber);

		while(frame.getPoints() == Frame.notCalculated){
			if(canPlayerRoll(frame))
				return;

			frame.setPoints(Score.getFrameScore(frame,
				getNextRoll(frameNumber),
				getNextNextRoll(frameNumber)));

			frame = getFrame(--frameNumber);
		}
	}

	private int getNextRoll(int currentFrame){
		if(isInvalidFrameNumber(currentFrame)) return noNextRoll;
		return getNextFrame(currentFrame).getFirstRoll();
	}

	private int getNextNextRoll(int currentFrame){
		if(isInvalidFrameNumber(currentFrame)) return noNextRoll;
		if(Score.isStrike(getNextRoll(currentFrame))){
			return getNextRoll(currentFrame + 1);
		}
		return getNextFrame(currentFrame).getSecondRoll();
	}

	private void additionalFrameSetup(){
		if(frameIsStrikeOrSpare(getFrame(10)) && frames.size() == 10){
			frames.add(new Frame());
		}
		if(tenthFrameHasTwoStrikes() && frames.size() == 11){
			frames.add(new Frame());
		}
		if(tenthFrameIsSpare()){
			getFrame(11).setSecondRoll(0);
		}
	}

	private boolean tenthFrameIsSpare(){
		return Score.isSpare(getFrame(10));
	}

	private boolean frameIsStrikeOrSpare(Frame frame){
		return Score.isStrike(frame.getFirstRoll()) || Score.isSpare(frame);
	}

	private boolean tenthFrameHasTwoStrikes(){
		return Score.isStrike(getFrame(10).getFirstRoll())
			&& Score.isStrike(getFrame(11).getFirstRoll());
	}

	private boolean isInvalidFrameNumber(int frameNumber){
		return !(0 < frameNumber && frameNumber <= frames.size());
	}

	private void display(List<Frame> frames){
		int score = 0;
		for(Frame frame : frames){
			score += (frame.getPoints() != Frame.notCalculated ? frame.getPoints() : 0 );
			printFrame(score, frame);
		}
	}

	private void printFrame(int total, Frame frame){
		System.out.println("________");
		System.out.printf("| %s | %s |\n", frame.getFirstRoll(), frame.getSecondRoll());
		System.out.println("|   ____|");
		System.out.printf("|   %s   |\n", total);
		System.out.println("|_______|");
	}

	private void printTenthFrame(int total, int[] rolls){
		System.out.println("________");
		System.out.printf("| %s | %s | %s |\n", rolls[0], rolls[1], rolls[2]);
		System.out.println("|   ________|");
		System.out.printf("|     %s     |\n", total);
		System.out.println("|___________|");
	}
}
