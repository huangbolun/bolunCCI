package bit_manipulation;

/**
 * this is a wrapper class that contains integer bit
 * manipulation helper function
 * @author Bolun
 *
 */
public class BitManipulation {
	
	/**
	 * get the ith bit of integer num
	 * @param num
	 * @param i
	 * @return true if ith bit is 1, false if 0
	 */
	public boolean getBit(int num, int i) {
		if (((num >> i) & 1) == 1)
			return true;
		return false;
	}
	
	/**
	 * set ith bit to 1 in integer num
	 * @param num
	 * @param i
	 * @return the new integer
	 */
	public int setBit(int num, int i) {
		return (num | (1 << i));
	}
	
	/**
	 * clear the ith bit to 0 in integer num
	 * @param num
	 * @param i
	 * @return the new integer
	 */
	public int clearBit(int num, int i) {
		return (num | (~(1 << i)));
	}
	
	/**
	 * clear the bits to 0 from MSB to i inclusively
	 * @param num
	 * @param i
	 * @return the new integer
	 */
	public int clearMSBtoi(int num, int i) {
		return (num & ((1 << i) - 1));
	}
	
	/**
	 * clear the bits to 0 from LSB to i inclusively
	 * @param num
	 * @param i
	 * @return the new integer
	 */
	public int clearLSBtoi(int num, int i) {
		return (num & ~((1 << (i + 1)) - 1));
	}
	
	/**
	 * update the ith bit of num to v
	 * @param num
	 * @param i
	 * @param v
	 * @return the new integer
	 */
	public int updateBit(int num, int i, int v) {
		if (v != 0 || v != 1)
			return -1;
		return (num & (~(1 << i))) | (v << i);
	}
}