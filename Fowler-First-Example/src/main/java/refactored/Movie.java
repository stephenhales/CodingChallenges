package refactored;

public class Movie {

    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int priceCode) {
        _priceCode = priceCode;
    }

    public String getTitle() {
        return _title;
    }

    public double getCost(int daysRented){
        double cost = 0;
        switch (getPriceCode()) {
            case refactored.Movie.REGULAR:
                cost += 2;
                if (daysRented > 2)
                    cost += (daysRented - 2) * 1.5;
                return cost;
            case refactored.Movie.NEW_RELEASE:
                cost += daysRented * 3;
                return cost;
            case refactored.Movie.CHILDREN:
                cost += 1.5;
                if (daysRented > 3)
                    cost += (daysRented - 3) * 1.5;
                return cost;
            default:
                return 0;
        }
    }

	public int getRenterPoints(int daysRented){
		int frequentRenterPoints = 1;

		if ( isRentalQualifiedForBonus(daysRented)){
			frequentRenterPoints ++;
		}

		return frequentRenterPoints;
	}

	private Boolean isRentalQualifiedForBonus(int daysRented){
		return (getPriceCode() == Movie.NEW_RELEASE)
			&& daysRented >= 2;
	}
}