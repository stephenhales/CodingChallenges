package order;

import java.util.ArrayList;
import java.util.List;

public class Order {
	public List<Integer> getStartingOrder(List<Integer> movesPerPerson){
		List<Integer> order = getEndingOrder(movesPerPerson.size());

		for(int rank = movesPerPerson.size(); rank >= 1; rank--){
			int index = order.indexOf(rank);
			order.remove(index);
			order.add(index - movesPerPerson.get(rank-1), rank);
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
