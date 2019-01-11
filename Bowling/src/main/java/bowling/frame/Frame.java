package bowling.frame;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Frame {
	private Integer firstRoll;
	private Integer secondRoll;
	@Setter(AccessLevel.NONE) private Integer score;

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

	public void setScore(Frame nextFrame, Integer nextRoll){
		if(canRoll()){
			return;
		}
		this.score = calculateScore(nextFrame, nextRoll);
	}

	public void printFrame(int total){
		System.out.println("________");
		System.out.printf("| %s | %s |\n", this.getFirstRoll(), this.getSecondRoll());
		System.out.println("|   ____|");
		System.out.printf("|   %s   |\n", total);
		System.out.println("|_______|");
	}

	private Integer calculateScore(Frame nextFrame, Integer nextRoll){
		//strike
		if(this.getFirstRoll() == 10){
			if(nextFrame.canRoll()){
				return null;
			}
			if(nextFrame.getFirstRoll() == 10) {
				//two strikes in a row
				if (nextRoll == null) {
					return null;
				}
				return 10 + 10 + nextRoll;
			}
			return 10 + nextFrame.getFirstRoll() + nextFrame.getSecondRoll();
		}

		//spare
		if(this.getFirstRoll() + this.getFirstRoll() == 10 ){
			if(nextFrame.canRoll()){
				return null;
			}
			return 10 + nextFrame.getFirstRoll();
		}

		// normal score
		else {
			return this.getFirstRoll() + this.getSecondRoll();
		}
	}
}
