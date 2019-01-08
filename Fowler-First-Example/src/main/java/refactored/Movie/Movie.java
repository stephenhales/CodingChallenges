package refactored.Movie;

public class Movie {

    private String _title;

    public Movie(String title) {
        _title = title;
    }

    public String getTitle() {
        return _title;
    }

    public double getCost(int daysRented){
        double cost = 2;
	    if (daysRented > 2)
		    cost += (daysRented - 2) * 1.5;
	    return cost;
    }

	public int getRenterPoints(int daysRented){
		return 1;
	}
}