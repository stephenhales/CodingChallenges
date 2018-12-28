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
		String result = "Rental record for " + getName() + "\n";
		for(Rental rental: _rentals) {
			//determine amounts for each line
			double movieCost = Rental.getCostForMovieRental(rental);
			// add frequent renter points
			frequentRenterPoints ++;

			// add bonus for a two day new release rental
			if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) frequentRenterPoints ++;
			//show figures for this rental
			result += "\t" + rental.getMovie().getTitle()+ "\t" + String.valueOf(movieCost) + "\n";
			totalAmount += movieCost;
		}
		//add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		return result;
	}
}
