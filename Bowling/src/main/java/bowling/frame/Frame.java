package bowling.frame;

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
	@Setter(AccessLevel.NONE) private Integer points;

	private int notRolled = -1;

	public Frame(){
		this.setFirstRoll(notRolled);
		this.setSecondRoll(notRolled);
	}

	public void roll(int pinsKnockedDown){
		if(this.getFirstRoll() == notRolled){
			this.setFirstRoll(pinsKnockedDown);
		}
		else {
			this.setSecondRoll(pinsKnockedDown);
		}
	}

	public boolean canRoll(){
		return (this.getFirstRoll() == notRolled
			|| this.getFirstRoll() != 10 && this.getSecondRoll() == notRolled);
	}

	public void setPoints(Integer nextFirstRoll, Integer nextSecondRoll){
		if(canRoll())
			return;
		this.points = calculateScore(nextFirstRoll, nextSecondRoll);
	}

	public Integer calculateScore(Integer nextFirstRoll, Integer nextSecondRoll){

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

	private Integer strike(Integer nextFirstRoll, Integer nextSecondRoll){
		return(nextFirstRoll == notRolled || nextSecondRoll == notRolled) ? null : 10 + nextFirstRoll + nextSecondRoll;
	}

	private Integer spare(Integer nextFirstRoll){
		return (nextFirstRoll == notRolled) ? null : 10 + nextFirstRoll;
	}

}
