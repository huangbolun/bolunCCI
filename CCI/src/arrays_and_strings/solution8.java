package arrays_and_strings;
/**
 * using isSubstring() once to determine whether s1 is a rotation of s2
 * @author Bolun
 *
 */
public class solution8 {
	
	/* my solution */
	public boolean solver(String s1, String s2) {
		
		int p1 = 0; // pointer of s1
		int p2 = 0; // pointer of s2
		StringBuilder sub = new StringBuilder();
		for (p1 = 0; p1 < s1.length(); p1++)
		{
			char v1 = s1.charAt(p1);
			char v2 = s2.charAt(p2);
			while (v1 != v2 && p2 < s2.length())
			{
				p2 += 1;
				v2 = s2.charAt(p2);
			}
			sub.append(v1);
		}
		if (isSubstring(sub.toString(), s2))
			return true;
		else
			return false;
	}
	
	/* reference solution */
	public boolean isRotate(String s1, String s2) {
		if (s1.length() == s2.length() && s1.length() > 0)
		{
			String s1s1 = s1 + s1;
			if (isSubstring(s1s1, s2))
				return true;
		}
		return false;
	}
	
	/* implement isSubstring to determine whether s2 is a substring of s1 */
	public boolean isSubstring(String s1, String s2) {
		int j = 0;
		int len = 0;
		for (int i = 0; i < s1.length(); i++)
		{
			if (s1.charAt(i) == s2.charAt(j))
			{
				j += 1;
				len += 1;
			} else {
				j = 0;
				len = 0;
			}
			if (len == s2.length())
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		solution8 mysolution = new solution8();
		System.out.println(mysolution.isSubstring("qwr12345678uyt", "3456"));
		System.out.println(mysolution.isRotate("1234567", "5671234"));
	}
	
}