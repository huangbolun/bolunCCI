package leetcode;

public class Pow {
    public double pow(double x, int n) {
        // we can divide and recursively calculate x*x which is pow(x, 2)
        if (n == 0) return 1;
        if (n < 0) {
            return 1.0/pow2(x, -n);
        } else {
            return pow2(x, n);
        }
    }
    
    public double pow2(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double mul = pow2(x, n/2);
        if (n%2 == 1) // odd
            return x*mul*mul;
        else // even
            return mul*mul;
    }
}