package others;

/**
 * google interview: find the first number greater than given int
 * operate it in O(log n)
 * @author Bolun
 *
 */
public class FindGreaterNumber {
	
	public int findGreaterNumber(int[] array, int A) {
		
		int larger = Integer.MAX_VALUE;
		
		for (int i = 0; i < array.length; i++)
		{
			if (i >= A && i < larger)
				larger = i;
		}
		if (larger == Integer.MAX_VALUE)
			return -1; // A is larger than any number in array
		return larger;
		
	}
	
}