package microsoft;

public class fibonacci {
	
	public int[] fib;
	public int fibgen (int n) {
		fib = new int[n];
		return fibrec(n);
	}
	
	public int fibrec(int n) {
		if (n == 0) fib[n] = 0;
		if (n == 1) fib[n] = 1;
		if (fib[n] != 0) return fib[n];
		if (n >= 2)
			fib[n] = fibrec(n-1) + fibrec(n-2);
		return fib[n];
	}
	
}