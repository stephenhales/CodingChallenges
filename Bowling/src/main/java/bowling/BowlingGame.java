package bowling;

import java.util.ArrayList;
import java.util.List;

import bowling.common.Score;
import bowling.frame.Frame;


//A game can be a container for all the moving pieces, in this case the Players and the Frames.
public class BowlingGame{

	private int currentRound = 1;
	private int noNextRoll = 0;


	private List<Frame> frames = new ArrayList<>();

	BowlingGame(){
		//A bowling game is ten frames
		for(int round = 1; round <= 10; round++ ){
			frames.add(new Frame());
		}
	}

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
		int frameNumber = getCurrentRound();
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

	private int getCurrentRound(){
		if( 10 < currentRound )
			return 10;
		return currentRound;
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
