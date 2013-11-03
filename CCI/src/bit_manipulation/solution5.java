package bit_manipulation;

/**
 * solution to CCI 5.5
 * determine the number of bits to convert two int
 * @author Bolun
 *
 */
public class solution5 {
	
	public int numBit(int a, int b) {
		int num = 0;
		
		for (int i = 0; i < 32; i++)
		{
			if (((a>>i) & 1) != ((b>>i) & 1))
				num += 1;
		}
		return num;
	}
	
	public static void main(String[] args) {
		solution5 mysolution = new solution5();
		System.out.println(mysolution.numBit(31, 14));
	}
	
}