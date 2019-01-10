package bowling.frame;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Frame {
	private Integer firstRoll;
	private Integer secondRoll;

	public void roll(int pinsKnockedDown){
		if(this.getFirstRoll() == null){
			this.setFirstRoll(pinsKnockedDown);
		}
		else {
			this.setSecondRoll(pinsKnockedDown);
		}
	}

	public boolean canRoll(){
		return (this.getFirstRoll() == null || this.getSecondRoll() == null);
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
