package refactored;

public class Rental {

	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
	    _movie = movie;
	    _daysRented = daysRented;
	}

	public int getDaysRented() {
	    return _daysRented;
	}

	public Movie getMovie() {
	    return _movie;
    }

	public static double getCostForMovieRental(refactored.Rental rental){
		double cost = 0;
		switch (rental.getMovie().getPriceCode()) {
			case refactored.Movie.REGULAR:
				cost += 2;
				if (rental.getDaysRented() > 2)
					cost += (rental.getDaysRented() - 2) * 1.5;
				return cost;
			case refactored.Movie.NEW_RELEASE:
				cost += rental.getDaysRented() * 3;
				return cost;
			case refactored.Movie.CHILDREN:
				cost += 1.5;
				if (rental.getDaysRented() > 3)
					cost += (rental.getDaysRented() - 3) * 1.5;
				return cost;
			default:
				return 0;
		}
	}
}
