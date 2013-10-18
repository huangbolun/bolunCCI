package arrays_and_strings;
/**
 * compress string
 * e.g. "ddddyyyywwwnniqq" should become "d4y4w3n2i1q2"
 * @author Bolun
 *
 */
public class solution5 {
	
	public String solver(String str) {
		StringBuilder sb = new StringBuilder();
		int p1 = 0; // pointer 1
		int p2 = 0; // pointer 2
		while (p1 < str.length())
		{
			char val = str.charAt(p1);
			int count = 0;
			while (p2 < str.length() && str.charAt(p2) == val) {
				count += 1;
				p2 += 1;
			}
			p1 = p2;
			sb.append(val);
			sb.append(count);
		}
		if (str.length() < sb.toString().length())
			return str;
		else
			return sb.toString();
	}
	
	public static void main(String[] args) {
		solution5 mysolution = new solution5();
		System.out.println("ddddyyyywwwnniqq");
		System.out.println(mysolution.solver("ddddyyyywwwnniqq"));
	}
	
}