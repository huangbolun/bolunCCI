package bit_manipulation;

import java.util.ArrayList;

/**
 * Solution to Problem 5.6: Swapping odd and even bits in an integer with as few instruction as possible
 * @author Bolun
 *
 */
public class SwapEvenOdd {
	
	public int mySolution(int num) {
		ArrayList<Integer> binaryRep = new ArrayList<Integer>();
		int remainder = 0;
		int val = num;
		while (val > 0) {
			remainder = val%2;
			val = val/2;
			binaryRep.add(remainder);
		}
		//System.out.println(binaryRep);
		for (int i = 0; i + 1 < binaryRep.size(); i = i + 2) {
			int tmp = binaryRep.get(i);
			binaryRep.set(i, binaryRep.get(i+1));
			binaryRep.set(i+1, tmp);
			//System.out.println(binaryRep);
		}
		
		val = 0;
		for (int i = 0; i < binaryRep.size(); i++) {
			val += binaryRep.get(i)*Math.pow(2, i);
		}
		return val;
	}
	
	/**
	 * bit shifting approaches
	 * right shift 1 bit == divided by 2; left shift 1 bit == multiply by 2
	 * @param args
	 */
	public int bitShifting(int num) {
		return ((num & 0xAAAAAAAA) >> 1) | ((num & 0x55555555) << 1);
	}
	
	public static void main(String[] args) {
		SwapEvenOdd seo = new SwapEvenOdd();
		System.out.println(seo.mySolution(8));
		System.out.println(seo.bitShifting(8));
	}
}