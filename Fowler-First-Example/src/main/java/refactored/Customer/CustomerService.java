package refactored.Customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import refactored.Rental;

@Service
public class CustomerService {


	public String statement(Customer customer) {
		List<String> statement = new ArrayList<>();
		List<Rental> rentals = customer.getRentals();

		statement.add( headerStatement(customer));
		statement.addAll(rentalStatements(rentals));
		statement.add(totalAmountStatement(getTotal(rentals)));
		statement.add(renterPointsStatement(getRenterPoints(rentals)));

		return String.join("\n", statement);
	}

	private List<String> rentalStatements(List<Rental> rentals){
		List<String> rentalStatement = new ArrayList<>();

		for(Rental rental: rentals) {
			rentalStatement.add( rentalStatement(rental.getMovie().getTitle(), rental.getCost()));
		}

		return rentalStatement;
	}

	private double getTotal(List<Rental> rentals){
		double totalAmount = 0;

		for(Rental rental: rentals) {
			totalAmount += rental.getCost();
		}

		return totalAmount;
	}

	private int getRenterPoints(List<Rental> rentals){
		int renterPoints = 0;

		for(Rental rental: rentals) {
			renterPoints += rental.getRenterPoints();
		}

		return renterPoints;
	}

	private String headerStatement(Customer customer){
		return "Rental record for " + customer.getName();
	}

	private String rentalStatement(String movieTitle, double movieCost){
		return "\t" + movieTitle + "\t" + String.valueOf(movieCost);
	}

	private String totalAmountStatement(double totalAmount){
		return "Amount owed is " + String.valueOf(totalAmount);
	}

	private String renterPointsStatement(int frequentRenterPoints){
		return "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
	}
}
