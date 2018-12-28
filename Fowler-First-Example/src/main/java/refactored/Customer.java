package refactored;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Customer {

	private String _name;
	private List<Rental> _rentals = new ArrayList<>();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental rental) {
		_rentals.add(rental);
	}

	public String getName() {
		return _name;
	}

	public List<Rental> getRentals(){ return _rentals; }

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		List<String> statement = new ArrayList<>();

		statement.add( headerStatement());

		for(Rental rental: _rentals) {

			double movieCost = Rental.getCostForMovieRental(rental);
			frequentRenterPoints += Rental.getFrequentRenterPointsForRental(rental);

			statement.add( rentalStatement(rental.getMovie().getTitle(), movieCost));
			totalAmount += movieCost;
		}

		statement.add(amountOwedStatement(totalAmount));
		statement.add(frequentRenterPointsStatement(frequentRenterPoints));
		return String.join("\n", statement);
	}

	private String headerStatement(){
		return "Rental record for " + getName();
	}

	private String rentalStatement(String movieTitle, double movieCost){
		return "\t" + movieTitle + "\t" + String.valueOf(movieCost) + "\n";
	}

	private String amountOwedStatement(double totalAmount){
		return "Amount owed is " + String.valueOf(totalAmount);
	}

	private String frequentRenterPointsStatement(int frequentRenterPoints){
		return "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
	}
}
