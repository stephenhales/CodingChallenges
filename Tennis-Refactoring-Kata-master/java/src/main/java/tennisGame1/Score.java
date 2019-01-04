package tennisGame1;

public final class Score {
	public static final int LOVE = 0;
	public static final int FIFTEEN = 1;
	public static final int THIRTY = 2;
	public static final int FORTY = 3;

	public static String toString(int score){
		switch(score)
		{
			case LOVE:
				return "Love";
			case FIFTEEN:
				return "Fifteen";
			case THIRTY:
				return "Thirty";
			case FORTY:
				return "Forty";
			default:
				return null;
		}
	}
}
