package bowling;

import bowling.frame.Frame;
import bowling.frame.TenthFrame;

public class BowlingGame{
    private Frame[] frames = new Frame[]{
        new Frame(), new Frame(), new Frame(), new Frame(), new Frame(),
        new Frame(), new Frame(), new Frame(), new Frame(),
        new TenthFrame()
    };
    private Boolean isFirstRoll = true;
    private int frameIndex = 0;

    public int score(){
        int score = 0;
        for(int frameNumber = 0; frameNumber < 10; frameNumber++){
            Frame frame = frames[frameNumber];

            //spare
            if(frame.getFirstRoll() + frame.getFirstRoll() == 10 ){
                score += frame.getFirstRoll() + frame.getSecondRoll();

                if(frameNumber < 9) {
	                score += frames[frameNumber + 1].getFirstRoll();
                }
                else{
                	TenthFrame tenth = (TenthFrame) frames[frameNumber];
	                score += tenth.getThirdRoll();
                }
            }

            // normal score
            else{
	            score += frame.getFirstRoll() + frame.getSecondRoll();
            }
        }
        //10th frame

        return score;
    }

    public void roll(int knockedDownPins){
        if(frameIndex == 10){
	        TenthFrame tenth = (TenthFrame) frames[frameIndex-1];
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
