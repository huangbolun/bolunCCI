package arrays_and_strings;

public class Anagrams {
	
	public boolean fun(String str) {
		/* examine the parameter!!important!! */
		if (str == null) {
			return false;
		}
		/* only need to traversal HALF of the string !!important!! */
		for (int i = 0; i < str.length()/2; i++)
		{
			if (str.charAt(i) != str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	/*
	public static void main(String[] args) {
		String str = new String("qw2rewq");
		Anagrams a = new Anagrams();
		System.out.println(a.fun(str));
	}*/
	
}