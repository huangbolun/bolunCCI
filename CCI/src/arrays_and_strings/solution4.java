package arrays_and_strings;

/**
 * replace space in a string in place
 * @author Bolun
 *
 */
public class solution4 {
	
	public char[] solver(char[] str) {
		
		int count = 0, newLength;
		for (int i = 0; i < str.length; i++)
		{
			if (str[i] == ' ')
			{
				count++;
			}
		}
		newLength = str.length + count * 2;
		char[] str2 = new char[newLength];
		str2[newLength - 1] = '\0';
		int index = 0;
		for (int i = 0; i < str.length; i++)
		{
			if (str[i] == ' ')
			{
				str2[index] = '%';
				str2[index + 1] = '2';
				str2[index + 2] = '0';
				index += 3;
			} else {
				str2[index] = str[i];
				index += 1;
			}
		}
		return str2;
	}
	
	public static void main(String[] str) {
		String s = new String("qwnn 23trw 76sfet      ");
		solution4 mysolution = new solution4();
		System.out.println(mysolution.solver(s.toCharArray()));
	}
}