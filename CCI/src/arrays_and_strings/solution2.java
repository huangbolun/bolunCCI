package arrays_and_strings;

/**
 * reverse a string in place
 * @author Bolun
 *
 */
public class solution2 {
	
	public char[] solver(char[] str) {
		char swap = '0';
		for (int i = 0; i < str.length/2; i++)
		{
			swap = str[str.length - 1 - i];
			str[str.length - 1 - i] = str[i];
			str[i] = swap;
		}
		return str;
	}
	
	public static void main(String[] args) {
		String test1 = "1234567890";
		solution2 mysolution = new solution2();
		System.out.println(mysolution.solver(test1.toCharArray()));
	}
}