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
        for(int frameIndex = 1; frameIndex <= 8; frameIndex++){
        	score += getFrame(frameIndex).getScore(getFrame(frameIndex + 1), getFrame(frameIndex + 2).getFirstRoll());
	        getFrame(frameIndex).printFrame(score);
        }
        //9th frame
	    score += getFrame(9).getScore(getTenthFrame(), 0);
	    getFrame(9).printFrame(score);

        //10th frame
        score += getTenthFrame().getScore();
	    getTenthFrame().printFrame(score);

        return score;
    }

    public void roll(int knockedDownPins){
	    getNextOpenFrame().roll(knockedDownPins);
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
}
