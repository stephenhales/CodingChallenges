package bowling.frame;

import bowling.common.Score;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

//TODO What does this do?
//I like the idea of extracting out a class to contain the rolls. Feels cleaner than using a list, array, or map.
//Whenever you extract a class, you should strive for the Single-Responsibility Principle.
//What does this class do? Can you write it in a sentence?
//If you find yourself writing a paragraph, how could you break up the duties of this class into other classes?
//Sometimes it helps to group your fields and your methods; if you feel you can make distinct groups, consider extracting.
@Getter
@Setter
public class Frame {

	public static final int notRolled = -1;
	public static final int notCalculated = -1;

	private int firstRoll;
	private int secondRoll;
	@Setter(AccessLevel.NONE) private int points;

	public Frame(){
		this.setFirstRoll(notRolled);
		this.setSecondRoll(notRolled);
		this.points = notCalculated;
	}

	public void roll(int pinsKnockedDown){
		if(this.getFirstRoll() == notRolled){
			this.setFirstRoll(pinsKnockedDown);
		}
		else {
			this.setSecondRoll(pinsKnockedDown);
		}
	}

	//TODO next
	private boolean canRoll(){
		return (this.getFirstRoll() == notRolled
			|| this.getFirstRoll() != 10 && this.getSecondRoll() == notRolled);
	}

	public void setPoints(int nextFirstRoll, int nextSecondRoll){
		if(canRoll())
			return;
		this.points = Score.getFrameScore(this, nextFirstRoll, nextSecondRoll);
	}
}
