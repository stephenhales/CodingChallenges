package bowling.player;


import bowling.frame.Frame;
import bowling.frame.TenthFrame;

public class Player {

	private Frame[] frames = new Frame[]{
		new Frame(), new Frame(), new Frame(),
		new Frame(), new Frame(), new Frame(),
		new Frame(), new Frame(), new Frame(),
		new TenthFrame()
	};

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
		if(frameNumber == 10) return 0;
		return getFrame(frameNumber + 1).getFirstRoll();
	}

	private Integer getNextNextRoll(int frameNumber){
		Integer lastRoll = getNextRoll(frameNumber);

		if(frameNumber == 10) return 0;
		if(lastRoll != null && lastRoll == 10 && frameNumber != 9){
			return getNextRoll(frameNumber + 1);
		}
		return getFrame(frameNumber + 1).getSecondRoll();
	}
}
