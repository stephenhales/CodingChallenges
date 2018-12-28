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
		String statement = "Rental record for " + getName() + "\n";
		for(Rental rental: _rentals) {

			double movieCost = Rental.getCostForMovieRental(rental);

			frequentRenterPoints += Rental.getFrequentRenterPointsForRental(rental);

			//show figures for this rental
			statement += "\t" + rental.getMovie().getTitle()+ "\t" + String.valueOf(movieCost) + "\n";
			totalAmount += movieCost;
		}
		//add footer lines
		statement += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		statement += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return statement;
	}
}
