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
		List<String> statement = new ArrayList<>();
		List<Rental> rentals = getRentals();

		statement.add( headerStatement());
		statement.addAll(rentalStatements(rentals));
		statement.add(totalAmountStatement(getTotal(rentals)));
		statement.add(renterPointsStatement(getRenterPoints(rentals)));

		return String.join("\n", statement);
	}

	private List<String> rentalStatements(List<Rental> rentals){
		List<String> rentalStatement = new ArrayList<>();

		for(Rental rental: rentals) {
			double movieCost = Rental.getCostForMovieRental(rental);
			rentalStatement.add( rentalStatement(rental.getMovie().getTitle(), movieCost));
		}

		return rentalStatement;
	}

	private double getTotal(List<Rental> rentals){
		double totalAmount = 0;

		for(Rental rental: rentals) {
			totalAmount += Rental.getCostForMovieRental(rental);
		}

		return totalAmount;
	}

	private int getRenterPoints(List<Rental> rentals){
		int renterPoints = 0;

		for(Rental rental: rentals) {
			renterPoints += Rental.getRenterPoints(rental);
		}

		return renterPoints;
	}

	private String headerStatement(){
		return "Rental record for " + getName();
	}

	private String rentalStatement(String movieTitle, double movieCost){
		return "\t" + movieTitle + "\t" + String.valueOf(movieCost) + "\n";
	}

	private String totalAmountStatement(double totalAmount){
		return "Amount owed is " + String.valueOf(totalAmount);
	}

	private String renterPointsStatement(int frequentRenterPoints){
		return "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
	}
}
