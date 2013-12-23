package bit_manipulation;

class BitInsert {
	/**
	 * insert M int N starting at position j and ending at position i
	 * @param N
	 * @param M
	 * @param i
	 * @param j
	 * @return
	 */
	public int bitInsert(int N, int M, int i, int j) {
		return (M << i) | (N & ((~1 << i)^(~(~1 << (j+1))))); // 1111100 ^ 0011111 = 1100011
	}
}