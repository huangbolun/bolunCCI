package leetcode;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        // put each number in the **position it is supposed to be**
        // for example, 3 is supposed to be in A[2]
        for (int i = 0; i < A.length; i++) {
            while (A[i] != i+1) {
                if (A[i] <= 0) break; // we dont need to process 0 or negative
                if (A[i] > A.length) break;
                if (A[i] == A[A[i]-1]) break;
                int tmp = A[i];
                A[i] = A[tmp-1];
                A[tmp-1] = tmp;
            }
        }
        int i = 0;
        while (i < A.length) {
            if (A[i] != i+1) break;
            i++;
        }
        return i+1;
    }
    
    public static void main(String[] args) {
    	FirstMissingPositive f = new FirstMissingPositive();
    	int[] A = {-5,1000};
    	f.firstMissingPositive(A);
    }
}