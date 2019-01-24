package bowling.player;


import java.util.List;

import bowling.common.Score;
import bowling.frame.Frame;

//TODO add later after refactoring
public class Player {

	private List<Frame> frames;

	public Player(List<Frame> frames){
		this.frames = frames;
	}

	public void setRoll(int frameNumber, int Roll){

	}

	public int getScore(){
		return Score.getTotalScore(frames);
	}
}
