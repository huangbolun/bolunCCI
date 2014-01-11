package leetcode;

import java.util.ArrayList;

import leetcode.IsValidBST.TreeNode;

public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> comb = new ArrayList<Integer>();
        pathSum_recursive(root, comb, result, sum);
        return result;
    }
    
    public void pathSum_recursive(TreeNode root, ArrayList<Integer> comb, ArrayList<ArrayList<Integer>> result, int target) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right == null) {
            comb.add(root.val);
            pathSum_recursive(root.left, comb, result, target);
            comb.remove(comb.size()-1);
        } else if (root.left == null && root.right != null) {
            comb.add(root.val);
            pathSum_recursive(root.right, comb, result, target);
            comb.remove(comb.size()-1);
        } else if (root.left != null && root.right != null) {
            comb.add(root.val);
            pathSum_recursive(root.left, comb, result, target);
            comb.remove(comb.size()-1);
            comb.add(root.val);
            pathSum_recursive(root.right, comb, result, target);
            comb.remove(comb.size()-1);
        } else if (root.left == null && root.right == null) { // leaf
            comb.add(root.val);
            if (isMatched(comb, target)) {
                result.add(new ArrayList<Integer>(comb));
            }
            comb.remove(comb.size()-1);
        }
        return;
    }
    /**
     * @deprecated it doesn't work when there is negative nodes
     * @param comb
     * @param target
     * @return
     */
    public boolean isLess(ArrayList<Integer> comb, int target) {
        int sum = 0;
        for (Integer e : comb) {
            sum += e;
        }
        if (sum < target) return true;
        return false;
    }
    
    public boolean isMatched(ArrayList<Integer> comb, int target) {
        int sum = 0;
        for (Integer e : comb) {
            sum += e;
        }
        if (sum == target) return true;
        return false;
    }
}