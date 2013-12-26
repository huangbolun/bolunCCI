package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        // similar to threeSum; keep track of the min_diff
        if (num.length < 3) {
            return Integer.MAX_VALUE;
        }
        int diff = Integer.MAX_VALUE;
        int result = 0;
        int[] r = new int[3];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int comp = target - num[i];
            int a = i+1;
            int b = num.length - 1;
            while (a < b) {
                if (num[a]+num[b] == comp) {
                    // the closest we can get
                    return num[i]+num[a]+num[b];
                }
                
                else if (num[a]+num[b] < comp) {
                    if (Math.abs(target-num[i]-num[a]-num[b]) < diff) {
                        diff = Math.abs(target-num[i]-num[a]-num[b]);
                        result = num[i]+num[a]+num[b];
                        r[0] = num[i];
                        r[1] = num[a];
                        r[2] = num[b];
                    }
                    a += 1;
                }
                else if (num[a]+num[b] > comp) {
                    if (Math.abs(target-num[i]-num[a]-num[b]) < diff) {
                        diff = Math.abs(target-num[i]-num[a]-num[b]);
                        result = num[i]+num[a]+num[b];
                        r[0] = num[i];
                        r[1] = num[a];
                        r[2] = num[b];
                    }
                    b -= 1;
                }
            }
        }
        for (int i = 0; i < r.length; i++) {
        	System.out.print(r[i]+" ");
        }
        return result;
    }
    
    public static void main(String[] args) {
    	ThreeSumClosest ts = new ThreeSumClosest();
    	int[] num = {-1,-5,-3,-4,2,-2};
    	System.out.println(ts.threeSumClosest(num, 0));
    }
    
}