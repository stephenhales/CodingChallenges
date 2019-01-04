package tennisGame1;

public class TennisPlayer {

	private String name;
	private int score;

	public TennisPlayer(String name){
		this.name = name;
		this.score = 0;
	}

	public String getName(){
		return this.name;
	}

	public int getScore(){
		return this.score;
	}

	public void addPoint(){
		this.score ++;
	}
}
