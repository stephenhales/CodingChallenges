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
	private int frameNumber = 1;

    public int score(){
        int score = 0;
        for(int frameIndex = 1; frameIndex <= 9; frameIndex++){
        	score += getFrame(frameIndex).getScore(getFrame(frameIndex + 1));
	        getFrame(frameIndex).printFrame(score);
        }
        //10th frame
        score += getTenthFrame().getScore();
	    getTenthFrame().printFrame(score);

        return score;
    }

    public void roll(int knockedDownPins){
	    if(frameNumber == 10 && getTenthFrame().canRoll()){
		    getTenthFrame().roll(knockedDownPins);
		    return;
	    }

    	if(getFrame(frameNumber).canRoll()) {
			getFrame(frameNumber).roll(knockedDownPins);
		}
		else {
			frameNumber++;
			getFrame(frameNumber).roll(knockedDownPins);
		}
    }

	private Frame getFrame(int frameNumber){
		return frames[frameNumber-1];
	}

	private TenthFrame getTenthFrame(){
		return (TenthFrame) frames[9];
	}
}
