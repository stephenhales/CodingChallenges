package bowling;

import bowling.frame.Frame;
import bowling.frame.TenthFrame;

public class BowlingGame{

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

	private TenthFrame getTenthFrame(){
		return (TenthFrame) frames[9];
	}

	private void setFrameScores(){
    	int frameNumber = 1;
		for(Frame frame : frames){

			if(frame.canRoll())
				break;
			if(frame.getPoints() != null) {
				frameNumber++;
				continue;
			}

			if(frameNumber < 10) {
				frame.setPoints(
					getNextRoll(frameNumber),
					getNextNextRoll(frameNumber));
			}
			else{

				//10th frame
				getTenthFrame().setPoints();
			}

			frameNumber++;

			if(frame.getPoints() == null)
				break;
		}
	}

	private Integer getNextRoll(int frameNumber){
    	return getFrame(frameNumber + 1).getFirstRoll();
	}

	private Integer getNextNextRoll(int frameNumber){
		if(getNextRoll(frameNumber) != null && getNextRoll(frameNumber) == 10){
			return getNextRoll(frameNumber + 1);
		}
		else{
			return getFrame(frameNumber + 1).getSecondRoll();
		}
	}
}
