package recursion_and_DP;

/**
 * solution to CCI 9.1
 * running up stair case by step 1, 2, 3
 * how many possible ways to climb up a n step staircase
 */
public class RunningUpStairCase1 {

	public static int[] steps;
	
	/**
	 * 
	 * @param n
	 * @return ways to reach the top
	 */
	public int recursiveRun(int n) {
		
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 4;
		
		else
		{
			return recursiveRun(n-1) + recursiveRun(n-2) + recursiveRun(n-3);
		}
	}
	
	/**
	 * 
	 * @param n
	 * @return ways to reach the top
	 */
	public int dynamicProgrammingRun(int n) {
		steps = new int[n];
		
		steps[0] = 1;
		steps[1] = 2;
		steps[2] = 4;
		
		for (int i = 3; i < n; i++)
		{
			steps[i] = steps[i-1]+steps[i-2]+steps[i-3];
		}
		
		return steps[n];
	}
	
}