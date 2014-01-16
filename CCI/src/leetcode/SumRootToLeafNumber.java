package leetcode;

import java.util.ArrayList;

import leetcode.IsValidBST.TreeNode;

public class SumRootToLeafNumber {
	public int sumNumbers(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> comb = new ArrayList<Integer>();
        
        dfs(result, comb, root);
        int total = 0;
        for (int i = 0; i < result.size(); i++) {
            String s = new String("");
            for (int j = 0; j < result.get(i).size(); j++) {
                s += String.valueOf(result.get(i).get(j));
            }
            total += Integer.parseInt(s);
        }
        return total;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> comb, TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) { // leaf
            comb.add(node.val); // add the temporay node
            result.add(new ArrayList<Integer>(comb));
            comb.remove(comb.size()-1);
        } else if (node.left != null && node.right == null) {
            comb.add(node.val); // add the temporay node
            dfs(result, comb, node.left); // go to left child
            comb.remove(comb.size()-1);
        } else if (node.left == null && node.right != null) {
            comb.add(node.val); // add the temporay node
            dfs(result, comb, node.right); // go to right child
            comb.remove(comb.size()-1);
        } else {
            comb.add(node.val); // add the temporay node
            dfs(result, comb, node.left);
            comb.remove(comb.size()-1);
            comb.add(node.val); // add the temporay node
            dfs(result, comb, node.right);
            comb.remove(comb.size()-1);
        }
        return;
    }
    
    public static void main(String[] args) {
    	SumRootToLeafNumber s = new SumRootToLeafNumber();
    	TreeNode root = new TreeNode(2);
    	root.left = new TreeNode(1);
    	root.left.left = new TreeNode(4);
    	root.left.left.left = new TreeNode(7);
    	root.left.left.left.left = new TreeNode(4);
    	root.left.left.left.left.left = new TreeNode(8);
    	root.left.left.left.left.left.left = new TreeNode(3);
    	root.left.left.left.left.left.left.left = new TreeNode(6);
    	root.left.left.left.left.left.left.left.left = new TreeNode(4);
    	root.left.left.left.left.left.left.left.left.left = new TreeNode(7);
    	s.sumNumbers(root);
    }
}