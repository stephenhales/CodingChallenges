package refactored.Movie;

public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title);
	}

    public double getCost(int daysRented){
        return daysRented * 3;
    }

	public int getRenterPoints(int daysRented){
		int frequentRenterPoints = 1;

		if ( daysRented >= 2){
			frequentRenterPoints ++;
		}
		return frequentRenterPoints;
	}

}