package leetcode;

public class TrapWater {
    public int trap(int[] A) {
        // with water minus without water
    	int volumn = volumnwithwater(A);
        // volumn without water
    	int volumn2 = volumnwithoutwater(A);
    	return volumn-volumn2;
    }
    
    public int volumnwithwater(int[] A) {
        int[] Av = new int[A.length];
    	int volumn = 0;
        int lmax = 0;
        while (lmax < A.length) {
            int p = lmax;
            while (p < A.length && A[p] <= A[lmax])
                p += 1;
            if (p < A.length) {
                volumn += (p-lmax)*A[lmax];
                lmax = p; // update lmax
            } else { // reach the end, doesnt trap any water
                break;
            }
        }
        // lmax is now at the maximum of the bin
        //System.out.println(lmax);
        //System.out.println("l"+volumn);
        int b = A.length-1;
        while (b >= lmax) {
            int p = b;
            while (p >= lmax && A[p] <= A[b]) {
                p -= 1;
            }
            if (p >=lmax) {
                volumn += (b-p)*A[b];
                b = p;
            }
            if (p < lmax){
            	//System.out.println(b+"!"+p);
            	volumn += (b-p)*A[b];
                break;
            }
        }
        //System.out.println("r"+volumn);
        //volumn += A[lmax];
        return volumn;
    }
    
    public int volumnwithoutwater(int[] A) {
        int volumn2 = 0;
        for (int i = 0; i < A.length; i++) {
            volumn2 += A[i];
        }
        return volumn2;
    }
    
    public static void main(String[] args) {
    	TrapWater tw = new TrapWater();
    	int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
    	System.out.println(tw.volumnwithoutwater(A));
    	System.out.println(tw.volumnwithwater(A));
    	String s = new String("");
    	s = String.valueOf(10) + s;
    	System.out.println(s);
    	s = String.valueOf(8) + s;
    	System.out.println(s);
    	s = String.valueOf(111) + s;
    	System.out.println(s);
    	String ss = "a";
    	String[] sss = ss.split("\\*");
    	
    	System.out.println(sss[0]);
    	System.out.println(sss[1]);
    	
    }
    
}