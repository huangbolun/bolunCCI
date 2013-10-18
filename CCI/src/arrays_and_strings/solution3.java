package arrays_and_strings;

import java.util.Arrays;

/**
 * to check whether the two string is a permutation
 * @author Bolun
 *
 */
public class solution3 {
	
	public boolean solver(String str1, String str2) {
		
		if (str1.length() != str2.length())
			return false;
		else {
			char[] c1 = str1.toCharArray();
			char[] c2 = str2.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			for (int i = 0; i < str1.length(); i++)
			{
				if (c1[i] != c2[i])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public String sortString(String str) {
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public boolean solver2(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		else {
			return sortString(str1).equals(sortString(str2));
		}
	}
	
	public static void main(String[] args) {
		String s1 = new String("1234567890");
		String s2 = new String("0987654321");
		solution3 mysolution = new solution3();
		System.out.println(mysolution.solver2(s1, s2));
	}
}