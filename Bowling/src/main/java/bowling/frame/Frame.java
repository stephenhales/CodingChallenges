package bowling.frame;


public class Frame {
	private Integer firstRoll;
	private Integer secondRoll;

	public int getFirstRoll(){
		return this.firstRoll;
	}

	public int getSecondRoll(){
		return this.secondRoll;
	}

	public void roll(int pinsKnockedDown){
		if(firstRoll == null){
			this.firstRoll = pinsKnockedDown;
		}
		else {
			this.secondRoll = pinsKnockedDown;
		}
	}

	public boolean canRoll(){
		return (this.firstRoll == null || this.secondRoll == null);
	}
}
