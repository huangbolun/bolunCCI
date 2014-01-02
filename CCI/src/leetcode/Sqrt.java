package leetcode;

public class Sqrt {
	/**
	 * Newton Method: http://blog.csdn.net/ithomer/article/details/8777088
	 * @param x
	 * @return
	 */
    public int sqrt(int x) {
        if (x < 0) return -1;
        double n = x;
        while (Math.abs(n*n-x) > 0.0001) {
            n = (n+x/n)/2;
        }
        return (int)n;
    }
    /**
     * divide
     * @param x
     * @return
     */
    public int sqrt_b(int x) {
    	int left = 0;
    	int right = x;
    	while (true) {
    		long mid = (long)(left+right)/2;
    		if (mid*mid == x || (mid*mid < x && (mid+1)*(mid+1) > x)) {
    			return (int)mid;
    		} else if (mid*mid < x) {
    			right = (int)mid;
    		} else {
    			left = (int)mid+1;
    		}
    	}
    }
}