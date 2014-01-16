package leetcode;

import java.util.ArrayList;

import leetcode.IsValidBST.TreeNode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null)
            return true;
        else {
            // inorder traversal
            ArrayList<Integer> inorder = new ArrayList<Integer>();
            inorderTraversal(inorder, root);
            if (inorder.size()%2 == 0) return false;
            for (int i = 0; i < inorder.size()/2; i++) {
                if (inorder.get(i) != inorder.get(inorder.size()-1-i)) return false;
            }
            return true;
        }
    }
    
    public void inorderTraversal(ArrayList<Integer> inorder, TreeNode root) {
        if (root == null) {
            inorder.add(-1);
            return;
        }
        if (root.left == null && root.right == null) { // leaf
            inorder.add(root.val);
            return;
        } else {
            inorderTraversal(inorder, root.left);
            inorder.add(root.val);
            inorderTraversal(inorder, root.right);
        }
        return;
    }
}