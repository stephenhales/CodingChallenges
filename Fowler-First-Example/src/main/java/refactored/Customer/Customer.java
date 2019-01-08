package refactored.Customer;

import java.util.ArrayList;
import java.util.List;

import refactored.Rental;

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
}
