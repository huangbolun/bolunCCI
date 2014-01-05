package leetcode;

import java.util.Stack;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] height) {
    	// using an Stack to keep track of left limit and right limit and store it
    	// in an array
    	int max = 0;
    	int[] leftlimit = new int[height.length];
    	Stack<Integer> limitindex = new Stack<Integer>();
    	for (int i = 0; i < height.length; i++) {
    		while (!limitindex.isEmpty()) {
    			if (height[limitindex.peek()] >= height[i]) {
    				limitindex.pop();
    			} else {
    				break; // break is required*!*
    			}
    		}
    		if (limitindex.isEmpty()) {
    			leftlimit[i] = -1;
    		} else {
    			leftlimit[i] = limitindex.peek();
    		}
    		limitindex.push(i);
    	}
    	while (!limitindex.isEmpty()) limitindex.pop();
    	
    	int[] rightlimit = new int[height.length];
    	for (int i = height.length - 1; i >= 0; i--) {
    		while (!limitindex.isEmpty()) {
    			if (height[limitindex.peek()] >= height[i]) {
    				limitindex.pop();
    			} else {
    				break; // break is required*!*
    			}
    		}
    		if (limitindex.isEmpty()) {
    			rightlimit[i] = height.length;
    		} else {
    			rightlimit[i] = limitindex.peek();
    		}
    		limitindex.push(i);
    	}
    	
    	for (int i = 0; i < leftlimit.length; i++) {
    		int area = (rightlimit[i] - leftlimit[i] - 1)*height[i];
    		if (area > max) {
    			max = area;
    		}
    	}
    	return max;
    }
	
	public int largestRectangleArea_2(int[] height) {
        // naive way: find the max area with the height of each bar
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int pre = i;
            int post = i;
            while (pre >= 0 && height[pre] >= height[i]) {
                pre--;
            }
            while (post < height.length && height[post] >= height[i]) {
                post++;
            }
            // width should be [post-(pre+1)]
            int area = (post-(pre+1))*height[i];
            if (area > max) {
                max = area;
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		LargestRectangleinHistogram l = new LargestRectangleinHistogram();
		int[] height = {2,1,5,6,2,3};
		System.out.println(l.largestRectangleArea(height));
	}
}