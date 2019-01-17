package bowling.frame;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenthFrame extends Frame {
	private Integer firstRoll;
	private Integer secondRoll;
	private Integer thirdRoll;
	@Setter(AccessLevel.NONE) private Integer points;

	@Override
	public void roll(int pinsKnockedDown){
		if(this.getFirstRoll() == null){
			this.setFirstRoll(pinsKnockedDown);
		}
		else if (this.getSecondRoll() == null) {
			this.setSecondRoll(pinsKnockedDown);
		}
		else {
			this.setThirdRoll(pinsKnockedDown);
		}
	}

	@Override
	public void setPoints(Integer nextFirstRoll, Integer nextSecondRoll){
		if(canRoll())
			return;
		this.points = super.calculateScore(this.getSecondRoll(), this.getThirdRoll());
	}

	@Override
	public boolean canRoll(){
		return (this.getFirstRoll() == null
			|| this.getSecondRoll() == null
			|| this.getThirdRoll() == null
				&& (this.getFirstRoll() + this.getSecondRoll() == 10
					|| this.getFirstRoll() == 10));
	}

	@Override
	public void printFrame(int total){
		System.out.println("________");
		System.out.printf("| %s | %s | %s |\n", this.getFirstRoll(), this.getSecondRoll(), this.getThirdRoll());
		System.out.println("|   ________|");
		System.out.printf("|     %s     |\n", total);
		System.out.println("|___________|");
	}
}
