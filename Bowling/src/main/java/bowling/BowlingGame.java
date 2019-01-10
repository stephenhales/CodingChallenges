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
        for(int frameNumber = 1; frameNumber <= 9; frameNumber++){
            score += getFrameScore(frameNumber);
        }
        //10th frame
        score += getTenthFrameScore();

        return score;
    }

    public int getFrameScore(int frameNumber){
        Frame frame = getFrame(frameNumber);

        //spare
        if(frame.getFirstRoll() + frame.getFirstRoll() == 10 ){
            return 10 + getFrame(frameNumber+1).getFirstRoll();
        }

        // normal score
        else{
            return frame.getFirstRoll() + frame.getSecondRoll();
        }
    }

    public int getTenthFrameScore(){
        TenthFrame frame = getTenthFrame();

        //spare
        if(frame.getFirstRoll() + frame.getSecondRoll() == 10 ){
            return 10 + frame.getThirdRoll();
        }

        // normal score
        else{
            return frame.getFirstRoll() + frame.getSecondRoll();
        }
    }

    public Frame getFrame(int frameNumber){
        return frames[frameNumber-1];
    }

	public TenthFrame getTenthFrame(){
		return (TenthFrame) frames[9];
	}

    public void roll(int knockedDownPins){
	    if(frameNumber == 10){
		    if(getTenthFrame().canRoll()) {
			    getTenthFrame().roll(knockedDownPins);
		    }
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
}
