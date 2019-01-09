package bowling;

public class BowlingGame{
    private int[] rolls = new int[21];
    private int rollIndex = 0;

    public int score(){
        int score = 0;
        int roll = 0;
        for(int frame = 0; frame < 10; frame++){
            roll = frame*2;

            //spare
            if(rolls[roll] + rolls[roll+1] == 10 ){
                score += normalFrame(rolls[roll], rolls[roll+1]);
                score += rolls[roll+2];
            }

            // normal score
            else{
                score += normalFrame(rolls[roll], rolls[roll+1]);
            }
        }
        return score;
    }

    public void roll(int knockedDownPins){
         rolls[rollIndex] = knockedDownPins;
         rollIndex ++;
    }

    private int normalFrame(int first, int second){
        return first + second;
    }
}
