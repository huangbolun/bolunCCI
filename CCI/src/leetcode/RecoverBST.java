package leetcode;

import java.util.ArrayList;

import leetcode.IsValidBST.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class RecoverBST {
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        boolean f = false;
        TreeNode second = null;
        ArrayList<TreeNode> inorder = new ArrayList<TreeNode>();
        inorderTraversal(inorder, root);
        for (int i = 0; i < inorder.size(); i++) {
            if (i == 0) {
            	//System.out.println("!");
                if (inorder.get(i).val > inorder.get(i+1).val) {
                    if (!f) {
                        first = inorder.get(i);
                        f = true;
                    } else
                        second = inorder.get(i);
                }
            } else if (i == inorder.size()-1) {
            	//System.out.println("!!");
                if (inorder.get(i).val < inorder.get(i-1).val) {
                    if (!f) {
                        first = inorder.get(i);
                        f = true;
                    } else
                        second = inorder.get(i);
                }
            } else {
                if (inorder.get(i).val < inorder.get(i-1).val || inorder.get(i).val > inorder.get(i+1).val) {
                    if (!f) {
                        first = inorder.get(i);
                        f = true;
                    } else
                        second = inorder.get(i);
                }
            }
        }
        //System.out.println(first.val+" "+second.val);
        if (first == null || second == null) {
        	return; // no change
        } else {
            int val = first.val;
            first.val = second.val;
            second.val = val;
        }
        return;
    }
    
    public void inorderTraversal(ArrayList<TreeNode> inorder, TreeNode root) {
        if (root == null) return;
        inorderTraversal(inorder, root.left);
        inorder.add(root);
        inorderTraversal(inorder, root.right);
        return;
    }
    
    public static void main(String[] args) {
    	RecoverBST r = new RecoverBST();
    	TreeNode root = new TreeNode(0);
    	root.left = new TreeNode(1);
    	r.recoverTree(root);
    }
}