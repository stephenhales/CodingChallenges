package bowling.frame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Frame {

	public static final int notRolled = -1;
	public static final int notCalculated = -1;

	private int firstRoll;
	private int secondRoll;
	private int points;

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
}
