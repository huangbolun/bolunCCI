package others;

/**
 * Find the maximum sum of SubArray in an Array of Integer
 * Here there is two solution both with O(n) time.
 * The second is DP algorithm
 * @author Bolun
 */
import java.util.ArrayList;

public class MaximumSubArray {
	
	public int find_MaxSum(ArrayList<Integer> a) {
		int cumVal = 0; // cumulative sum
		int cumMax = 0; // cumulative max
		int recMax = 0; // recorded max
		for (int i = 0; i < a.size(); i++)
		{
			cumVal += a.get(i);
			if (cumVal < 0)
			{
				cumMax = a.get(i);
			} else {
				cumMax += a.get(i);
			}
			if (cumMax > recMax)
				recMax = cumMax;
		}
		return recMax;
	}
	
	/*
	 * optimized DP solution
	 * naive DP solution generates a matrix A[i, j] to record the sum starting from i to j
	 * optimized DP use a table to record the current max ending with i
	 * updates the table using the following rules:
	 * table[i] = num[i], if i = 0;
	 * table[i] = max(num[i], table[i - 1]+num[i])
	 */
	public int find_MaxSum_DP(ArrayList<Integer> a) {
		int[] recMax = new int[a.size()]; // auxiliary table to record the max sum upto i
		for (int i = 0; i < a.size(); i++) {
			if (i == 0)
				recMax[i] = a.get(i);
			else
				recMax[i] = Math.max(recMax[i-1], a.get(i));
		}
		
		int finalMax = Integer.MIN_VALUE;
		for (int i = 0; i < recMax.length; i++) {
			if (recMax[i] > finalMax)
				finalMax = recMax[i];
		}
		
		return finalMax;
	}
}