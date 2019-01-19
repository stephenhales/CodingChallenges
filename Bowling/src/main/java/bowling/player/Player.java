package bowling.player;


import bowling.frame.Frame;
import bowling.frame.TenthFrame;

public class Player {

	//TODO Misplaced responsibility.
	//The player doesn't need to know how many Frames exist in a Game, only the Game knows that.
	//The player probably only cares about one Frame at a time (because they keep rolling until the Frame is full).
	private Frame[] frames = new Frame[]{
		new Frame(), new Frame(), new Frame(),
		new Frame(), new Frame(), new Frame(),
		new Frame(), new Frame(), new Frame(),
		new TenthFrame()
	};

	//TODO Misplaced responsibility
	//Players don't want to think about the complexity of scoring. Especially as we add more complicated rules!
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

	//TODO Bookmark
	//The Game should know all the Frames that will exist, and more importantly, which Frame we are currently in.
	//We don't want to have to run through every Frame to remember which one we are currently in.
	private Frame getNextOpenFrame(){
		for(Frame frame : frames){
			if(frame.canRoll())
				return frame;
		}
		return new Frame();
	}

	private Frame getFrame(int frameNumber){
		return frames[frameNumber-1];
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
		//TODO Magic numbers.
		//What is the significance of 10, 0, and 1?
		//Are these pins knocked down, points, or something else?
		if(frameNumber == 10) return 0;
		return getFrame(frameNumber + 1).getFirstRoll();
	}

	private Integer getNextNextRoll(int frameNumber){
		Integer lastRoll = getNextRoll(frameNumber);
		//TODO Magic numbers
		//Are these the same conceptual objects as the numbers above? Is this 10 the same as that 10?
		//Or is one 10 apples and the other 10 oranges?
		//How much code do I have to read to find that out?
		if(frameNumber == 10) return 0;
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
		if(lastRoll != null && lastRoll == 10 && frameNumber != 9){
			return getNextRoll(frameNumber + 1);
		}
		return getFrame(frameNumber + 1).getSecondRoll();
	}
}
