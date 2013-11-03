package others;

/**
 * Write a function to retrieve the number of a occurrences of a 
 * substring(even the reverse of a substring) in a string without 
 * using the java substring() method. 
 * Ex: 'dc' in 'abcd' occurs 2 times (dc, cd).
 * @author Bolun
 *
 */
public class SubString {
	
	public int occurenceSubString(String a, String b) {
		if (a == null || b == null) return 0; // error check: no occurance if null
		int oc = 0;
		
		String br = reverse(b); // reverse b
		
		for (int i = 0; i < a.length() - b.length(); i++)
		{
			
			if (b.charAt(0) != a.charAt(i) && br.charAt(0) != a.charAt(i)) continue;
			else {
				boolean check = true;
				for (int j = 0; j < b.length() && check == true; j++)
				{
					if (b.charAt(j) != a.charAt(i+j)) {
						check = false;
						break;
					}
				}
				
				for (int j = 0; j < br.length() && check == true; j++)
				{
					if (br.charAt(j) != a.charAt(i+j)) {
						check = false;
						break;
					}
				}
				
				if (check == true)
					oc += 2; // add by 2 since reverse and in order are the same
			}
		}
		return oc;
	}
	
	public String reverse(String a) {
		if (a == null) return null;
		StringBuilder b = new StringBuilder();
		for (int i = a.length() - 1; i > 0; i--)
		{
			b.append(a.charAt(i));
		}
		return b.toString();
	}
	
}