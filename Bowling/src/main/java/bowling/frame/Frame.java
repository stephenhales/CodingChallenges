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

	public int getScore(Frame nextFrame){
		//spare
		if(this.getFirstRoll() + this.getFirstRoll() == 10 ){
			return 10 + nextFrame.getFirstRoll();
		}

		// normal score
		else{
			return this.getFirstRoll() + this.getSecondRoll();
		}
	}

	public void printFrame(int total){
		System.out.println("________");
		System.out.printf("| %s | %s |\n", this.getFirstRoll(), this.getSecondRoll());
		System.out.println("|   ____|");
		System.out.printf("|   %s   |\n", total);
		System.out.println("|_______|");
	}
}
