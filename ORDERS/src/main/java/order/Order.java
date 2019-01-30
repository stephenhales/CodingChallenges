package order;

import java.util.ArrayList;
import java.util.List;

public class Order {
	public List<Integer> getStartingOrder(List<Integer> movesPerPerson){
		List<Integer> order = getEndingOrder(movesPerPerson.size());

		for(int position = movesPerPerson.size()-1; position >= 0; position--){
			int moves = movesPerPerson.get(position);
			int index = position-moves;
			int rank = order.get(index);

			order.remove(index);
			order.add(position, rank);
		}
		return order;
	}

	private List<Integer> getEndingOrder(int size){
		List<Integer> endingOrder = new ArrayList<Integer>();
		int rank = 1;
		for(int i = 0; i < size; i++){
			endingOrder.add(rank++);
		}
		return endingOrder;
	}
}
