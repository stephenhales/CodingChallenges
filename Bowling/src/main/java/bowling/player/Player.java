package bowling.player;


import bowling.frame.Frame;

//TODO add later after refactoring
public class Player {

	private Frame[] frames;
	private int score = 0;

	public Player(Frame[] frames){
		this.frames = frames;
	}

	public void roll(){

	}

	public int getScore(){
		return this.score;
	}
}
