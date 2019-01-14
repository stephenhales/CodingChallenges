package bowling.frame;

import lombok.Getter;
import lombok.Setter;

public class TenthFrame extends Frame {

	@Getter @Setter private Integer thirdRoll;
	@Getter private Integer points;


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

	public void setPoints(Integer nextFirstRoll, Integer nextSecondRoll){
		if(canRoll()){
			return;
		}
		this.points = calculateScore();
	}

	public boolean canRoll(){
		return (this.getFirstRoll() == null
			|| this.getSecondRoll() == null
			|| this.getThirdRoll() == null
				&& (this.getFirstRoll() + this.getSecondRoll() == 10
					|| this.getFirstRoll() == 10));
	}

	public void printFrame(int total){
		System.out.println("________");
		System.out.printf("| %s | %s | %s |\n", this.getFirstRoll(), this.getSecondRoll(), this.getThirdRoll());
		System.out.println("|   ________|");
		System.out.printf("|     %s     |\n", total);
		System.out.println("|___________|");
	}

	private Integer calculateScore(){
		//strike
		if(this.getFirstRoll() == 10){
			//two strikes
			if(this.getSecondRoll() == 10){
				return 10 + 10 *2 + this.getThirdRoll();
			}
			else{
				return 10 + this.getSecondRoll() + this.getThirdRoll();
			}
		}

		//spare
		if(this.getFirstRoll() + this.getSecondRoll() == 10 ){
			return 10 + this.getThirdRoll();
		}

		// normal score
		else{
			return this.getFirstRoll() + this.getSecondRoll();
		}
	}
}
