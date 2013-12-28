package leetcode;

import java.util.ArrayList;

public class IsValidBST {
	
	//Definition for binary tree
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}

	/**
	 * recursive method with MIN-MAX
	 * @param root
	 * @return
	 */
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean checkBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        
        if (root.val < min || root.val > max) {
            return false;
        }
        
        if (!checkBST(root.left, min, root.val) || !checkBST(root.right, root.val, max)) {
            return false;
        }
        return true;
    }
    /**
     * using in order traversal
     * @param root
     * @return
     */
    public boolean isValidBST_2(TreeNode root) {
    	ArrayList<Integer> inorder = new ArrayList<Integer>();
    	for (int i = 0; i < inorder.size()-1; i++) {
    		if (inorder.get(i) > inorder.get(i+1)) return false; 
    	}
    	return true;
    }
    
    public void inorderTraversal(TreeNode root, ArrayList<Integer> result) {
    	if (root == null) return;
    	inorderTraversal(root.left, result);
    	result.add(root.val);
    	inorderTraversal(root.right, result);
    }
}