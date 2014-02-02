package leetcode;

/**
 * only return the number of unique binary tree
 * @author Bolun
 *
 */
public class UniqueBinarySearchTree {

    public int numTrees(int n) {
        // from 1 to n e.g. 1,2,3,4
        return numTreesRecursive(1, n);
    }

    public int numTreesRecursive(int begin, int end) {
        if (begin > end) return 1;
        int total = 0;
        for (int i = begin; i <= end; i++) {
            int left = numTreesRecursive(begin, i-1);
            int right = numTreesRecursive(i+1, end);
            total += left * right; // add up as multiplication
        }
        return total;
    }
}