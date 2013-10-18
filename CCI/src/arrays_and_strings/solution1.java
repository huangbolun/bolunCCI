package arrays_and_strings;

/**
 * check if a string has duplicated characters
 * @author Bolun
 *
 */
public class solution1 {
	
	public boolean solver(String str1) {
		boolean[] check = new boolean[1000];
		for (int i = 0; i < str1.length(); i++)
		{
			int c = str1.charAt(i);
			if (check[c] == true)
			{
				return false;
			} else {
				check[c] = true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		solution1 mysolution = new solution1();
		System.out.println(mysolution.solver("1234567ydfghoiuytre567ibvb"));
		System.out.println(mysolution.solver("123456789poiuytrewkjhgfdszxcvbn,"));
	}
	
}