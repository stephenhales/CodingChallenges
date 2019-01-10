package bowling.frame;


public class TenthFrame extends Frame {
	private Integer firstRoll;
	private Integer secondRoll;
	private Integer thirdRoll;

	public int getFirstRoll(){
		return this.firstRoll;
	}

	public int getSecondRoll(){
		return this.secondRoll;
	}

	public Integer getThirdRoll() {
		return this.thirdRoll;
	}

	public void roll(int pinsKnockedDown){
		if(this.firstRoll == null){
			this.firstRoll = pinsKnockedDown;
		}
		else if (this.secondRoll == null) {
			this.secondRoll = pinsKnockedDown;
		}
		else {
			this.thirdRoll = pinsKnockedDown;
		}
	}

	public boolean canRoll(){
		return (this.firstRoll == null || this.secondRoll == null || this.thirdRoll == null);
	}
}
