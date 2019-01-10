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
    private Boolean isFirstRoll = true;
    private int frameIndex = 0;

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
        TenthFrame frame = (TenthFrame) frames[9];

        //spare
        if(frame.getFirstRoll() + frame.getFirstRoll() == 10 ){
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

    public void roll(int knockedDownPins){
        if(frameIndex == 10){
	        TenthFrame tenth = (TenthFrame) frames[9];
	        tenth.setThirdRoll(knockedDownPins);
        }
    	else if(isFirstRoll){
            frames[frameIndex].setFirstRoll(knockedDownPins);
            isFirstRoll = false;
        }
        else{
            frames[frameIndex].setSecondRoll(knockedDownPins);
            frameIndex ++;
            isFirstRoll = true;
        }
    }
}
