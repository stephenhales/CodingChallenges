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
		if(canRoll()){
			return;
		}
		this.points = calculateScore(nextFirstRoll, nextSecondRoll);
	}

	public void printFrame(int total){
		System.out.println("________");
		System.out.printf("| %s | %s |\n", this.getFirstRoll(), this.getSecondRoll());
		System.out.println("|   ____|");
		System.out.printf("|   %s   |\n", total);
		System.out.println("|_______|");
	}

	private Integer calculateScore(Integer nextFirstRoll, Integer nextSecondRoll){
		//strike
		if(this.getFirstRoll() == 10){
			if(nextFirstRoll == null || nextSecondRoll == null) return null;
			return 10 + nextFirstRoll + nextSecondRoll;
		}

		//spare
		if(this.getFirstRoll() + this.getFirstRoll() == 10 ){
			if(nextFirstRoll == null) return null;
			return 10 + nextFirstRoll;
		}

		// normal score
		else {
			return this.getFirstRoll() + this.getSecondRoll();
		}
	}
}
