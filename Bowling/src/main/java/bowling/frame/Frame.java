package bowling.frame;

import bowling.common.Keys;
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

	private int firstRoll;
	private int secondRoll;
	@Setter(AccessLevel.NONE) private int points;

	public Frame(){
		this.setFirstRoll(Keys.notRolled);
		this.setSecondRoll(Keys.notRolled);
		this.points = Keys.notCalculated;
	}

	public void roll(int pinsKnockedDown){
		if(this.getFirstRoll() == Keys.notRolled){
			this.setFirstRoll(pinsKnockedDown);
		}
		else {
			this.setSecondRoll(pinsKnockedDown);
		}
	}

	public boolean canRoll(){
		return (this.getFirstRoll() == Keys.notRolled
			|| this.getFirstRoll() != 10 && this.getSecondRoll() == Keys.notRolled);
	}

	public void setPoints(int nextFirstRoll, int nextSecondRoll){
		if(canRoll())
			return;
		this.points = calculateScore(nextFirstRoll, nextSecondRoll);
	}

	public int calculateScore(int nextFirstRoll, int nextSecondRoll){

		//strike
		if(this.getFirstRoll() == 10) //TODO Express yourself. This line might read aloud "if roll is strike"
			return strike(nextFirstRoll, nextSecondRoll); //TODO this line might read aloud "then return strike for the two rolls". Does that sound right?

		//spare
		if(this.getFirstRoll() + this.getFirstRoll() == 10 )
			return spare(nextFirstRoll);

		// normal score
		return this.getFirstRoll() + this.getSecondRoll();
	}

	public void printFrame(int total){
		System.out.println("________");
		System.out.printf("| %s | %s |\n", this.getFirstRoll(), this.getSecondRoll());
		System.out.println("|   ____|");
		System.out.printf("|   %s   |\n", total);
		System.out.println("|_______|");
	}

	private int strike(int nextFirstRoll, int nextSecondRoll){
		return(nextFirstRoll == Keys.notRolled || nextSecondRoll == Keys.notRolled) ? Keys.notCalculated : 10 + nextFirstRoll + nextSecondRoll;
	}

	private int spare(int nextFirstRoll){
		return (nextFirstRoll == Keys.notRolled) ? Keys.notCalculated : 10 + nextFirstRoll;
	}

}
