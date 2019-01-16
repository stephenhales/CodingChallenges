package bowling.frame;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Frame {
	private Integer firstRoll;
	private Integer secondRoll;
	@Setter(AccessLevel.NONE) private Integer points;

	public void roll(int pinsKnockedDown){
		if(this.getFirstRoll() == null){
			this.setFirstRoll(pinsKnockedDown);
		}
		else {
			this.setSecondRoll(pinsKnockedDown);
		}
	}

	public boolean canRoll(){
		return (this.getFirstRoll() == null
			|| this.getFirstRoll() != 10 && this.getSecondRoll() == null);
	}

	public void setPoints(Integer nextFirstRoll, Integer nextSecondRoll){
		if(canRoll())
			return;
		this.points = calculateScore(nextFirstRoll, nextSecondRoll);
	}

	public void printFrame(int total){
		System.out.println("________");
		System.out.printf("| %s | %s |\n", this.getFirstRoll(), this.getSecondRoll());
		System.out.println("|   ____|");
		System.out.printf("|   %s   |\n", total);
		System.out.println("|_______|");
	}

	public Integer calculateScore(Integer nextFirstRoll, Integer nextSecondRoll){
		//strike
		if(this.getFirstRoll() == 10)
			return strike(nextFirstRoll, nextSecondRoll);

		//spare
		if(this.getFirstRoll() + this.getFirstRoll() == 10 )
			return spare(nextFirstRoll);

		// normal score
		return this.getFirstRoll() + this.getSecondRoll();
	}

	private Integer strike(Integer nextFirstRoll, Integer nextSecondRoll){
		return(nextFirstRoll == null || nextSecondRoll == null) ? null : 10 + nextFirstRoll + nextSecondRoll;
	}

	private Integer spare(Integer nextFirstRoll){
		return (nextFirstRoll == null) ? null : 10 + nextFirstRoll;
	}

}
