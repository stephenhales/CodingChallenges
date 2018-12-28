package refactored;

import java.util.Enumeration;
import java.util.Vector;

@SuppressWarnings("Duplicates")
public class Customer {

	private String _name;
	private Vector _rentals = new Vector();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public Vector getRentals(){ return _rentals; }

	public String statement() {

		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental rental = (Rental) rentals.nextElement();
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
