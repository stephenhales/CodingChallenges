package bowling.player;


import bowling.common.Score;
import bowling.frame.Frame;

//TODO add later after refactoring
public class Player {

	private Frame[] frames;

	public Player(Frame[] frames){
		this.frames = frames;
	}

	public void setRoll(int frameNumber, int Roll){

	}

	public int getScore(){
		return Score.getTotalScore(frames);
	}
}
