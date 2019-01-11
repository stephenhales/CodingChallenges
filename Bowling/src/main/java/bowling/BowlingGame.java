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
        for(int frameIndex = 1; frameIndex <= 10; frameIndex++){
        	score += getFrame(frameIndex).getScore();
	        getFrame(frameIndex).printFrame(score);
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

	private Frame getFrame(int frameNumber){
    	return frames[frameNumber-1];
	}

	private Frame getNextOpenFrame(){
    	for(Frame frame : frames){
    		if(frame.canRoll())
    			return frame;
	    }
	    return new Frame();
	}

	private TenthFrame getTenthFrame(){
		return (TenthFrame) frames[9];
	}


	private void setFrameScores(){
		for(int frameIndex = 1; frameIndex <= 8; frameIndex++){
			Integer roll = getFrame(frameIndex + 2).getFirstRoll();
			getFrame(frameIndex).setScore(getFrame(frameIndex + 1), getFrame(frameIndex + 2).getFirstRoll());
		}
		//9th frame
		getFrame(9).setScore(getTenthFrame(), 0);

		//10th frame
		getTenthFrame().setScore();
	}
}
