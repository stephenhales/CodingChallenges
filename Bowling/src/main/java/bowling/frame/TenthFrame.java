package bowling.frame;


import lombok.Getter;
import lombok.Setter;

public class TenthFrame extends Frame {

	@Getter @Setter private Integer thirdRoll;

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

	public Integer getScore(){
		//spare
		if(this.getFirstRoll() + this.getSecondRoll() == 10 ){
			return 10 + this.getThirdRoll();
		}

		// normal score
		else{
			return this.getFirstRoll() + this.getSecondRoll();
		}
	}

	public boolean canRoll(){
		return (this.getFirstRoll() == null
			|| this.getSecondRoll() == null
			|| this.getThirdRoll() == null);
	}
}
