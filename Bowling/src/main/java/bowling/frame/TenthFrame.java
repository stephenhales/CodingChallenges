package bowling.frame;

import lombok.Getter;
import lombok.Setter;

public class TenthFrame extends Frame {

	@Getter @Setter private Integer thirdRoll;
	@Getter private Integer score;


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

	public void setScore(){
		if(canRoll()){
			return;
		}
		this.score = calculateScore();
	}

	public boolean canRoll(){
		return (this.getFirstRoll() == null
			|| this.getSecondRoll() == null
			|| this.getThirdRoll() == null
				&& (this.getFirstRoll() + this.getSecondRoll() == 10
					|| this.getFirstRoll() + this.getSecondRoll() == 10));
	}

	private Integer calculateScore(){
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
