package bowling.frame;

import bowling.common.Score;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

//TODO Think through inheritance vs composition.
//What are the similarities between Frame and TenthFrame?
//What are the differences?
//Should the Game care which type of Frame it is dealing with?
//Try adding a Frameable or Framed interface.
@Getter
@Setter
//TODO Lombok too good
//Consider using @Data. This gives getters, setters, toString, equals, and more!
public class TenthFrame extends Frame {

	//TODO Design flexibility
	//What would happen if I allowed this frame to suddenly have 8 rolls? How hard would it be to add?
	//Whenever you find yourself writing variables with redundant names, check if there is a clean refactor to a complex object.
	//For example:
	// private String billStreet;
	// private String billCity;
	// private String billZip;
	// private String shippingStreet;
	// private String shippingCity;
	// private String shippingZip;
	// Could be refactored to:
	// private Address billing;
	// private Address shipping;
	private int firstRoll;
	private int secondRoll;
	private int thirdRoll;
	@Setter(AccessLevel.NONE) private int points;

	public TenthFrame(){
		this.setFirstRoll(Frame.notRolled);
		this.setSecondRoll(Frame.notRolled);
		this.setThirdRoll(Frame.notRolled);
		this.points = Frame.notCalculated;
	}

	@Override
	public void roll(int pinsKnockedDown){
		if(this.getFirstRoll() == Frame.notRolled){
			this.setFirstRoll(pinsKnockedDown);
		}
		else if (this.getSecondRoll() == Frame.notRolled) {
			this.setSecondRoll(pinsKnockedDown);
		}
		else {
			this.setThirdRoll(pinsKnockedDown);
		}
	}

	@Override
	public void setPoints(int nextFirstRoll, int nextSecondRoll){
		if(canRoll())
			return;
		this.points = Score.getFrameScore(this, this.getSecondRoll(), this.getThirdRoll());
	}

	//TODO Defensive programming again
	//Check out the player class's comment on defensive programming.

	//TODO Series
	//The first set of statements could read "Does the series contain any values?"
	//That last statement could read "Does the series of rolls contain a 10"
	//What does the second to last statement read as?
	//Try writing these in an expressive way by extracting some methods.
	@Override
	public boolean canRoll(){
		return (this.getFirstRoll() == Frame.notRolled
			|| this.getSecondRoll() == Frame.notRolled
			|| this.getThirdRoll() == Frame.notRolled
				&& (this.getFirstRoll() + this.getSecondRoll() == 10
					|| this.getFirstRoll() == 10));
	}
}
