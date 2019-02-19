package EulerTree;

import java.util.Arrays;

/**
 * Created by stephenhales on 8/9/2017.
 */
public class Triangle {

	public static int[] createNewRowTotal(int[] triRow, int[] totals, int max) {
		int[] newRowTotal = new int[15];

		for( int i = 0 ; i < max; i++){
			int left = totals[i];
			int right = totals[i+1];
			int head = triRow[i];
			int maxValue = findMax( left, right);
			int newHead = head + maxValue;

			newRowTotal[i] = newHead;
		}
		return newRowTotal;
	}

	private static int findMax(int left, int right) {
		return left > right ? left : right;
	}

	public static int findMaxPath(int[][] tri) {
		//change each row from bottom
		int nextRow = tri.length - 1;

		int[] newRowTotal;
		newRowTotal = createNewRowTotal(tri[nextRow-1],tri[nextRow],14);

		for(; nextRow > 0  ; nextRow--) {
			newRowTotal = createNewRowTotal(tri[nextRow-1], newRowTotal, nextRow);
			System.out.println(Arrays.toString(newRowTotal));
		}

		return newRowTotal[0];
	}

}
