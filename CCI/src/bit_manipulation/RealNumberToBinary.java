package bit_manipulation;

public class RealNumberToBinary {
	
	/**
	 * Multiply the num by 2 iteratively to check whether it is larger than 1
	 * Update the num to be the decimal part and iteratively do the same thing
	 * @param num
	 * @return
	 */
	public String printRealNumberBinary(double num) {
		if (num > 1 || num < 0) {
			return "ERROR"; 
		}
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		double r = 0.0;
		while (num > 0) {
			// set a limit on length
			if (sb.length() > 32) {
				return "ERROR";
			}
			r = num*2;
			if (r >= 1) {
				sb.append("1");
				num = r - 1;
			} else {
				sb.append("0");
				num = r;
			}
		}
		//java.util.ArrayList<Integer> l = new java.util.ArrayList<Integer>();
		
		return sb.toString();
	}
	
}